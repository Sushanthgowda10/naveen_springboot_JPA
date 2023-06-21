package com.nt.runner;

import java.util.HashSet;
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

		PhoneNumber phn1 = new PhoneNumber();
		phn1.setNumber_type("office");
		phn1.setPhoneNum(123456L);
		phn1.setProvider("Airtel");

		PhoneNumber phn2 = new PhoneNumber();
		phn2.setNumber_type("home");
		phn2.setPhoneNum(98765L);
		phn2.setProvider("Jio");

		Person par = new Person();
		par.setPname("sush");
		par.setPaddrs("Bengalore");
		
		phn1.setPerson(par);
		phn2.setPerson(par);

		Set<PhoneNumber> phoneset = new HashSet<PhoneNumber>();
		phoneset.add(phn1);
		phoneset.add(phn2);

		try {
//			System.out.println(service.saveDataUsingPerson(par));

		} catch (Exception e) {
			e.printStackTrace();
		}

	/*	service.loadDataUsingparent().forEach(person ->{
			System.out.println(("Parent::"+person));
			Set<PhoneNumber>childs = person.getPhn();
			childs.forEach(ph->{
				System.out.println(("child::"+ph));
			});		
		});
		*/
		
		service.loadDataUsingChild().forEach(ph->{
			System.out.println(("child:"+ph));
			Person person =ph.getPerson();
//			System.out.println("Person:: "+person);
		});
		
		String messageDelete = service.deletePhoneNumbers(1);
		System.out.println(messageDelete);
		
	}

}
