package hib.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DummyModel {

	
	
	private int dummyId;
	
	@Column(name="DUMMY_NAME")
	private String dummyName;
}
