package com.nt.Runner;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IActorReository;
import com.nt.entity.Actor;
import com.nt.entity.ResultView;

@Component
public class FinderMethod implements CommandLineRunner {

	@Autowired
	private IActorReository actorRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("rama name actors info::");
		actorRepo.findByAnameEquals("rama").forEach(System.out::println);

		System.out.println("----------------------------");
		System.out.println("ram name actors info::");
		actorRepo.findByAnameEquals("ram").forEach(System.out::println);

		System.out.println("----------------------------");
		System.out.println("ramaaaaa name actors info::");
		actorRepo.findByAnameEquals("ramaaaaa").forEach(System.out::println);

		System.out.println("----------------------------");
		System.out.println("rameeeee name actors info::");
		actorRepo.findByAidBetween(1, 10).forEach(System.out::println);

		System.out.println("----------------------------");
		System.out.println("rameeeee name actors info::");
		actorRepo.findByAnameContainingIgnoreCase("rahul").forEach(System.out::println);

		System.out.println("----------------------------");
		System.out.println("ramrrrrr name actors info::");
		actorRepo.findByAnameStartingWith("ramrrrrr").forEach(System.out::println);

		System.out.println("----------------------------");
		System.out.println("ramrrrrr name actors info::");
		actorRepo.findByCategoryInIgnoreCaseOrderByAnameAsc(List.of("hero", "heroaa")).forEach(System.out::println);

		System.out.println("-----------like-----------------");
		System.out.println("ramrrrrr name actors info::");
		actorRepo.findByAnameLike("%ee").forEach(System.out::println);

		System.out.println("----------status------------------");
		System.out.println(" actors info::");
		actorRepo.findByStatusTrueOrCategoryEquals("heroaa").forEach(System.out::println);

		/*
		 * System.out.println("----------greaterand lessthan------------------");
		 * System.out.println(" actors info::");
		 * System.out.println(actorRepo.findByAidGreaterThanEqualAndLessThanEqual(1,
		 * 5));
		 */

		System.out.println("----------greaterand lessthan-category-----------------");
		System.out.println(" actors info::");
		actorRepo.findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase(1, 6, "hero", "zumbadancer")
				.forEach(System.out::println);

		Iterable<ResultView> it = actorRepo.findByCategoryEqualsIgnoreCase("hero");
		it.forEach(view -> {
			System.out.println(view.getClass());
			System.out.println(view.getAid() + "" + view.getAname());
		});

		System.out.println("----------mobile------------------");
		ResultView view = actorRepo.findByMobileNo(34556L);
		System.out.println(view.getAid() + "" + view.getAname());

		System.out.println("----------mobileis------------------");
		Actor actor = actorRepo.findByMobileNoIs(34556L);
		System.out.println(actor);

	}

}
