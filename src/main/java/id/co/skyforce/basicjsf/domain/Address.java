package id.co.skyforce.basicjsf.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	

	
	
	

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	
	@Column(name = "street", length = 50, nullable = false)
	private String street;
	
	@Column(name = "city", length = 50, nullable = false)
	private String city;
	
	@Column(name = "postal_code", length = 5, nullable = false)
	private String postalCode;
	
	
	
	public Address(){}
	
	public Address(Long id, Long customerId, String street, String city,
			String postalCode) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(String city) {
		this.city = city;
		return null;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Address setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return null;
	}



}