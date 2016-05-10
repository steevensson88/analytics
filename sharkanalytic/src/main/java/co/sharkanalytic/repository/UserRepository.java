package co.sharkanalytic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.sharkanalytic.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	

}
