package hib.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	@Id
	private int teacherId;
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	private String teacherName;
	
	/*@OneToMany(mappedBy="teacher")
	private Collection<Topic> topicList = new ArrayList<>();

	public Collection<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(Collection<Topic> topicList) {
		this.topicList = topicList;
	}*/
	
	@ManyToMany
	private Collection<Topic> topicList = new ArrayList<>();

	public Collection<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(Collection<Topic> topicList) {
		this.topicList = topicList;
	}
	
	
}
