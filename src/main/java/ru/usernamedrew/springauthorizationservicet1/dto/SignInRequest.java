package ru.usernamedrew.springauthorizationservicet1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequest {
    @Size(min = 5, max = 50, message = "Username length should be from 5 to 50 letters")
    @NotBlank(message = "Username shouldn't be blank")
    private String username;

    @Size(max = 255, message = "Password length can't be bigger then 255 letters")
    @NotBlank(message = "Password can't be blank")
    private String password;
}
