package co.sharkanalytic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import co.sharkanalytic.models.Client;

@Service
public interface ClientRepository extends JpaRepository<Client, Integer> {

}