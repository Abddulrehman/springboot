package com.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.product.repository.ProductRepository;

//public class UserDetailService implements UserDetailsService   {
//	
//	@Autowired
//	private ProductRepository productRepository;
//
////	@Override
////	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		
////		User user =productRepository.getUserByUserName(username); 
////		
////		if(user==null)
////		{
////			throw new UsernameNotFoundException(" Could Not Fild the User !!");
////		}
////		
////		CustomUserDetail customUserDetail = new CustomUserDetail(user);
////		return customUserDetail;
////	}
//
//}
