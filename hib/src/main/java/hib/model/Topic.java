package hib.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Topic {
	@Id
	private int topicId;
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	private String topicName;
	
	
	
	
	
	/*@ManyToOne
	private Teacher teacher;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}*/
	
	@ManyToMany(mappedBy="topicList")
	private Collection<Teacher> teacherList = new ArrayList<>();
	public Collection<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(Collection<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
}
