package ru.usernamedrew.springauthorizationservicet1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.usernamedrew.springauthorizationservicet1.dto.JwtAuthenticationResponse;
import ru.usernamedrew.springauthorizationservicet1.dto.SignInRequest;
import ru.usernamedrew.springauthorizationservicet1.dto.SignUpRequest;
import ru.usernamedrew.springauthorizationservicet1.models.User;
import ru.usernamedrew.springauthorizationservicet1.security.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return authenticationService.signUp(signUpRequest);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }
}
