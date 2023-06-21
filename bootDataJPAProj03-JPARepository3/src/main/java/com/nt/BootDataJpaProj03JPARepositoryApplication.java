package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.Entity.Actor;
import com.nt.service.IActorMgmntService;

@SpringBootApplication
public class BootDataJpaProj03JPARepositoryApplication {

	public static void main(String[] args) {
		//ApplicationContext ctx = SpringApplication.run(BootDataJpaProj03JPARepositoryApplication.class, args);

		//IActorMgmntService service = ctx.getBean("actorservice", IActorMgmntService.class);
		//try {
//		// invoke the b.method
//		/*	Actor actor = new Actor();
//			actor.setAname("sush");
//			actor.setCategory("hero");
//			actor.setMobileNo(123456789L);
//			String resultmsg = service.registerActor(actor);
//			System.out.println(resultmsg);*/
//			
//			
		/*List<Actor> list=List.of(new Actor(1001,"ram","hero",34556L),
				new Actor(1002,"rama","heroaa",34556L),new Actor(10013,"ramaaaaa","herovvvv",34556L),new Actor(10014,"rameeeee","heroffff",34556L),new Actor(10015,"ramrrrrr","herobbbb",34556L));
			String resultmsg = service.registerActorGroup(list);
			System.out.println(resultmsg);*/
		//} catch (DataAccessException e) {
			//e.printStackTrace();
		//}
		
		SpringApplication.run(BootDataJpaProj03JPARepositoryApplication.class, args);

	}

}
