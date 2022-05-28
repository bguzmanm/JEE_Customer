package model;

public class Address {

	private int address_id;
	private String address;
	private String address2;
	private String district;
	private String city;
	private String country;
	
	public Address() {
		super();
	}
	
	public Address(int address_id, String address, String address2, String district, String city, String country) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city = city;
		this.country = country;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address=" + address + ", address2=" + address2 + ", district="
				+ district + ", city=" + city + ", country=" + country + ", getAddress_id()=" + getAddress_id()
				+ ", getAddress()=" + getAddress() + ", getAddress2()=" + getAddress2() + ", getDistrict()="
				+ getDistrict() + ", getCity()=" + getCity() + ", getCountry()=" + getCountry() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
