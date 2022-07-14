package com.test.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {
	public static void main(String[] args) {
		oneToOne();
		oneToMany();
		manyToMany();
	}

	private static void oneToOne() {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		Address adr=new Address("nepal", "ktm", "fg");
		session.save(adr);
		Employee emp=new Employee("nishani12", "pokhrel", "agfg", "fg", adr);
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	
	//one to many or many to one
	static void oneToMany() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		Address adr=new Address("nepal", "ktm", "fg");
		session.save(adr);
		Employee emp=new Employee("nishani12", "pokhrel", "agfg", "fg", adr);
		
		Phone p1=new Phone();
		p1.setNumber("444444444");
		p1.setType("ntc");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone p2=new Phone();
		p2.setNumber("445555555");
		p2.setType("ncell");
		p2.setEmployee(emp);
		session.save(p2);
		
		emp.setPhones(Arrays.asList(p1,p2));
		
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	
	//many to many
	static void manyToMany() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		Address adr=new Address("nepal", "ktm", "fg");
		session.save(adr);
		Employee emp=new Employee("nishani12", "pokhrel", "agfg", "fg", adr);
		
		Phone p1=new Phone();
		p1.setNumber("444444444");
		p1.setType("ntc");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone p2=new Phone();
		p2.setNumber("445555555");
		p2.setType("ncell");
		p2.setEmployee(emp);
		session.save(p2);
		
		Department d1=new Department();
		d1.setName("account");
		session.save(d1);
		Department d2=new Department();
		d2.setName("IT");
		session.save(d2);
		
		emp.setDeptlist(Arrays.asList(d1,d2));
		
		
		emp.setPhones(Arrays.asList(p1,p2));
		
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
	}

}
