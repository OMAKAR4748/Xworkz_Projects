package com.xworkz.moduleapp.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ModuleDto {

    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String location;
    private String phoneNumber;
    private String password;
    private String confirmPassword;


}
