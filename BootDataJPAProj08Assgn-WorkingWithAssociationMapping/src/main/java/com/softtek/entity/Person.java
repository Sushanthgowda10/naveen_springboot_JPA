package com.softtek.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSON_One_To_M")
@Setter
@Getter
public class Person {

	public Person() {
		System.out.println("Person :: 0-param constructor :: " + this.getClass());
	}

	@Id
	@GeneratedValue
	@Column(name = "pid", length = 20)
	private Integer id;

	@Column(length = 20)
	private String pname;

	@Column(length = 50)
	private String paddrs;

	// Cascading is if one table is saved then save the Parent table data also
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
//	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Set<PhoneNumber> phone;

	// @Data will get the looping when called the ToString
	@Override
	public String toString() {
		return "Person [pid=" + id + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}

}
