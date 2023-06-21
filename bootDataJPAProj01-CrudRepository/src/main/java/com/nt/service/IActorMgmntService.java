package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.Entity.Actor;

public interface IActorMgmntService {

	public String registerActor(Actor actor);

	public String registerActorGroup(List<Actor> list);

	public Iterable<Actor> fetchActorsByIds(Iterable<Integer> idsSSS);

	public Iterable<Actor> fetchAllActors();

	public Long fetchrecordCount();

	public Optional<Actor> fetchActorsById(int aid);
	public Actor showActorById(int aid);
	

	public String updateAtor (Actor actor);
	
	public  String deleteActor(Actor actor);
	public  String deleteAllActor();
	public  String deleteAllActorGroup(List<Actor> actorList);
	
	public  String deleteAllActorsByIds(Iterable<Integer>ids);
	
	
	

}
