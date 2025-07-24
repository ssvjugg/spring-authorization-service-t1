package ru.usernamedrew.springauthorizationservicet1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.usernamedrew.springauthorizationservicet1.services.UserService;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private final UserService userService;

    @GetMapping // Доступен только авторизованным
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "admin";
    }

    @GetMapping("/get-admin")
    public void getAdmin() {
        userService.getAdmin();
    }
}
