package com.nt.service;

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
		return " person and  phonenumber are saved with"+parRepo.save(par)+ "id value";
		
				
	}

	@Override
	public String saveDataUsingPhoneNumber(Set<PhoneNumber> phn) {
		int count =phoneRepo.saveAll(phn).size();
		
		return  count +" no of phonenumbers objts mapped with person obj are saved";
	}

}
