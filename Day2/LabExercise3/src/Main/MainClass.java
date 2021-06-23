package Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Optional;

import DAO.CitiesDAO;
import DAO.City;
import DAO.CountryDAO;
import PyramidExplore.Pyramid;
import country_cities.Cities;
import country_cities.Countries;
import static java.util.stream.Collectors.toList;

public class MainClass {
	public static void main(String[] args) {
		CitiesDAO c_class= new CitiesDAO();
		List<Cities> city_list= c_class.readCity("cities.csv");
		CountryDAO c= new CountryDAO();
		List<Countries> country_list=c.readCountry("countries.csv");
		System.out.println(country_list);
		//System.out.println(city_list);
		//Highest population city of each country
		//Function<Countries,String> f=(p)-> {return p.getIso3();} ;
	  Map<String,List<Cities>> c1 =city_list.stream().sorted((o1,o2) ->{return (int) (o1.getPopulation()-o2.getPopulation());}).collect(Collectors.groupingBy(Cities::getIso3));
	 System.out.println(c1.values().toArray()[0]);
	 //Highest population capital
	  Map<String,List<Cities>> c2 =city_list.stream().sorted((o1,o2) ->{return (int) (o1.getPopulation()-o2.getPopulation());}).collect(Collectors.groupingBy(Cities::getCapital));
	  System.out.println(c2.values().toArray()[0]);

}}


	
