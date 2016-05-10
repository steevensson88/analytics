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

import co.sharkanalytic.models.Client;
import co.sharkanalytic.repository.ClientRepository;

public class ClientService {
	@Autowired
	ClientRepository clientrepository;
	
	private XSSFWorkbook wb;
	
	public ClientService() {
		
	}

	public List<Client> readFile(FileInputStream file) throws IOException {
		//FileInputStream file=new FileInputStream("D:\\GABI\\test.xlsx");
		wb = new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheetAt(0);
		List<Client> clients= new ArrayList<Client>();
		for(Row ligne : sheet){
			Client clt=new Client();
			
			Cell nom=ligne.getCell(0);
			Cell numcpte=ligne.getCell(1);
			Cell mtn=ligne.getCell(2);
			Cell solde=ligne.getCell(3);
			Cell datecreation=ligne.getCell(4);
			
			if(nom.getCellType()==Cell.CELL_TYPE_STRING){
				clt.setNomClient(nom.getStringCellValue());
			}
			
			if(numcpte.getCellType()==Cell.CELL_TYPE_STRING){
				clt.setNumcompteClient(numcpte.getStringCellValue());
			}
			
			if(mtn.getCellType()==Cell.CELL_TYPE_NUMERIC){
				clt.setMontantCompte(mtn.getNumericCellValue());
			}
			
			if(solde.getCellType()==Cell.CELL_TYPE_NUMERIC){
				clt.setSoldeCompte(solde.getNumericCellValue());
			}
			
			if(datecreation.getCellType()==Cell.CELL_TYPE_NUMERIC){
				if(DateUtil.isCellDateFormatted(datecreation)){
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
	
	public void add(Client client) {
		System.out.print(client);
		clientrepository.saveAndFlush(client);
	}
}
