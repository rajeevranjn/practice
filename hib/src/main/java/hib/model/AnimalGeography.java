package hib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ANIMAL_GEOGRAPHY")
public class AnimalGeography {

	@Id @GeneratedValue
	private int id;
	
	@Column(name="DESCRIPTION")
	private String desc;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return this.id+"--"+this.desc;
	}
	
	
}
