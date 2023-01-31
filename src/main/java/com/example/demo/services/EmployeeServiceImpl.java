package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Override
    public List<Employee> getAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("employee not found"));
    }

    @Override
    public Boolean save(Employee employee) {
        employeeRepository.save(employee);
        return employeeRepository.findById(employee.getId()).isPresent();
    }

    @Override
    public Integer getIdByEmail(String email) {
        return employeeRepository.findIdByEmail(email);
    }

    @Override
    public Employee getEmail(String email) {
        return employeeRepository.findEmail(email);
    }

    @Override
    public Employee getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return employeeRepository.findEmail(email);
    }

    // @Override
    // public Boolean register(Register register) {
    // Employee employee = new Employee();
    // User user = new User();
    // boolean result = employeeService.save(employee);
    // user.setId(employeeService.getIdByEmail(employee.getEmail()));
    // user.setPassword(passwordEncoder.encode(user.getPassword()));

    // Role role = new Role();
    // role.setId(roleService.getIdByLevel());
    // user.setRole(role);
    // Boolean result2 = userService.save(user);

    // if (result && result2) {
    // return true;
    // } else {
    // return false;
    // }
    // }

}
