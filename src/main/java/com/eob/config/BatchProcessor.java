package com.eob.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eob.entity.User;
import com.eob.repository.UserRepo;



@Component
public class BatchProcessor implements ItemProcessor<User,User>{
 
	 @Autowired
	    private UserRepo userRepo;
	@Override
	public User process(User user) throws Exception {
		  User existingUser = userRepo.findByEmail(user.getEmail());
	        
	        if (existingUser != null) {
	            
	            return null;  
	        }
	        
	       
	        return user;
	}
 
}
