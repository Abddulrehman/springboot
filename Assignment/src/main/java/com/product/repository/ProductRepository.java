 package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.entity.Product;
import com.product.entity.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
//	@Query("select * from user where email= :email")
//	public User getUserByUserName(@Param("email") String email);

}
