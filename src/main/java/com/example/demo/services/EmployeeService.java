package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Employee;

public interface EmployeeService {

    public List<Employee> getAll();

    public Employee getById(Integer id);

    // public Boolean register(Register register);

    public Boolean save(Employee employee);

    public Integer getIdByEmail(String email);

    public Employee getEmail(String email);

    public Employee getCurrentUser();
}
