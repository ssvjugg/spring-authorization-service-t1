package ru.usernamedrew.springauthorizationservicet1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {
    @Size(min = 5, max = 50, message = "Username length should be from 5 to 50 letters")
    @NotBlank(message = "Username shouldn't be blank")
    private String username;

    @Size(max = 255, message = "Password length can't be bigger then 255 letters")
    private String password;

    @Email(message = "Email should be in format user@example.com")
    @Size(min = 5, max = 255, message = "Email length should be from 5 to 255 letters")
    @NotBlank(message = "Email shouldn't be blank")
    private String email;
}
