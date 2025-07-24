package ru.usernamedrew.springauthorizationservicet1.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.usernamedrew.springauthorizationservicet1.models.Role;
import ru.usernamedrew.springauthorizationservicet1.models.User;
import ru.usernamedrew.springauthorizationservicet1.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // Сохранение пользователя
    public User save(User user) {
        return userRepository.save(user);
    }

    // Создание пользователя
    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            // TODO
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return save(user);
    }

    // Получение пользователя по имени
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    // Нужен для Spring Security получение пользователя по имени
    public UserDetailsService userDetailsService() {
        return this::findByUsername;
    }

    // Получение текущего пользователя
    public User getCurrentUser() {
        // Получение имени из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return findByUsername(username);
    }

    // Выдача админа для демонстрации
    @Deprecated
    public void getAdmin() {
        User user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}
