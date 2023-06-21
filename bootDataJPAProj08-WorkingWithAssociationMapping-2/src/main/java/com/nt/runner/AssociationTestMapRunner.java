package com.nt.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IPersonManegement;
@Component
public class AssociationTestMapRunner implements CommandLineRunner {
	
	@Autowired
	private IPersonManegement service;

	@Override
	public void run(String... args) throws Exception {
		Person par = new Person();
		par.setPname("sush");
		par.setPaddrs("Bengalore");
		
		PhoneNumber phn1= new PhoneNumber();
		phn1.setNumber_type("office");
		phn1.setPhoneNum(123456L);
		phn1.setProvider("Airtel");
		
		
		
		PhoneNumber phn2= new PhoneNumber();
		phn2.setNumber_type("home");
		phn2.setPhoneNum(98765L);
		phn2.setProvider("Jio");
		
		Set<PhoneNumber> phoneset =Set.of(phn1,phn2);
		par.setPhhn(phoneset);
		
		try {
			System.out.println(service.saveDataUsingPerson(par));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
