package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.Actor;
import com.nt.repository.IActorRepository;

@Service("actorservice")
public class ActorMgmntServiceImpl implements IActorMgmntService {

	@Autowired
	private IActorRepository actorRepo;

	public String removeActorsByIdsBatch(List<Integer> ids) {
		List<Actor> list = actorRepo.findAllById(ids);
		int count = list.size();
		actorRepo.deleteAllByIdInBatch(ids);

		// TODO Auto-generated method stub
		return count + "records deleted!!";
	}

	@Override
	public Actor searchActorById(int aid) {
		// TODO Auto-generated method stub
		return actorRepo.getReferenceById(aid);
	}

}