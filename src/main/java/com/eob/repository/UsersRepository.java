package com.eob.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eob.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	List<Users> findByUsername(String username);

	@Query(value = "select * from USERS_TBL where username=?1", nativeQuery = true)
	Optional<Users> getByUsername(String username);

}
