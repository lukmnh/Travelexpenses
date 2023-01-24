package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Login;
import com.example.demo.models.Employee;
import com.example.demo.models.User;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Boolean save(User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId()).isPresent();
    }

    // @Override
    // public User findPassword(String password) {
    // return userRepository.findByPassword(password);
    // }

    @Override
    public Object login(Login login) {
        Employee log = employeeRepository.findEmail(login.getEmail());
        if (log.getEmail() != null
                && passwordEncoder.matches(login.getPassword(), log.getUser().getPassword())) {

            return login;
        }

        return false;
    }

    @Override
    public Boolean changePassword(String password, Integer id) {
        userRepository.changePassword(password, id);
        return userRepository.findById(id).isPresent();
    }
}
