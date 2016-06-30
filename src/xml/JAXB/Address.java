package xml.JAXB;


public class Address {
	
	private String street;
	private String city;
	
	public Address() {
		street ="unknown";
		city ="unknown";
	}
	
	public Address(String aStreet, String aCity) {
		street = aStreet;
		city = aCity;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

}
