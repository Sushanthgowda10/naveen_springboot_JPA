package com.softtek.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PHONE_NUMBER_OTM")
@Setter
@Getter
public class PhoneNumber {

	public PhoneNumber() {
		System.out.println("PhoneNumber:: 0-param constructor :: " + this.getClass());
	}

	@Id
	@GeneratedValue
	private Integer regno;

	private Long phoneNumber;

	@Column(length = 20)
	private String number_type;

	@Column(length = 20)
	private String provider;

	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Person person;

	// Cascading is if one table is saved then save the Parent table data also
	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", phoneNumber=" + phoneNumber + ", number_type=" + number_type
				+ ", provider=" + provider + "]";
	}

}
