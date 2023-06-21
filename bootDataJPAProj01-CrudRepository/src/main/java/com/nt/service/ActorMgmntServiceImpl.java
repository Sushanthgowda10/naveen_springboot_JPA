package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.Actor;
import com.nt.repository.IActorRepository;

@Service("actorservice")
public class ActorMgmntServiceImpl implements IActorMgmntService {

	@Autowired
	private IActorRepository actorRepo;

	public String registerActor(Actor actor) {
		Actor sactor = actorRepo.save(actor);

		// TODO Auto-generated method stub
		return "Actor is rigister with id value:" + sactor.getAid();

	}

	public String registerActorGroup(List<Actor> list) {

		if (list != null) {

			Iterable<Actor> sEntities = actorRepo.saveAll(list);
			List<Integer> ids = new ArrayList<>();
			for (Actor actor : sEntities) {
				ids.add(actor.getAid());
			}
			return ids.size() + "object are saved having id value:" + ids;

		}
		return "problem in batch information";

	}

	@Override
	public Iterable<Actor> fetchActorsByIds(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return actorRepo.findAllById(ids);
	}

	@Override
	public Iterable<Actor> fetchAllActors() {
		// TODO Auto-generated method stub
		return actorRepo.findAll();
	}

	public Optional<Actor> fetchActorsById(int aid) {
		// TODO Auto-generated method stub
		Optional<Actor> opt = actorRepo.findById(aid);
		return opt;
	}

	@Override
	public Long fetchrecordCount() {
		// TODO Auto-generated method stub
		return actorRepo.count();
	}

	@Override
	public Actor showActorById(int aid) {
		// TODO Auto-generated method stub
		return  actorRepo.findById(aid).orElseThrow(() -> new IllegalArgumentException("Actors not found")   );
	}

	@Override
	public String updateAtor(Actor actor) {
		// TODO Auto-generated method stub
		actorRepo.save(actor);
		return "Actor is updated with new values";
	}

	@Override
	public String deleteActor(Actor actor) {
		actorRepo.delete(actor);
		// TODO Auto-generated method stub
		return "Actor"+actor.getAname()+"delete succesfully";
	}

	@Override
	public String deleteAllActorGroup(List<Actor> actorList) {
		if(actorList!=null) {
			actorRepo.deleteAll(actorList);
			return actorList.size()+"Actor are deleted !!";
			
		}else {
			return " problem in batch deletion!";
		}
	}

	@Override
	public String deleteAllActorsByIds(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
		actorRepo.deleteAllById(ids);
		
		return ((List<Integer>)ids).size()+"Actors are deleted!!";
	}

	@Override
	public String deleteAllActor() {
		actorRepo.deleteAll();
		// TODO Auto-generated method stub
		return "All records will be deleted";
	}
}
