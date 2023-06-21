package com.nt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Actor;
import com.nt.entity.ResultView;

public interface IActorReository extends JpaRepository<Actor, Integer> {
	// select * from data_jpanactorbwhere aname=?
	public List<Actor> findByAnameEquals(String name);

	public List<Actor> findByAnameIs(String name);

	public List<Actor> findByAname(String name);

	// select * from data_jpa actor where aid between?and?
	public Iterable<Actor> findByAidBetween(int start, int end);

	// select * from data_jpanactorbwhere aname like %?%
	// select * from data_jpanactorbwhere aname like ?%
	public Iterable<Actor> findByAnameLike(String chars);

	public Iterable<Actor> findByAnameContainingIgnoreCase(String chars);

	// select * from data_jpanactorbwhere aname like ?%
	public Iterable<Actor> findByAnameStartingWith(String chars);

	public Iterable<Actor> findByCategoryInIgnoreCaseOrderByAnameAsc(List<String> categories);

	// Select * from data _jpa actor where status =1 or category=?
	public Iterable<Actor> findByStatusTrueOrCategoryEquals(String category);

	// Select * from data _jpa actor where aid>=start and aid<=end
	//public Iterable<Actor> findByAidGreaterThanEqualAndLessThanEqual(int start, int end);

	// Select * from data _jpa actor where (aid>? and aid<?) or upper(category) not
	// in(?,?,?..)
	public Iterable<Actor> findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase(int start, int end,
			String... categories);
	
	//Select aid,aname from data-jpa actor where upper (category)=?


	public Iterable<ResultView> findByCategoryEqualsIgnoreCase(String category);
	
	//select aid aname from data_jpa actor whwre mbile number
	public ResultView findByMobileNo(long mobileNo);
	
	//select aid aname from data_jpa actor whwre mbile number
	public Actor findByMobileNoIs(long mobileNo);

	

}
