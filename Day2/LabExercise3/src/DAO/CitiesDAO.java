package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import country_cities.Cities;


public class CitiesDAO implements City{

    @Override
	public List<Cities> readCity(String path) {
		// TODO Auto-generated method stub
		// Read a file
		 List<Cities> cityData=new  ArrayList<>();
	        try {
	            Scanner scan=new Scanner(new File(path));
	            if(scan.hasNextLine()) scan.nextLine();
	           while( scan.hasNextLine()){ 
	              String line=scan.nextLine();
	              String [] parts=line.split(",");
	            
	               double lat=Double.parseDouble(parts[2]);
	              
	               double lng=Double.parseDouble(parts[3]);
	               double id=Double.parseDouble(parts[6]);
	               long pop=Long.parseLong(parts[5]);
	               
	               //System.out.println(pop);
	             // System.out.println(h);
	              ////iso3,city_ascii,lat,lng,capital,population,id
	              Cities c=new Cities(parts[0],parts[1],lat,lng,parts[4],pop,id);
	              cityData.add(c);
	           }
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(CitiesDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return cityData;
	}

}
