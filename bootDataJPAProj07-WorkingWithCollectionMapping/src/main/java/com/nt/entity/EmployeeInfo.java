package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EMPLOYEE_INFO_TAB")
@Data


public class EmployeeInfo {
@Id
@GeneratedValue
private Integer eno;


@Column(length = 20)
private String ename;

@ElementCollection // enable the collection mapping
@CollectionTable(name= "EMPLOYEE_FRIENDS", joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName ="ENO"))
@Column(name="FRIEND_NAME",length = 20)// to store list elements
@ListIndexBase(1)

private List<String> friends;
@ElementCollection
@CollectionTable(name= "EMPLOYEE_PHONES", joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName ="ENO"))
@Column(name="PHONE_NUMBER")// to store the Set elements
private Set<Long> phones;
@ElementCollection
@CollectionTable(name= "EMPLOYEE_IDDETAILS", joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName ="ENO"))
@Column(name = "ID_DETAILS") //To store map Elements values
@MapKeyColumn(name = "ID_TYPE",length=20)
private Map<String,Long> idDetails;

}
