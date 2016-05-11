package co.sharkanalytic.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import co.sharkanalytic.models.Agence;
import co.sharkanalytic.models.Agent;
import co.sharkanalytic.models.Client;
import co.sharkanalytic.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientrepository;

	public void importFile(MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				FileInputStream fic = (FileInputStream) file.getInputStream();
				addAll(readFile(fic));
			} catch (IOException e) {
				e.printStackTrace();
				throw new IllegalStateException(e.getMessage());
			}
		}
		throw new IllegalArgumentException("The file is empty!!!");
	}

	private List<Client> readFile(FileInputStream file) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		wb.close();
		List<Client> clients = new ArrayList<Client>();
		for (Row ligne : sheet) {
			Client clt = new Client();

			Cell nom = ligne.getCell(0);
			Cell numcpte = ligne.getCell(1);
			Cell solde = ligne.getCell(2);
			Cell mtn = ligne.getCell(3);
			Cell nomAgence = ligne.getCell(4);
			Cell agent = ligne.getCell(5);
			Cell datecreation = ligne.getCell(6);

			if (nom.getCellType() == Cell.CELL_TYPE_STRING) {
				clt.setNomClient(nom.getStringCellValue());
			}

			if (numcpte.getCellType() == Cell.CELL_TYPE_STRING) {
				clt.setNumcompteClient(numcpte.getStringCellValue());
			}

			if (mtn.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				clt.setMontantCompte(mtn.getNumericCellValue());
			}

			if (solde.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				clt.setSoldeCompte(solde.getNumericCellValue());
			}

			if (nomAgence.getCellType() == Cell.CELL_TYPE_STRING) {
				Agence newAgence = new Agence();
				newAgence.setNomAgence(nomAgence.getStringCellValue());
				clt.setIdAgence(newAgence);
			}

			if (agent.getCellType() == Cell.CELL_TYPE_STRING) {
				Agent newAgent = new Agent();
				newAgent.setNomAgent(agent.getStringCellValue());
				clt.setIdAgent(newAgent);
			}

			if (datecreation.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				if (DateUtil.isCellDateFormatted(datecreation)) {
					clt.setDatecreation(datecreation.getDateCellValue());
				}
			}
			clients.add(clt);
		}
		return clients;
	}

	public List<Client> getAll() {
		return clientrepository.findAll();
	}

	public void addAll(List<Client> clients) {
		Iterable<Client> lcleints = clients;
		clientrepository.save(lcleints);
	}

}
