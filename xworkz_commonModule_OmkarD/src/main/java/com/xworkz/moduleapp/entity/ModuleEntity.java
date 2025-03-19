package com.xworkz.moduleapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Xworkz_Module")
@NamedQuery(name = "getByEmail",query = "select m from ModuleEntity m where m.email=:email")
@NamedQuery(name = "checkEmail",query = "select count(e.email) from ModuleEntity e where e.email=:email")
@NamedQuery(name="fullName", query = "select m from ModuleEntity m where m.fullName=:fullName")
@NamedQuery(name = "CheckAge", query = "select m from ModuleEntity m where m.age=:age")
@NamedQuery(name = "checkPhoneNo", query = "select m from ModuleEntity m where m.phoneNumber=:phoneNumber")


public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullName")
    private String fullName;

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

    @Column(name = "failed_attempts")
    private int failedAttempts = 0;

    @Column(name = "account_locked")
    private boolean accountLocked = false;

    @Column(name = "lock_time")
    private LocalDateTime lockTime;


}
