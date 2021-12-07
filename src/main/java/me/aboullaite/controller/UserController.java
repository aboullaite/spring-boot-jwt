package me.aboullaite.controller;

import java.util.Date;

import javax.servlet.ServletException;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userService.save(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody User login) throws ServletException {
		String jwtToken;

		if (login.getEmail() == null || login.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String email = login.getEmail();
		String password = login.getPassword();

		User user = userService.findByEmail(email);

		if (user == null) {
			throw new ServletException("User email not found.");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return jwtToken;
	}
}
