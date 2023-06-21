package com.nt.service;

import java.util.Set;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;

public interface IPersonManegement {
public String	saveDataUsingPerson(Person par);
public String	saveDataUsingPhoneNumber(Set<PhoneNumber> phn);

public Iterable<Person> loadDataUsingparent();
public Iterable<PhoneNumber>loadDataUsingChild();
public String deletePhoneNumbers(int pid);
}
