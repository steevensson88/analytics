package co.sharkanalytic.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;



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
	private ClientService clientservice =new ClientService();
	
	@RequestMapping(value = "/import",method=RequestMethod.GET)
	public String home() {
		return "import";
	}
	
	@RequestMapping(value = "/listClients",method=RequestMethod.GET)
	@ResponseBody
	public List<Client> getAllClients(){
		return clientservice.getAll();
	}
	
	@RequestMapping(value = "/postFile",method=RequestMethod.POST, consumes ={"multipart/form-data"})
	@ResponseBody
	public String postFile(@RequestPart("fichier") MultipartFile file) {
		List<Client> clients;
		try {
			File convfile=new File("D:\\GABI\\excel\\"+file.getOriginalFilename());
			FileInputStream fic=new FileInputStream("D:\\GABI\\excel\\"+file.getOriginalFilename());
			clients = clientservice.readFile(fic);
			for (Client client : clients) {
				clientservice.add(client);
			}
			return "1Opération effectué avec succès";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0Echèc lors de l\'enrégistrement";
		}
	}
}
