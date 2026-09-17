package com.hrgenius.config;

import com.hrgenius.entity.Role;
import com.hrgenius.entity.User;
import com.hrgenius.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            createUser("admin@hrgenius.com", "Admin@123", "Admin User", Role.ADMIN);
            createUser("hr@hrgenius.com", "Hr@123", "HR Manager", Role.HR_MANAGER);
            createUser("manager@hrgenius.com", "Manager@123", "Manager User", Role.MANAGER);
            createUser("emp@hrgenius.com", "Emp@123", "Employee User", Role.EMPLOYEE);
            System.out.println("Default users added");
        }
    }

    private void createUser(String email, String password, String name, Role role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setFullName(name);
        user.setRole(role);
        user.setActive(true);
        userRepository.save(user);
    }
}
