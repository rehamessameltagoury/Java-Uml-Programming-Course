package country_cities;

public class Cities {
	private String iso3,city_ascii,capital;
	private double lat,lng,id;
	private long population;
	
	
	//iso3,city_ascii,lat,lng,capital,population,id
	public Cities(String iso3, String city_ascii,double lat, double lng, String capital, long population,
			double id) {
		super();
		this.iso3 = iso3;
		this.city_ascii = city_ascii;
		
		this.lat = lat;
		this.lng = lng;
		this.capital = capital;
		this.population = population;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Cities [iso3=" + iso3 + ", city_ascii=" + city_ascii + ", capital=" + capital + ", lat=" + lat
				+ ", lng=" + lng + ", population=" + population + ", id=" + id + "]";
	}

	public String getCity_ascii() {
		return city_ascii;
	}
	public void setCity_ascii(String city_ascii) {
		this.city_ascii = city_ascii;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getIso3() {
		return iso3;
	}
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
}
