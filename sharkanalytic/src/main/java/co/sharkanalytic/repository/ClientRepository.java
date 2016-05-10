package co.sharkanalytic.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import co.sharkanalytic.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
