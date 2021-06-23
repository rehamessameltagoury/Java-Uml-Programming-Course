package PyramidExplore;

public class Pyramid {
	private double Height=10.2;
	private String modern_name,pharaoh,site;
	 public Pyramid(String pharaoh,String modern_name , String site, double Height) {
	        this.Height = Height;
	        this.modern_name = modern_name;
	        this.pharaoh = pharaoh;
	        this.site=site;
	    }
	public double getHeight() {
		return Height;
	}
	public void setHeight(double height) {
		Height = height;
	}
	public String getModern_name() {
		return modern_name;
	}
	public void setModern_name(String modern_name) {
		this.modern_name = modern_name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPharaoh() {
		return pharaoh;
	}
	public void setPharaoh(String pharaoh) {
		this.pharaoh = pharaoh;
	}
	
	 @Override
	    public String toString() {
	       return "===== Name is : "+this.modern_name+ " and Pharouh is: "+this.pharaoh+"=====" + " The Site is: "+this.site+"===="+" With Height of : "+this.Height+"====";
	
	 

}}
