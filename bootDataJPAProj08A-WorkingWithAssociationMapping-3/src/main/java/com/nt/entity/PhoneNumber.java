package com.nt.entity;

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
@Table(name="PHONE_NUMBER_OTM")
@Setter
@Getter

public class PhoneNumber {
	
	@Id
	@GeneratedValue
 private Integer regNum;
 private Long phoneNum;
 
 @Column(length= 20)
 private String  number_type;
 
 @Column(length= 20)
 private String provider;
 
 @ManyToOne(targetEntity=Person.class,cascade= CascadeType.ALL,fetch=FetchType.EAGER)
 @JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")

 private Person person;
 
 public PhoneNumber() {
System.out.println("phoneNumbere:: 0-param constructor"+this.getClass());
 }

@Override
public String toString() {
	return "PhoneNumber [regNum=" + regNum + ", phoneNum=" + phoneNum + ", number_type=" + number_type + ", provider="
			+ provider + "]";
}




 
}
