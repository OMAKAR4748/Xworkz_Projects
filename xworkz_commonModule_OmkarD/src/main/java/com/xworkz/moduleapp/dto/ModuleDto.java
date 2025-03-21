package com.xworkz.moduleapp.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModuleDto {

    private Integer id;

    @Size(min = 3, max = 25, message = "User Name Should be between 3 and 25 characters")
    private String fullName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email must contain '@' and '.'")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    private String gender;
    private String location;

    @Pattern(regexp = "^[789]\\d{9}$", message = "Phone Number must be 10 digits starting with 7, 8, or 9")
    private String phoneNumber;

    private String password;
    private String confirmPassword;
    private String profileImage;
    private MultipartFile multipartFile;
}
