package com.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.Person;

public interface PersonRepsitory extends JpaRepository<Person, Integer> {

}
