package hib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.model.Address;
import hib.model.UserDetails;
import hib.model.Vehicle;

public class HibTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
										  .configure()
										  .buildSessionFactory();
		
		
		// embeddable -- ex 1
		/*UserDetails user=new UserDetails();
		user.setUserName("First User");
		
		Address adrs1=new Address();
		adrs1.setStreet("street123");
		
		user.setAddress(adrs1);
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		
		session.getTransaction().commit();
		session.close();*/
		
		
		// one2one -- ex 2
		/*Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user=new UserDetails();
		user.setUserName("vehicle User");
		
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Jeep");
		
		user.setVehicle(v1);
		
		session.save(v1);
		session.save(user);
		
		session.getTransaction().commit();
		session.close();*/
		
		
		//@ElementCollection -- ex 3
		/*Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user=new UserDetails();
		user.setUserName("user123");
		
		Address address1=new Address();
		address1.setStreet("stree1");
		
		Address address2=new Address();
		address2.setStreet("stree2");
		
		user.getListOfAddress().add(address1);
		user.getListOfAddress().add(address2);
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();*/
		
		
		//one2many -- ex 4
		/*Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user=new UserDetails();
		user.setUserName("vehicle User1");
		
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Jeep");
		
		Vehicle v2=new Vehicle();
		v2.setVehicleName("Car");
		
		user.getVehicleList().add(v1);
		user.getVehicleList().add(v2);
		
		
		session.save(user);
		session.save(v2);
		session.save(v1);
		
		session.getTransaction().commit();
		session.close();*/
		
		//one2many + many2one -- ex 5  extra table USER_DETAILS_VEHICLE, even though VEHICLE has USER_ID
		/*Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user=new UserDetails();
		user.setUserName("vehicle User1");
		
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Jeep");
		
		Vehicle v2=new Vehicle();
		v2.setVehicleName("Car");
		
		user.getVehicleList().add(v1);
		user.getVehicleList().add(v2);
		
		v1.setUser(user);
		v2.setUser(user);
		
		session.save(user);
		session.save(v2);
		session.save(v1);
		
		session.getTransaction().commit();
		session.close();*/
		
		
		//one2many(mappedby) + many2one -- ex 6  not reqd extra table USER_DETAILS_VEHICLE as already mapped by USER_ID(mys)in VEHICLE
		/*Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user=new UserDetails();
		user.setUserName("vehicle User1");
		
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Jeep");
		
		Vehicle v2=new Vehicle();
		v2.setVehicleName("Car");
		
		user.getVehicleList().add(v1);
		user.getVehicleList().add(v2);
		
		v1.setUser(user);
		v2.setUser(user);
		
		session.save(user);
		session.save(v2);
		session.save(v1);
		
		session.getTransaction().commit();
		session.close();*/
		
		//many2many -- ex 7 VEHICLE_USER_DETAIL and USER_DETAILS_VEHICLE both are created BUT we want only one
		/*Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user1=new UserDetails();
		user1.setUserName("vehicle User1");
		
		UserDetails user2=new UserDetails();
		user2.setUserName("vehicle User2");
		
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Jeep");
		
		Vehicle v2=new Vehicle();
		v2.setVehicleName("Car");
		
		Vehicle v3=new Vehicle();
		v3.setVehicleName("Truck");
		
		
		
		user1.getVehicleList().add(v1);
		user1.getVehicleList().add(v2);
		user1.getVehicleList().add(v3);
		
		user2.getVehicleList().add(v1);
		user2.getVehicleList().add(v2);
		user2.getVehicleList().add(v3);
		
		v1.getListOfUsers().add(user1);
		v1.getListOfUsers().add(user2);
		
		v2.getListOfUsers().add(user1);
		v2.getListOfUsers().add(user2);
		
		v3.getListOfUsers().add(user1);
		v3.getListOfUsers().add(user2);
		
		session.save(v1);
		session.save(v2);
		session.save(v3);
		session.save(user1);
		session.save(user2);
		
		session.getTransaction().commit();
		session.close();*/
		
		//many2many -- ex 8 since mappedBy is in VEHICLE class VEHICLE_USER_DETAIL won't be created but USER_DETAILS_VEHICLE 
		/*Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user1=new UserDetails();
		user1.setUserName("vehicle User1");
		
		UserDetails user2=new UserDetails();
		user2.setUserName("vehicle User2");
		
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Jeep");
		
		Vehicle v2=new Vehicle();
		v2.setVehicleName("Car");
		
		Vehicle v3=new Vehicle();
		v3.setVehicleName("Truck");
		
		
		
		user1.getVehicleList().add(v1);
		user1.getVehicleList().add(v2);
		user1.getVehicleList().add(v3);
		
		user2.getVehicleList().add(v1);
		user2.getVehicleList().add(v2);
		user2.getVehicleList().add(v3);
		
		v1.getListOfUsers().add(user1);
		v1.getListOfUsers().add(user2);
		
		v2.getListOfUsers().add(user1);
		v2.getListOfUsers().add(user2);
		
		v3.getListOfUsers().add(user1);
		v3.getListOfUsers().add(user2);
		
		session.save(v1);
		session.save(v2);
		session.save(v3);
		session.save(user1);
		session.save(user2);
		
		session.getTransaction().commit();
		session.close();*/
		
		//many2many -- ex 9 using jointable and joincoulmn
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user1=new UserDetails();
		user1.setUserName("vehicle User1");
		
		UserDetails user2=new UserDetails();
		user2.setUserName("vehicle User2");
		
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Jeep");
		
		Vehicle v2=new Vehicle();
		v2.setVehicleName("Car");
		
		Vehicle v3=new Vehicle();
		v3.setVehicleName("Truck");
		
		
		
		user1.getVehicleList().add(v1);
		user1.getVehicleList().add(v2);
		user1.getVehicleList().add(v3);
		
		user2.getVehicleList().add(v1);
		user2.getVehicleList().add(v2);
		user2.getVehicleList().add(v3);
		
		v1.getListOfUsers().add(user1);
		v1.getListOfUsers().add(user2);
		
		v2.getListOfUsers().add(user1);
		v2.getListOfUsers().add(user2);
		
		v3.getListOfUsers().add(user1);
		v3.getListOfUsers().add(user2);
		
		session.save(v1);
		session.save(v2);
		session.save(v3);
		session.save(user1);
		session.save(user2);
		
		session.getTransaction().commit();
		session.close();

	}

}
