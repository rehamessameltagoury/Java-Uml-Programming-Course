package country_cities;

public class Countries {
	private String country,iso3;
     
	public Countries(String country, String iso3) {
		super();
		this.country = country;
		this.iso3 = iso3;
	}

	@Override
	public String toString() {
		return "Countries [country=" + country + ", iso3=" + iso3 + "]";
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
