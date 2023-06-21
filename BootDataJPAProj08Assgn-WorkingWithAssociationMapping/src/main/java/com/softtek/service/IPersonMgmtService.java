package com.softtek.service;

import java.util.Set;

import com.softtek.entity.Person;
import com.softtek.entity.PhoneNumber;

public interface IPersonMgmtService {
	public String saveDataUsingPerson(Person per);

	public String saveDataUsingPhoneNumbers(Set<PhoneNumber> phoneSet);

	public Iterable<Person> loadDataUsingParent();

	public Iterable<PhoneNumber> loadDataUsingChild();

	public String deleteAllPhoneNumbersOfaPerson(int pid);

	public String removeAllPhoneNumbersOfaPerson(int pid);
}
