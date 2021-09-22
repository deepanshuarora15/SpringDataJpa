package com.dailycodebuffer.Jpa.repository;

import com.dailycodebuffer.Jpa.entity.Guardian;
import com.dailycodebuffer.Jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().emailId("gemaini@gmail.com").firstName("Libra")
                .lastName("Taurus")
//                .guardianName("Scorpio")
//                .guardianEmail("Sagittarius")
//                .guardianMobile("9999888877")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Scorpio")
                .email("Sagittarius")
                .mobile("9999888877")
                .build();
        Student student = Student.builder().
                emailId("baingan@gmail.com")
                .firstName("Libra")
                .lastName("Taurus")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> allStudents = studentRepository.findAll();
        for(Student c: allStudents){
            System.out.println(c);
        }
    }

    @Test
    public void getStudentByName(){
        System.out.println(studentRepository.findStudentByFirstName("Libra"));
    }

    @Test
    public void getStudentByNameContaining(){
        System.out.println(studentRepository.findStudentByFirstNameContaining("ibr"));
    }

    @Test
    public void findStudentByLastNameNotNull(){
        System.out.println(studentRepository.findStudentByLastNameNotNull());
    }

    @Test
    public void findStudentByGuardianName(){
        System.out.println(studentRepository.findStudentByGuardianName("Scorpio"));
    }


//    public void getStudentsByEmailAddress(){
//        System.out.println(studentRepository.getStudentsByEmailAddress("gemini@gmail.com"));
//    }


    @Test
    public void getStudentByEmailAddressNative(){
      System.out.println(studentRepository.getStudentByEmailAddressNative("gemini@gmail.com"));
    }

    @Test
    public void getStudentByGuardianPhone(){
        System.out.println(studentRepository.getStudentByGuardianPhone("9999888877"));
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Lala" , "gemini@gmail.com");
    }

}