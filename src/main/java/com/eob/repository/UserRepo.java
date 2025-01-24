package com.eob.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eob.entity.User;

@Repository
@ComponentScan
public interface UserRepo extends JpaRepository<User, Integer> {
	 User findByEmail(String email);

}
