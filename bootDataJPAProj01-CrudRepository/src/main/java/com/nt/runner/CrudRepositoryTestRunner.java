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
public class CrudRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IActorMgmntService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("Records count is ::" + service.fetchrecordCount());
			Iterable<Actor> it = service.fetchAllActors();
			it.forEach(actor -> { // java8 forEach(-) method
				System.out.println(actor);
			});
			System.out.println("----------------------");
			it.forEach(System.out::println);// java8 forEach(-) method with static method referance
			System.out.println("--------------------");
			for (Actor actor : it) { // Java enhanced for loop
				System.out.println(actor);
			}

			System.out.println("----------------------");
			it.forEach(actor -> System.out.println(actor));
			System.out.println("-----------------------");
			List<Actor> list = (List<Actor>) it;
			list.stream().forEach(System.out::println);// java 8 streaming api + forEach(-) Method
			System.out.println("-----------------------");
			System.out.println("count of records::" + list.stream().count());// Java 8 streaming api for aggregate
			// operations
			System.out.println("-----------------------");
			System.out.println("Sorted Records");
			list.stream().sorted(Comparator.comparing(actor -> actor.getAid())).forEach(System.out::println);
			System.out.println("-----------------------");
			List<String> namesList = list.stream().map(actor -> actor.getAname()).collect(Collectors.toList());
			System.out.println("-----------------------findAllByIds");
			service.fetchActorsByIds(List.of(1, 2, 3)).forEach(System.out::println);
			System.out.println("-----------------------");
			service.fetchActorsByIds(Arrays.asList(1, 2, 3)).forEach(actor -> System.out.println(actor));

			System.out.println("---------findById(-)------------");
			Optional<Actor> opt = service.fetchActorsById(1);
			if (opt.isPresent()) {
				System.out.println("Actor info::" + opt.get());

			} else
				System.out.println("Actor not found");
			System.out.println("---------------");

			Optional<Actor> opt1 = service.fetchActorsById(1);
			Actor actor = opt1.orElseThrow(() -> new IllegalArgumentException("Actor not Found"));
			System.out.println("Actor info::" + actor);
			System.out.println("-----------------------------------");
			Optional<Actor> opt2 = service.fetchActorsById(1);
			Actor actor1 = opt1.orElse(new Actor());
			System.out.println("Actor info::" + actor1);
			System.out.println("-----------------------------------");
			Optional<Actor> opt3 = service.fetchActorsById(1);
			if (opt3.isEmpty()) {
				System.out.println("Actor not Found");
			} else
				System.out.println("Actor info::" + opt3.get());
			
			System.out.println("-----------------------------------");
			System.out.println("Actor info::"+ service.showActorById(2));
			
			
			System.out.println("-------------update----------------------");
			Actor updateactor = service.showActorById(1);
			updateactor.setAname("rahul");
			updateactor.setCategory("joker");
			updateactor.setMobileNo(8197495182L);
			System.out.println( service.updateAtor(updateactor));
			
			
			
			System.out.println("-------------deleteActor----------------------");
			Actor deleteactor =service.showActorById(2);
			System.out.println(service.deleteActor(deleteactor));
			
			
			System.out.println("-------------deleteActorsGroup----------------------");
			List<Actor>actorList1= (List<Actor>) service.fetchActorsByIds(Arrays.asList(1,2));
			System.out.println(service.deleteAllActorGroup(actorList1));
			
			System.out.println("-------------deleteAllActorsByIds----------------------");
          service.deleteAllActorsByIds(List.of(1));
          
          
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
