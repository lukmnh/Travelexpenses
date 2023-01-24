package com.example.demo.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.EmployeeRepository;

@Service
public class MyUserDetails implements UserDetails, UserDetailsService {
    private EmployeeRepository employeeRepository;
    private String username;
    private String password;
    private GrantedAuthority grantedAuthority;

    public MyUserDetails(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthoritys = new HashSet<>();
        grantedAuthoritys.add(grantedAuthority);
        return grantedAuthoritys;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.demo.models.Employee log = employeeRepository.findEmail(username);
        grantedAuthority = new SimpleGrantedAuthority(log.getUser().getRole().getName());
        return new User(log.getEmail(), log.getUser().getPassword(), getAuthorities());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
