package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.Entity.Actor;

public interface IActorRepository extends CrudRepository<Actor, Integer> {

}
