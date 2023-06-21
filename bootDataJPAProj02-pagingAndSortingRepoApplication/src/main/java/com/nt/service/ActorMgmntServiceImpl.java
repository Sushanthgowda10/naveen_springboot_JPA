package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.Entity.Actor;
import com.nt.repository.IActorRepository;

@Service("actorservice")
public class ActorMgmntServiceImpl implements IActorMgmntService {

	@Autowired
	private IActorRepository actorRepo;

	@Override
	public Iterable<Actor> showActorByOrder(boolean asc, String... properties) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<Actor> it = actorRepo.findAll(sort);

		return it;
	}

	public Page<Actor> showActorsBypage(int pageNo, int pagesize) {
		Pageable pageable = PageRequest.of(pageNo, pagesize);
		Page<Actor> page = actorRepo.findAll(pageable);
		return page;

	}
@Override
	public void showActorsPageByPage(int pageSize) {
		long recordsCount = actorRepo.count();
		long pagesCount = recordsCount / pageSize;
		pagesCount = (recordsCount % pageSize == 0) ? pagesCount : ++pagesCount;
		
		for (int i= 0; i<pagesCount; i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Actor> page=actorRepo.findAll(pageable);
			page.getContent().forEach(System.out::println);
		}
		

	}

}