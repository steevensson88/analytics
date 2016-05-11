package co.sharkanalytic.services;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import co.sharkanalytic.models.Client;

public interface ClientService {

	public List<Client> getAll();

	public void importFile(MultipartFile file);

	public void addAll(List<Client> client);
}
