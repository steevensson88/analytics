package co.sharkanalytic.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sharkanalytic.models.Client;

@Controller
public class ImportController {
	private XSSFWorkbook wb;
	
	@RequestMapping(value = "/import",method=RequestMethod.GET)
	public String home() {
		return "import";
	}
	
	@RequestMapping(value = "/postFile",method=RequestMethod.GET)
	@ResponseBody
	public List<Client> readFile() throws IOException {
		FileInputStream file=new FileInputStream("D:\\GABI\\test.xlsx");
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
				clt.setNom_client(nom.getStringCellValue());
			}
			
			if(numcpte.getCellType()==Cell.CELL_TYPE_STRING){
				clt.setNum_compte_client(numcpte.getStringCellValue());
			}
			
			if(mtn.getCellType()==Cell.CELL_TYPE_NUMERIC){
				clt.setMontant_compte(mtn.getNumericCellValue());
			}
			
			if(solde.getCellType()==Cell.CELL_TYPE_NUMERIC){
				clt.setSolde_compte(solde.getNumericCellValue());
			}
			
			if(datecreation.getCellType()==Cell.CELL_TYPE_STRING){
				DateFormat df= new SimpleDateFormat("yyyy/MM/dd");
				try{
					Date datec=df.parse(datecreation.getStringCellValue());
					clt.setDatecreation(datec);
				}
				catch(ParseException e){
					e.printStackTrace();
				}
				
			}
			clients.add(clt);
		}
		return clients;
	}
	
}
