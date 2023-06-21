package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.Entity.Actor;
import com.nt.service.IActorMgmntService;

@SpringBootApplication
public class BootDataJpaProj02PagingAndSortingRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaProj02PagingAndSortingRepositoryApplication.class, args);

		

	}}
