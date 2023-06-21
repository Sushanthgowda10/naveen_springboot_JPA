package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.EmployeeInfo;
import com.nt.repository.EmployeeInfoRepository;
@Component
public class CollectionMappiingTestRunner implements CommandLineRunner{

	@Autowired
	private EmployeeInfoRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		EmployeeInfo info = new EmployeeInfo();
		info.setEname("sush");
		info.setFriends(List.of("Ashik","nandish"));
		info.setPhones(Set.of(12345678L,98765454L));
		info.setIdDetails(Map.of("aadar",2345678L,"panno",98765456786567L));
		
		System.out.println("Employee is saved with::"+empRepo.save(info).getEno()+"id values");
		empRepo.findAll().forEach(System.out::println);
	}
	

}
