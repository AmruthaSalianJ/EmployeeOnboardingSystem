package com.eob.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.eob.entity.User;
 
@Component
public class UserProcessor implements ItemProcessor<User,User>{
 
	@Override
	public User process(User item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}
 
}

