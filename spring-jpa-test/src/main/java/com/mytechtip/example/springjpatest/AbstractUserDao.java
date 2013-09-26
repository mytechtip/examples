package com.mytechtip.example.springjpatest;

import java.util.List;

public abstract class AbstractUserDao {

	protected static final int ONE_YEAR = 1000 * 60 * 60 * 24 * 365;

	public abstract List<User> getNameStartsWith(String namePrefix);

	public abstract User save(User u);
}