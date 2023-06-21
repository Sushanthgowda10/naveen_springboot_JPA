package com.softtek.sms.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.softtek.sms.entity.Student;

public interface StudentService {
    // a service interface layer to provide services to other for loose coupling
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student addStudent(Student student);

    void deleteStudent(Long id);

    Student updateStudent(Student student);
    

}
