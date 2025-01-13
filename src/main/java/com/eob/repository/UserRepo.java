package com.eob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eob.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
