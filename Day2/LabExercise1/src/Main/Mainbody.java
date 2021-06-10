package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.CitiesDAO;
import DAO.CountryDAO;
import country_cities.Cities;
import country_cities.Countries;



public class Mainbody {
	public static <T> void main(String[] args) 
	{
		CitiesDAO c_class= new CitiesDAO();
		//File x = new File("cities.csv");
		//System.out.println();
		//System.out.println(x.canRead());
		List<Cities> city_list= c_class.readCity("cities.csv");
		CountryDAO c= new CountryDAO();
		List<Countries> country_list=c.readCountry("countries.csv");
		//System.out.println(country_list);
		//System.out.println(city_list);
		//int i =0;
		//create a map to merge the country and city
		// sort the map
	    Map<String,List<Cities>>combine=new HashMap<>();
	    
		for(Countries x1 :country_list) 
		{ List<Cities> city = new ArrayList<>();  
			for (Cities x2:city_list) {
				//System.out.println(x2.getIso3());
			   if (x1.getIso3().equals(x2.getIso3()))
					   {
				        city.add(x2);
					   }
					   
			}
			city.sort((ob1,ob2)->(int)ob2.getPopulation()-(int)ob1.getPopulation());
			combine.put(x1.getIso3(),city);
		}
		combine.forEach((k, v) -> 
		System.out.println("key=" + k + ", value=" + v));
		
	
		
		/*
		for(Cities x1 :c_ls) 
		{
			System.out.println("#"+(i++)+ x1.toString());
		}
		
		*/
	}
}
