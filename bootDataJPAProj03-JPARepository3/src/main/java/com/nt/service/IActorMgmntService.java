package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.Entity.Actor;

public interface IActorMgmntService {
	public String removeActorsByIdsBatch(List<Integer> ids);

	public Actor searchActorById(int aid);
}
