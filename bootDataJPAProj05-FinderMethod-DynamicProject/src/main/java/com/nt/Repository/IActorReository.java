package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Actor;
import com.nt.view.view;

public interface IActorReository extends JpaRepository<Actor, Integer> {
	
	
	public <T extends view> Iterable<T>findByCategoryContainingIgnoreCase(String letters, Class<T>clazz);
	
	
	
	
	
}