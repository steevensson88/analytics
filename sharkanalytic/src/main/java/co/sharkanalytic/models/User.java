package co.sharkanalytic.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private String email;

	@NotNull
	private String name;

	public User() {

	}

	public User(int id) {
		this.id = id;
	}

	public User(String email, String name) {
		this.email = email;
		this.name = name;
	}
}
