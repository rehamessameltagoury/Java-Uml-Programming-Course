package DAO;

import java.util.List;

import country_cities.Countries;

public interface Country {
 public List<Countries> readCountry(String path);
}
