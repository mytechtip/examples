package com.mytechtip.example.springjpatest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytechtip.example.springjpatest.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> getNameStartsWith(String prefix);

}
