package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.Entity.Actor;

import jakarta.transaction.Transactional;

@Transactional
public interface IActorRepository extends JpaRepository<Actor, Integer> {
	//select *  from actor where category =?
	
	
	
	//@Query ("from actor where category =?1")
	
	//@Query(" fromcom.nt.entity.Actor a where a.category=?1")
	//@Query(" select a from com.nt entity.Actor a where a.category=?1")
	//@Query("from Actor where category=:role")
	
	
//	public Iterable<Actor>searchActorsByCategory(String role);
	
	@Query("from Actor where category=:role")
	public Iterable<Actor>searchActorsByCategory( @Param( "role")String category);
	
	//@Query("from Actor where mobileNo in(?1,?2,?3) order by  aname")
	//@Query("from Actor where mobileNo in(:no1,:no2,:no3) order by  aname")
	
	
	@Query("from Actor where mobileNo in(?1,?2,?3) order by  aname")
	public Iterable<Actor>searchActorsBymobileNo(long no1, long no2,long no3 );
	
	
	
	@Query("select aid,aname,category from Actor where category in(:cat1,:cat2,:cat3)")
	public List<Object[]>findActorsDataByCategories(String cat1,String cat2,String cat3);
	
	
	
	@Query(" select aname from Actor where aname like :letters%")
	public List<String>findActorsNamesByStartLetters(String letters);
	
	
	@Query("from Actor where mobileNo=:no")
	public Actor getActorByMobileNo(@Param("no") long mobileNo);
	
	
	@Query(" select aid, aname,category from Actor where mobileNo=:mobileNo")
	public Object getActorDataByMobileNo( long mobileNo);
	
	@Query(" select  aname from Actor where mobileNo=:mobileNo")
	public String getActorNameByMobileNo( long mobileNo);
	
	
	@Query("from Actor where aid=:id")
	public  Optional<Actor>findByAid(Integer id);
	
	@Query("select count(*),max(aid),min(aid),sum(aid),avg(aid) from Actor")
	public Object getActorsAggregateData();
	
	@Query(" from Actor where aid =(select max (aid) from Actor)")
	public Actor getActorDataByMaxActorId();
	
	@Query("update Actor set mobileNo=:newmno where aid=:id")
	@Modifying
	public int updateActorMobileNoByAid(long newmno,int id);
	
	@Query("delete from Actor where category=:role")
	@Modifying
	public int deleteActorsByCategory(String role);
	
	
	
	
	}















