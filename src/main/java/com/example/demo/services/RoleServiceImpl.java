package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Role;
import com.example.demo.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {

        return roleRepository.findAll();
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("role not found"));
    }

    @Override
    public Boolean save(Role role) {
        roleRepository.save(role);
        return roleRepository.findById(role.getId()).isPresent();
    }

    @Override
    public Integer getIdByLevel() {
        return roleRepository.getIdByMaxLevel();
    }

}
