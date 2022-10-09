package com.greatlearning.web_customer_tracker2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	//defining fields
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	
	@Column( name = "Id")
	private int Id;
	
    @Column( name = "FirstName" )
     private String FirstName;
	
	@Column( name = "LastName" )
     private String LastName;
	
	@Column( name = "Email" )
     private String Email;

     //define constructors
	
	public Customer() {
		super();
	
	}

	public Customer(int id, String firstName, String lastName, String email) {
		super();
	    Id = id;
	    FirstName = firstName;
		LastName = lastName;
		Email = email;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Customer [Id = " + Id + " FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + "]";
	}
	
}
