package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.entity.User;
import com.product.repository.ProductRepository;
import com.product.repository.UserRepository;


@Service
public class UserService {

	

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
     return userRepository.save(user);
	}

	public List<User> saveUsers(List<User> users) {
       return userRepository.saveAll(users);
	}

	public List<User> getUsers() {
      return userRepository.findAll();
	}

	public User getUserById(int id) {
          return userRepository.findById(id).orElse(null);
	}



	public String deleteUser(int id) {
           userRepository.deleteById(id);
		return "product removed";
	}

	public User updateUser(User user) {
        User exestingUser = userRepository.findById(user.getId()).orElse(null);
		exestingUser.setEmail(user.getEmail());
		exestingUser.setPassword(user.getPassword());
		exestingUser.setRole(user.getPassword());
        return userRepository.save(exestingUser);
	}

}
