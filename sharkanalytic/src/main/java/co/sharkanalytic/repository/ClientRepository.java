package co.sharkanalytic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.sharkanalytic.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	

}
