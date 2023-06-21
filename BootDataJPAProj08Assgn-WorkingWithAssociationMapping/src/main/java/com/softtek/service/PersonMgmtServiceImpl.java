package com.softtek.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.Person;
import com.softtek.entity.PhoneNumber;
import com.softtek.repository.PersonRepsitory;
import com.softtek.repository.PhoneNumberRepository;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private PersonRepsitory personRepo;

	@Autowired
	private PhoneNumberRepository phoneRepo;

	@Override
	public String saveDataUsingPerson(Person per) {
		if (per != null) {

			return "Person and his PhoneNumbers are saved with " + personRepo.save(per) + "id value";
		} else {
			return "Error with Person entity";
		}
	}

	@Override
	public String saveDataUsingPhoneNumbers(Set<PhoneNumber> phoneSet) {
		int count = phoneRepo.saveAll(phoneSet).size();
		return count + " number of Phone Number objs mapped with Person obj are saved";
	}

	@Override
	public Iterable<Person> loadDataUsingParent() {
		Iterable<Person> list = personRepo.findAll();
		return list;
	}

	@Override
	public Iterable<PhoneNumber> loadDataUsingChild() {
		return phoneRepo.findAll();
	}

	@Override
	public String deleteAllPhoneNumbersOfaPerson(int pid) {
		Optional<Person> opt = personRepo.findById(pid);
		if (opt.isEmpty()) {
			return "person not found";
		} else {
			// get Parent Object
			Person per = opt.get();
			// get all PhoneNumbers(child objs) of a person
			Set<PhoneNumber> phones = per.getPhone();
			int count = phones.size();
			phoneRepo.deleteAll(phones);
			// re-save the Parent object without linked with children
			per.setPhone(null);
			personRepo.save(per);
			return count + "no of PhoneNumbers are deleted for the Person" + pid;
		}
	}

	@Override
	public String removeAllPhoneNumbersOfaPerson(int pid) {
		Optional<Person> opt = personRepo.findById(pid);
		if (opt.isEmpty()) {
			return "Person not Found";
		} else {
			int count = phoneRepo.deleteAllPhoneNumberOfaPersonByPid(pid);
			return count + "no of PhoneNumber are deleted";
		}
	}

}
