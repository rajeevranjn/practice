package hib.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	
	//one2many + many2one -- ex  5,6
	/*@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails user;
	
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}*/
	
	//many2many -- ex 7
	/*@ManyToMany
	private List<UserDetails> listOfUsers = new ArrayList<>();
	public List<UserDetails> getListOfUsers() {
		return listOfUsers;
	}
	public void setListOfUsers(List<UserDetails> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}*/
	
	//many2many(mappedBy) -- ex 8
	@ManyToMany(mappedBy="vehicleList")
	private List<UserDetails> listOfUsers = new ArrayList<>();
	public List<UserDetails> getListOfUsers() {
		return listOfUsers;
	}
	public void setListOfUsers(List<UserDetails> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	private String vehicleName;
	
	@Override
	public String toString() {
		
		return this.vehicleName+":"+this.vehicleId;
	}

}
