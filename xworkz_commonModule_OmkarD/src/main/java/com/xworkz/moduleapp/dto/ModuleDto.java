package com.xworkz.moduleapp.dto;

import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ModuleDto {

    private Integer id;

    private String fullName;
    @Size(min = 3, max = 25, message = "User Name Should be 3 and 25")

    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "email must be @ and . is mandatory")

    private Integer age;
    @Size(min= 18 , message = "Age must be min 18")

    private String gender;

    private String location;

    private String phoneNumber;
    @Pattern(regexp = "^[789]\\d{9}$", message = "Phone Number must be 10 digit")

    private String password;

    private String confirmPassword;


}