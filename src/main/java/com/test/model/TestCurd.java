package com.test.model;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;



public class TestCurd {
	public static void main(String[] args) {
		//addCustomer();
		getCustomer();
		
		
	}
	

	private static  void deleteCustomer() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Employee e =(Employee) session.get(Employee.class,3);
		
		session.delete(e);
	}

	private static  void updateCustomer() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Employee e =(Employee) session.get(Employee.class,3);
		
		session.update(e);
//		
//		Employee emp=new Employee();
//		emp.setAge("d");
//		emp.setCity("sdf");
//		emp.setFname("af");
//		emp.setLname("sdfg");
//		emp.setPhone("fg");
     	session.update(e); //insert
		session.getTransaction().commit();//sql fire 
		session.close();
		// TODO Auto-generated method stub

	}

	private static  void addCustomer() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setAge("d");
		
		emp.setFname("af");
		emp.setLname("sdfg");
		emp.setPhone("fg");
		session.save(emp); //insert
		session.getTransaction().commit();//sql fire 
		session.close();
		// TODO Auto-generated method stub

	}
	private static  void getCustomer() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		//session.beginTransaction();
		Criteria crt=session.createCriteria(Employee.class);
		//crt.add(Restrictions.eq("id", 1));
		crt.addOrder(Order.asc("fname"));//in ascending order of fname
		//crt.add(Restrictions.eq("city","kathmandu" ));//city is ktm
		//crt.add(Restrictions.eq("age","35" ));//city is ktm and age is 35
		//crt.add(Restrictions.in("age",Arrays.asList("Dang","Pokhara") ));// like or operator city is dang or pokhara and age is 35
		
		
		
		
		List<Employee> list=crt.list();
		list.forEach(System.out::println);
		
//		Employee emp=new Employee();
//		emp.getAge("d");
//		emp.setCity("sdf");
//		emp.setFname("sdf");
//		emp.setLname("sdfg");
//		emp.setPhone("fg");
//		session.save(emp); //insert
//		session.getTransaction().commit();//sql fire 
//		session.close();
		// TODO Auto-generated method stub

	}
}
