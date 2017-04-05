package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="CUSTOMER")
public class Customer {

	
@Id
@Column(name ="CUSTOMER_PK")
@SequenceGenerator (name = "custSeq", sequenceName= "TEST_SEQ",allocationSize	 =1)
@GeneratedValue(generator = "custSeq")	
private long pk;
@Column (name = "FIRST_NAME")
private String firstName;
@Column (name = "LAST_NAME")
private String lastName;


public long getPk() {
	return pk;
}
public void setPk(long pk) {
	this.pk = pk;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
@Override
public String toString() {
	return "Customer [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}
}
