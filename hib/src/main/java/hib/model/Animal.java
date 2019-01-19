package hib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANIMAL")
public class Animal {
	
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name="TYPE")
	private String type;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public AnimalGeography getAnimalGeography() {
		return animalGeography;
	}

	public void setAnimalGeography(AnimalGeography animalGeography) {
		this.animalGeography = animalGeography;
	}

	@OneToOne(fetch=FetchType.LAZY)
	private  AnimalGeography animalGeography;
	
	@Override
	public String toString() {
		return this.id+"---"+this.type+"---"+animalGeography.toString();
	}
		
}
