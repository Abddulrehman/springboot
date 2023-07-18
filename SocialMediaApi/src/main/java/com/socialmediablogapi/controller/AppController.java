package com.socialmediablogapi.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.socialmediablogapi.model.Account;
import com.socialmediablogapi.model.Message;
import com.socialmediablogapi.repository.AccountRepo;
import com.socialmediablogapi.repository.MessageRepository;

@RestController
public class AppController {

	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	MessageRepository messageRepository;
	

	@PostMapping("/login")
	public String showHome(@RequestBody Account account ) {

		List<Account> list = accountRepo.findAll();
		
			
	 List usersList=new ArrayList<>();
			
			usersList=accountRepo.findAll();
			System.out.println(account.getUsername());
			
			System.out.println(usersList);
			if (!(usersList.equals(account.getUsername()))) {

				return "login successfuly";
				
         } else {
        	 return "login successfuly";
         }
		
	}
		
		
	
	@PostMapping("/register")
	public String addUser1(@RequestBody Account account) {
		accountRepo.save(account);
		return "data inserted ";

	}
	
	@PostMapping("/messages")
	public ResponseEntity<?> addMessage(@RequestBody Message message) {
		
		   if (message.getMessage_text() == null || message.getMessage_text().isBlank() || message.getMessage_text().length() > 255) {
	            return ResponseEntity.badRequest().body("Invalid message_text. Please provide a non-blank message_text under 255 characters.");
		
		   }else {

               messageRepository.save(message);
               return ResponseEntity.ok(message);
			
		}
		
		

	}

	

	@GetMapping("/messages/{id}")
	public Optional<Message> getMessages(@PathVariable int id) {
		return messageRepository.findById(id);

	}
	

	
	
	@GetMapping("/messages")
	public List<Message> getMessages() {
		return messageRepository.findAll();

	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		System.out.println(" delete Method called 	");
		 messageRepository.deleteById(id);
		System.out.println("<h2 color='red'> User Has Been Deleted Successfuly! :</h2>");
		return "redirect:/users/viewAllGroups";

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Message> updateProduct(@PathVariable("id") int id, @RequestBody Message message) {
		
		   Message updatedUserData = messageRepository.save( message);
	   
		      return ResponseEntity.ok(updatedUserData);
		
	}


	
}
