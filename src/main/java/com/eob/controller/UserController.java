package com.eob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eob.DTO.UserDTO;
import com.eob.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@PostMapping("/newuser")
	public ResponseEntity<UserDTO> newuser(@RequestBody UserDTO userDTO)
	
	{
		UserDTO saveduser = userService.newuser(userDTO);
		
		return new ResponseEntity<>(saveduser,HttpStatus.CREATED);
	}
}
