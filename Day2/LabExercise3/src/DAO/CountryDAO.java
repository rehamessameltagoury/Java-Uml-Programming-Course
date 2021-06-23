package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import country_cities.Countries;

public class CountryDAO implements Country {

	@Override
	public List<Countries> readCountry(String path) {
		// TODO Auto-generated method stub
		// Read a file
				 List<Countries> countryData=new  ArrayList<>();
			        try {
			            Scanner scan=new Scanner(new File(path));
			            if(scan.hasNextLine()) scan.nextLine();
			           while( scan.hasNextLine()){ 
			              String line=scan.nextLine();
			              String [] parts=line.split(",");
			              Countries c=new Countries(parts[0],parts[1]);
			              countryData.add(c);
			           }
			        } catch (FileNotFoundException ex) {
			            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
			        }
			        return countryData;
			}
	}


