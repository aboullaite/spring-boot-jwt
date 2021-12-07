package me.aboullaite.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import me.aboullaite.dao.UserDao;
import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public User save(User user) {
		return userDao.save(user);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
}
