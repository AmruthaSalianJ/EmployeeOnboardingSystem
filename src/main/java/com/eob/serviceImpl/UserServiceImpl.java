//package com.eob.serviceImpl;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.eob.DTO.UserDTO;
//import com.eob.entity.User;
//import com.eob.repository.UserRepo;
//import com.eob.service.UserService;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	
//	@Autowired
//	private ModelMapper mapper;
//	
//	@Autowired
//	private UserRepo userRepo;
//	
//	@Override
//	public UserDTO newuser(UserDTO userDTO) {
//		
//		User user = this.dtoToUser(userDTO);
//		
//		User saved =  userRepo.save(user);
//		return this.UserToDto(saved);
//	}
//	
//	
//	
//	public User dtoToUser(UserDTO userDTO)
//	{
//		User user = this.mapper.map(userDTO, User.class);
//		
//		return user;
//	}
//	
//	
//	public UserDTO UserToDto(User user)
//	{
//		UserDTO userDTO = this.mapper.map(user, UserDTO.class);
//		
//		return userDTO;
//	}
//
//
//
//}
