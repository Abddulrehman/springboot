package com.product.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.entity.User;
import com.product.repository.ProductRepository;
import com.product.repository.UserRepository;
import com.product.service.ProductService;
import com.product.service.UserService;

//@org.springframework.stereotype.Controller
//@RequestMapping("/users")
//@RequestMapping("/")

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String showHome() {

		return "index.html";
	}

	@GetMapping("/users/validate")
	public String showHome(@ModelAttribute("user") User user, Model model) {

		List<User> list = userService.getUsers();
		for (int i = 0; i <= list.size(); i++) 
		{
			User user1 = list.get(i);
			
			if ((user1.getEmail().equals(user.getEmail())) && (user1.getRole().equals(user.getRole()))
					&& (user1.getRole().equals("ADMIN"))) {

				return "redirect:/users/viewAllGroups";
				
         } else {}

		}
		return "error.html";
     }


	@GetMapping("/users/add")
	public String addUser() {
		return "addUser.html";

	}

	@PostMapping("/users/addGroup")
	public String addUser1(@ModelAttribute("addUders") User user, Model model) {
		Map map = new LinkedHashMap<>();
		map.put(user.getName(), user);
		model.addAttribute("map", map.values());
		userService.saveUser(user);
		return "redirect:/users/viewAllGroups";

	}

	@GetMapping("/users/viewAllGroups")
	public String getAllUser(Model model) {

		List<User> list = new ArrayList<>();
		model.addAttribute("user", userService.getUsers());

		model.addAttribute("userInfo", new User());
		return "showUser.html";
	}

	@GetMapping("/getById/{id}")
	public User addUser(@PathVariable int id) {
		return userService.getUserById(id);

	}

	@GetMapping("/users/update/{id}")
	public String updateProduct(@PathVariable("id") int id, Model model, User user) {
		model.addAttribute("user", userService.getUserById(id));

		userService.updateUser(user);

		return "updateUser.html";
	}

	@PostMapping("/users/updateUser/{id}")
	public String updateUsers(@PathVariable("id") int id, @ModelAttribute("updateUser") User user, Model model) {
		Map map = new LinkedHashMap<>();
		map.put(user.getName(), user);
		model.addAttribute("map", map.values());
		userService.saveUser(user);

		return "redirect:/users/viewAllGroups";
	}

	@GetMapping("/users/delete/{id}")
	public String delete(@PathVariable int id, Model model, User user) {
		System.out.println(" delete Method called 	");
		String query = userService.deleteUser(id);
		System.out.println("<h2 color='red'> User Has Been Deleted Successfuly! :</h2>");
		return "redirect:/users/viewAllGroups";

	}

	@DeleteMapping("/deleteGroup/{id}")
	public String deleteUser(@PathVariable int id) {
		System.out.println(" delete Method called 	");
		return userService.deleteUser(id);

	}

	@PostMapping("/addGroups")
	public List<User> addUser(@RequestBody List<User> user) {
		return userService.saveUsers(user);

	}

	

}
