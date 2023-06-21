package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nt.Entity.Actor;

public interface IActorMgmntService {
	public Iterable<Actor> showActorByOrder(boolean asc, String... properties);

	public Page<Actor> showActorsBypage(int pageNo, int pagesize);
	
	public void showActorsPageByPage(int pageSize);
}