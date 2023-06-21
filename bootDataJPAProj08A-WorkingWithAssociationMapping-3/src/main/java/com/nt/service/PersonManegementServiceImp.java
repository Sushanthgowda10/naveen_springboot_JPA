package com.nt.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumber;

@Service
public class PersonManegementServiceImp implements IPersonManegement {
	@Autowired
	private IPersonRepository parRepo;

	@Autowired
	private IPhoneNumber phoneRepo;

	@Override
	public String saveDataUsingPerson(Person par) {
		return " person and  phonenumber are saved with" + parRepo.save(par) + "id value";

	}

	@Override
	public String saveDataUsingPhoneNumber(Set<PhoneNumber> phn) {
		int count = phoneRepo.saveAll(phn).size();

		return count + " no of phonenumbers objts mapped with person obj are saved";

	}
	@Override
	public Iterable<Person> loadDataUsingparent() {
		Iterable<Person> it = parRepo.findAll();
		return it;
	}

	public Iterable<PhoneNumber> loadDataUsingChild() {
		return	phoneRepo.findAll();
	}
		
	// delete method
		@Override
		public String deletePhoneNumbers(int pid) {
			Optional<Person> id = parRepo.findById(pid);
			if(id.isEmpty()) {
				System.out.println("Person didnt found with the id " +pid ); }
			
			Person person = id.get();
			Set<PhoneNumber> phones = person.getPhhn();
			int count=phones.size();
			phoneRepo.deleteAll(phones);
			person.setPhhn(null);
			parRepo.save(person);
			
			return count+ "no of phone numbers are deleted from account" ;
			}
		
		//no of phone numbers are deleted from account
		}
