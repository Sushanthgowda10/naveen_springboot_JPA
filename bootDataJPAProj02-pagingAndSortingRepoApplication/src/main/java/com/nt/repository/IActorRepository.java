package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.Entity.Actor;

public interface IActorRepository extends PagingAndSortingRepository<Actor, Integer>,CrudRepository<Actor, Integer> {

}
