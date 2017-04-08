package com.cubic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")

@NamedQueries({ @NamedQuery(name = QueryConstants.CUSTOMER_SELECT_ALL, query = "select c from Customer c"),
		@NamedQuery(name = QueryConstants.CUSTOMER_SEARCH, query = "select c from Customer c where upper(c.firstName) like upper(:p1) and upper(c.lastName) like upper(:p2)"),
		@NamedQuery(name = QueryConstants.CUSTOMER_COUNT, query = "select count(c) from Customer c")

})

@NamedNativeQueries({
		@NamedNativeQuery(name = QueryConstants.NATIVE_CUSTOMER_SELECT_ALL, query = "select CUSTOMER_PK,FIRST_NAME,LAST_NAME from CUSTOMER", resultClass = Customer.class),
		@NamedNativeQuery(name = QueryConstants.NATIVE_CUSTOMER_SEARCH, query = "select FIRST_NAME,LAST_NAME from CUSTOMER")

})

public class Customer {

	@Id
	@Column(name = "CUSTOMER_PK")
	@SequenceGenerator(name = "custSeq", sequenceName = "TEST_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "custSeq")
	private long pk;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	private CustomerInfo customerinfo;

	public CustomerInfo getCustomerinfo() {
		return customerinfo;
	}

	public void setCustomerinfo(CustomerInfo customerinfo) {
		this.customerinfo = customerinfo;
	}

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
