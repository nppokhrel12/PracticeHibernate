package com.test.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", age=" + age
				+ "]";
	}
	
	
	public Employee( String fname, String lname, String phone, String age, Address address) {
		super();
		
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.age = age;
		this.address = address;
	}

	public Employee(){
		
	}

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String phone;
	@Column
	private String age;
	@OneToMany(mappedBy="employee")
	private List<Phone> phones;
	@ManyToMany(mappedBy="employee")
	@JoinTable(name="emp_dept",joinColumns= {@JoinColumn(name="empId")}, inverseJoinColumns= {@JoinColumn(name="deptId")})
	private List<Department> deptlist;
	
	
	
	
	
	public List<Department> getDeptlist() {
		return deptlist;
	}


	public void setDeptlist(List<Department> deptlist) {
		this.deptlist = deptlist;
	}


	public List<Phone> getPhones() {
		return phones;
	}


	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	

}
