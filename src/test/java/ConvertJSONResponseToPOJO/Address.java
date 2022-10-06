package ConvertJSONResponseToPOJO;

public class Address {
	
	private int housenumber;
	private String city;
	private String State;
	private String country;
	
	
	public int getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
