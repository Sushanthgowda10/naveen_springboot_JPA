package com.nt.runner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Actor;
import com.nt.service.IActorMgmntService;

@Component
public class JPARepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IActorMgmntService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			//System.out.println(service.removeActorsByIdsBatch(List.of(1,3,4,66,77)));
			
			Actor actor = service.searchActorById(104);
			System.out.println(actor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			// TODO: handle exception
		}
		}
	