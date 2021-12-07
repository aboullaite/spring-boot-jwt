package me.aboullaite.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

@RestController
@RequestMapping("/secure")
@RequiredArgsConstructor
public class SecureController {

	private final UserService userService;

	@RequestMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}

	@PostMapping("/user/email")
	public User findByEmail(@RequestBody String email) {
		return userService.findByEmail(email);
	}

	@PostMapping("/user/update")
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}
}
