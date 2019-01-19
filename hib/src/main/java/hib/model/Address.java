package hib.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Column(name="STREET_NAME")
	private String street;

}
