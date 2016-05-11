package co.sharkanalytic.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import co.sharkanalytic.models.Client;
import co.sharkanalytic.services.ClientService;

@Controller
public class ImportController {

	@Autowired
	private ClientService clientservice;

	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String home() {
		return "import";
	}

	@RequestMapping(value = "/listClients", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> getAllClients() {
		return clientservice.getAll();
	}

	@RequestMapping(value = "/postFile", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void importFile(@RequestPart("fichier") MultipartFile file) {
		// File fil = new File("test.xlsx");
		// DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false,
		// file.getName(), (int) fil.length(),
		// fil.getParentFile());
		// fileItem.getOutputStream();
		// MultipartFile f = new CommonsMultipartFile(fileItem);
		clientservice.importFile(file);
	}
}
