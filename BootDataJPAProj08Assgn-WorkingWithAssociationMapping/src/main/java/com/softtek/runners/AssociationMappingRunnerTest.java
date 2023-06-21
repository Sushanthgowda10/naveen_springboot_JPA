package com.softtek.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.softtek.entity.Person;
import com.softtek.entity.PhoneNumber;
import com.softtek.service.IPersonMgmtService;

@Component
public class AssociationMappingRunnerTest implements CommandLineRunner {

	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * // save Object Operation (parent to child) Person person = new Person();
		 * person.setPname("Naveen"); person.setPaddrs("Bangalore");
		 * 
		 * PhoneNumber ph1 = new PhoneNumber(); ph1.setPhoneNumber(7892442572L);
		 * ph1.setNumber_type("Office"); ph1.setProvider("Airtel");
		 * ph1.setPerson(person);// child To parent
		 * 
		 * PhoneNumber ph2 = new PhoneNumber(); ph2.setPhoneNumber(8105783462L);
		 * ph2.setNumber_type("Home"); ph2.setProvider("Jio"); ph2.setPerson(person);//
		 * child To parent // Many to one
		 * 
		 * Set<PhoneNumber> phonesSet = Set.of(ph1, ph2);
		 * 
		 * person.setPhone(phonesSet);// Parent to Children(One to Many)
		 * 
		 * try { System.out.println(service.saveDataUsingPerson(person)); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */

		// save Object Operation (Child to parent)
		/*
		 * PhoneNumber ph3 = new PhoneNumber(); ph3.setPhoneNumber(9972626959L);
		 * ph3.setNumber_type("Personal"); ph3.setProvider("Vodafone");
		 * 
		 * PhoneNumber ph4 = new PhoneNumber(); ph4.setPhoneNumber(8453408659L);
		 * ph4.setNumber_type("Home"); ph4.setProvider("MTS");
		 * 
		 * Person person1 = new Person(); person1.setPname("Varun");
		 * person1.setPaddrs("Chintamani");
		 * 
		 * ph3.setPerson(person1); ph4.setPerson(person1);
		 * 
		 * Set<PhoneNumber> phoneSet = new HashSet<PhoneNumber>(); phoneSet.add(ph3);
		 * phoneSet.add(ph4);
		 * 
		 * person1.setPhone(phoneSet);
		 * 
		 * try { System.out.println(service.saveDataUsingPhoneNumbers(phoneSet)); }
		 * catch (Exception e) { // TODO: handle exception }
		 */

//		service.loadDataUsingParent().forEach(person -> {
//			System.out.println("Parent:: " + person);
//			Set<PhoneNumber> childs = person.getPhone();
////			childs.forEach(ph -> {
////				System.out.println("Child:: " + ph);
////			});
//		});

//		service.loadDataUsingChild().forEach(ph -> {
//			System.out.println("child:: " + ph);
//			// get associated Parent(person)
//			Person person = ph.getPerson();
//			System.out.println("Person :: " + person);
//		});

		System.out.println(service.removeAllPhoneNumbersOfaPerson(2));

	}

}
