package com.dailycodebuffer.Jpa.repository;

import com.dailycodebuffer.Jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByFirstName(String firstName);
    List<Student> findStudentByFirstNameContaining(String name);
    List<Student> findStudentByLastNameNotNull();
    List<Student> findStudentByGuardianName(String guardianName);

    //JPQL Query
//    @Query("select s from Student where s.emailId=?1")
//    Student getStudentsByEmailAddress(String emailId);

    //Native Query
    @Query(value="select * from tbl_student where email_address=?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    @Query(value="select * from tbl_student where guardian_mobile= :guardian_mobile", nativeQuery = true)
    List<Student> getStudentByGuardianPhone(@Param("guardian_mobile") String guardian_mobile);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name= :firstName where email_address = :emailId", nativeQuery = true)
    int updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);
}
