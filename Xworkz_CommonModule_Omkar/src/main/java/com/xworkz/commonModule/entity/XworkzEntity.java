package com.xworkz.commonModule.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Trainee")
public class XworkzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private Long phoneNumber;
    private String password;
    private String confirmPassword;
    private String gender;
    private String location;
    private String dob;
    private String bloodGroup;
}
