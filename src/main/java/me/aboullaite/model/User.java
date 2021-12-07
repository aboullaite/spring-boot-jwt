package me.aboullaite.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@CreationTimestamp
	private Date created;
}
