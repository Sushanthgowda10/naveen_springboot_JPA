package com.softtek.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.sms.entity.Student;

//@Repository // letting kno its Repository rather than default // not needed on service layer
public interface StudentRepository extends JpaRepository<Student,Long> {
    // <entity name , typeof primary key> // type of primary key cannot be primitive
}
