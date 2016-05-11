package co.sharkanalytic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sharkanalytic.models.User;
import co.sharkanalytic.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userrepository;
	
	public boolean login(User c){
		
		return true;
	}
}
