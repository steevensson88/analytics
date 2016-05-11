package co.sharkanalytic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.sharkanalytic.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	

}
