package com.nt.runner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.Entity.Actor;
import com.nt.service.IActorMgmntService;

@Component
public class PagingAndSortingRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IActorMgmntService service;
	
	@Override
	public void run(String... args)throws Exception {
		try {
			System.out.println("*-------findAll(Sort sort) call----------------");
			service.showActorByOrder(false, "aname").forEach(System.out::println);
			
			System.out.println("---------------pagination-----------");
			Page<Actor>page = service.showActorsBypage(0, 3);
			List<Actor>list = page.getContent();
			System.out.println("Record are::");
			list.forEach(System.out::println);
			System.out.println("other information about page");
			System.out.println("current page no::"+page.getNumber());
			System.out.println("total pages::"+page.getTotalPages());
			System.out.println("total records::"+page.getTotalElements());
			System.out.println("it is first page::"+page.isFirst());
			System.out.println("it is last page::"+page.isLast());
			System.out.println("-----PageByPage----------");
			service.showActorsPageByPage(3);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}