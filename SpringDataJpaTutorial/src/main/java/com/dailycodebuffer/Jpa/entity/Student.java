package com.dailycodebuffer.Jpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
