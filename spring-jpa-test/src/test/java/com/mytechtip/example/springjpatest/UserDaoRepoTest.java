package com.mytechtip.example.springjpatest;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans-test.xml")
@Transactional
public class UserDaoRepoTest {
	
	@Autowired
	UserDaoRepo userDao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNameStartsWith() {
		
		List<User> list = userDao.getNameStartsWith("J");
		assertEquals(1, list.size());
		User user = list.get(0);
		System.out.println(user.getId()+":"+user.getName() + ":" + user.getDob()+":"+user.getAddress());
		assertEquals("Jack", user.getName());
	}

	@Test
	public void testSave() {
		User u = new User();
		u.setAddress("my address");
		u.setName("John Smith");
		
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2000, 0, 1);
		u.setDob(cal.getTime());
		
		userDao.save(u);
		
		List<User> list = userDao.getNameStartsWith("J");
		assertEquals(2, list.size());
		User user = list.get(1);
		System.out.println(user.getId()+":"+user.getName() + ":" + user.getDob()+":"+user.getAddress());
		assertEquals("John Smith", user.getName());
		assertEquals(cal.getTime(), u.getDob());
	}


}
