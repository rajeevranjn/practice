package hib.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	
	//@ElementCollection -- ex 3
	/*@ElementCollection
	@JoinTable(name="USER_ADDRESS")
	private List<Address> listOfAddress = new ArrayList<>();
	
	public List<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	*/
	
	//embeddable ex 1
	/*@Embedded
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	
	
	
	

	
	// one2one -- ex 2
	/*@OneToOne
	private Vehicle vehicle;
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/
	
	// one2many -- ex 5
	/*@OneToMany
	private List<Vehicle> vehicleList = new ArrayList<>();*/
	
	// one2many(mappedby) -- ex 6
	/*@OneToMany(mappedBy="user")
	private List<Vehicle> vehicleList = new ArrayList<>();
	
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}*/
	
	//many2many -- ex 7
	/*@ManyToMany
	private List<Vehicle> vehicleList = new ArrayList<>();
	
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}*/
	
	
	//many2many -- ex 9
	@ManyToMany
	@JoinTable(name="USER_VEHICLES",joinColumns={@JoinColumn(name="USER_ID")}, 
				inverseJoinColumns={@JoinColumn(name="VEHICLE_ID")})
	private List<Vehicle> vehicleList = new ArrayList<>();
	
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return this.userId+":"+this.userName;
	}
}
