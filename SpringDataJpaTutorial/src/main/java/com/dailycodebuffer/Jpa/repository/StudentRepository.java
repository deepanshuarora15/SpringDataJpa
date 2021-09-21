package com.dailycodebuffer.Jpa.repository;

import com.dailycodebuffer.Jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByFirstName(String firstName);
    List<Student> findStudentByFirstNameContaining(String name);
    List<Student> findStudentByLastNameNotNull();
    List<Student> findStudentByGuardianName(String guardianName);
}
