package com.nt.runners;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Actor;
import com.nt.repository.IActorRepository;
@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IActorRepository actorRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
  actorRepo.searchActorsByCategory("hero").forEach(System.out::println);
  
  System.out.println("---------------------------------------------");
  actorRepo.searchActorsBymobileNo(34558L,34558L,34558L).forEach(System.out::println);
  
  System.out.println("---------------------------------------------");
    actorRepo.findActorsDataByCategories("hero","herovvvv","herobbbb").forEach(row->{
    		for(Object va1 : row) {
    			System.out.println(va1 + "");
//    			System.out.println();
    		}
    });
    
    System.out.println("---------------------------------------------");
    actorRepo.findActorsNamesByStartLetters("r").forEach(System.out::println);
    
    
    System.out.println("---------------------------------------------");

    Actor actor =actorRepo.getActorByMobileNo(34558L);
    		if(actor != null)
    			System.out.println("Actor info ::"+ actor);
    			else
    				System.out.println("Actor not found");
    		
    		
    		 System.out.println("---------------------------------------------");

    		Object data = actorRepo.getActorDataByMobileNo(34558L);
    		Object result[] = (Object[])data;
    		for (Object va1 : result) {
    			System.out.println(va1 + "");
    		}
    		 System.out.println("---------------------------------------------");
    		 
    		 String name = actorRepo.getActorNameByMobileNo(34558L);
    		 System.out.println("actor name::"+name);
    		 
    		 
    		 System.out.println("-------------------Id--------------------------");
    		 
    		 System.out.println("---------------------Aggregate------------------------");
    		 Object result1[] = (Object[])actorRepo.getActorsAggregateData();
    		 System.out.println("  count of records::"+result1[0]);
    		 System.out.println("max of aid::"+result1[1]);
    		 System.out.println("  min of aid::"+result1[2]);
    		 System.out.println("  sum of aid::"+result1[3]);
    		 System.out.println(" avg of aid::"+result1[4]);
    		 
    		 
    		 System.out.println("---------------------ActorId------------------------");
            Actor actor1 = actorRepo.getActorDataByMaxActorId();
      		 System.out.println(actor1);
      		 
      		 
      		System.out.println("-------------Update Moblie No by Id------------");
      		int i =actorRepo.updateActorMobileNoByAid(6L, 53);
      		System.out.println(i);
      		
      		System.out.println("-------------Delete by Category------------");
      		int j = actorRepo.deleteActorsByCategory("hero");
      		System.out.println(j);
      		 

    		}
	}


