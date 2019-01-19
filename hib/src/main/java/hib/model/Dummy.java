package hib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="byIdOnly",query="from Dummy where dummyId=?")
@NamedNativeQuery(name="byNameOnly",query="select * from test_dummy where DUMMY_NAME=?",
				  resultClass=Dummy.class)
@Table(name="test_dummy")
public class Dummy {

	@Id @GeneratedValue
	private int dummyId;
	
	@Column(name="DUMMY_NAME")
	private String dummyName;

	public int getDummyId() {
		return dummyId;
	}

	public void setDummyId(int dummyId) {
		this.dummyId = dummyId;
	}

	public String getDummyName() {
		return dummyName;
	}

	public void setDummyName(String dummyName) {
		this.dummyName = dummyName;
	}
}
