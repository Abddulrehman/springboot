package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.entity.User;
import com.product.repository.ProductRepository;
import com.product.repository.UserRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;

	public String validateUser(User user) {
		List<Product> userList = productRepository.findAll();
		
		System.out.println(userList.get(0)+" >>>>>>>>>>>>>>>>> ");

		return "Test";

	}

//	public User saveUser(Product product) {
//
//		return productRepository.save(product);
//	}

	public List<User> saveUsers(List<User> users) {

		return userRepository.saveAll(users);
	}

	public List<Product> getUsers() {

		return productRepository.findAll();
	}

	public User getUserById(int id) {

		return userRepository.findById(id).orElse(null);
	}

//public Product getProductByName(String name) {
//	
//	return repository.findByName(name);
//}

	public String deleteUser(int id) {

		productRepository.deleteById(id);
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
