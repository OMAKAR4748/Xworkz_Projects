package com.xworkz.moduleapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Xworkz_Trainee")
@NamedQuery(name = "getByEmail",query = "select m from ModuleEntity m where m.email=:email")
@NamedQuery(name = "updateByEmail", query = "UPDATE ModuleEntity m SET m.name = :name, m.age = :age, m.gender = :gender, m.location = :location, m.phoneNumber = :phoneNumber, m.password = :password, m.confirmPassword = :confirmPassword WHERE m.email = :email")
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "location")
    private String location;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "confirmPassword")
    private String confirmPassword;
}
