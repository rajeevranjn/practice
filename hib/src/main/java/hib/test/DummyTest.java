package hib.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.model.Dummy;

public class DummyTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure()
				.buildSessionFactory();
		
		
		/*Dummy dummy = new Dummy();
		dummy.setDummyName("first dummy");*/
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.save(dummy);
		
		//Dummy dummy=session.get(Dummy.class, 4);
		Query q=session.getNamedQuery("byIdOnly");
		q.setInteger(0, 4);
		List<Dummy> dummys = (List<Dummy>)q.list();
		
		
		Query q2=session.getNamedQuery("byNameOnly");
		q2.setString(0, "first dummy updated agn after session close");
		List<Dummy> dummysFromNmaes = (List<Dummy>)q2.list();
		
		
		session.getTransaction().commit();
		session.close();

		
		/*for(Dummy d:dummys)
			System.out.println(d.getDummyName());*/
		
		
		
		for(Dummy d:dummysFromNmaes)
			System.out.println("thru names ::: "+d.getDummyName());
		
		/*session=sessionFactory.openSession();
		session.beginTransaction();
		dummy.setDummyName("first dummy updated agn234 after session close");
		session.update(dummy);
		
		session.getTransaction().commit();
		session.close();*/
		
	}

}
