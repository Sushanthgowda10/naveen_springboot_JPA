package com.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.softtek.entity.PhoneNumber;

import jakarta.transaction.Transactional;

@Transactional
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
	@Query(value = "delete from phone_number_otm where person_id=:id", nativeQuery = true)
	@Modifying
	public int deleteAllPhoneNumberOfaPersonByPid(int id);
}
