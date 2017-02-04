package me.aboullaite.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.aboullaite.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User save(User user);

	User findByEmail(String email);
}
