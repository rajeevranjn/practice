package hib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.model.Teacher;
import hib.model.Topic;

public class TeacherTopicTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		/*Session session = sessionFactory.openSession();
		Topic topic1 = new Topic();
		topic1.setTopicId(10);
		topic1.setTopicName("topic 1");
		
		
		Topic topic2 = new Topic();
		topic2.setTopicId(11);
		topic2.setTopicName("topic 2");
		
		
		Teacher teacher = new Teacher();
		teacher.setTeacherId(20);
		teacher.setTeacherName("teacher 1");
		
		teacher.getTopicList().add(topic1);
		teacher.getTopicList().add(topic2);
		
		topic1.getTeacherList().add(teacher);
		topic2.getTeacherList().add(teacher);
		
		session.beginTransaction();
		
		session.save(teacher);
		session.save(topic1);
		session.save(topic2);
		
		session.getTransaction().commit();
		
		
		session.close();
		
		Session session2 = sessionFactory.openSession();
		
		Teacher teacher2 = (Teacher)session2.load(Teacher.class, 20);
		System.out.println("teacher2---"+teacher2.getTeacherName());
		
		teacher2.setTeacherName("modified...");
		
		Teacher teacher3 = (Teacher)session2.load(Teacher.class, 20);
		
		System.out.println("teacher3---"+teacher3.getTeacherName());
		session2.close();*/
		
		Session session_t1 = sessionFactory.openSession();
		Teacher teacher_t1 = (Teacher)session_t1.load(Teacher.class, 20);
		System.out.println("teacher_t1---"+teacher_t1.getTeacherName());
		session_t1.close();
		
		sessionFactory.close();
		

	}

}
