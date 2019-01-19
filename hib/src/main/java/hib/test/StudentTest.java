package hib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.model.Student;
import hib.model.Subject;



public class StudentTest {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure()
				.buildSessionFactory();

		Subject sub1=new Subject();
		sub1.setSubName("subject one");
		
		Subject sub2=new Subject();
		sub2.setSubName("subject two");
		
		Student student=new Student();
		student.setName("A Student");
		
		sub1.setStudent(student);
		sub2.setStudent(student);
		

		

		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(sub1);
		session.save(sub2);
		session.save(student);
		session.getTransaction().commit();
		session.close();



		
		session.close();

}

}
