package com.mytechtip.example.springjpatest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mytechtip.example.springjpatest.repository.UserRepository;

@Repository
public class UserDaoRepo extends AbstractUserDao {
	
	private static final int ONE_YEAR = 1000 * 60 * 60 * 24 * 365;

	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User save(User u) {
		// some business logic
		if (u.getName()==null) {
			throw new IllegalArgumentException("Name can not be null");
		}
		if (u.getDob()==null) {
			throw new IllegalArgumentException("Dob can not be null");
		}
		if ((System.currentTimeMillis()-u.getDob().getTime())< 10 * ONE_YEAR) {
			throw new IllegalArgumentException("Must be 10+ year older");
		}
		return userRepository.save(u);
	}

	@Transactional
	public List<User> getNameStartsWith(String namePrefix) {
		// use the spring data jpa repository
		return userRepository.getNameStartsWith(namePrefix+"%");
	}
}
