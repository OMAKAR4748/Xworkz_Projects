package com.xworkz.commonModule.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class XworkzDto {

    private int  id;
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
