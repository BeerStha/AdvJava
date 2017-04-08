package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerInfo {

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "custInfoSeq", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "customer"))
	@GeneratedValue(generator = "custInfoSeq")
	private Long pk;

	@Column(name = "DESCRIPTION")
	private String desc;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Customer customer;

	@Override
	public String toString() {
		return "CustomerInfo [pk=" + pk + ", desc=" + desc + "]";
	}
}
