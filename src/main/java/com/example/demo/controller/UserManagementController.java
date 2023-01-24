// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.demo.dto.Login;
// import com.example.demo.dto.Register;
// import com.example.demo.models.Employee;
// import com.example.demo.models.Role;
// import com.example.demo.models.User;
// import com.example.demo.services.EmployeeService;
// import com.example.demo.services.RoleService;
// import com.example.demo.services.UserService;

// @Controller
// @RequestMapping("user-management")
// public class UserManagementController {
// @Autowired
// private EmployeeService employeeService;

// @Autowired
// private RoleService roleService;

// @Autowired
// UserService userService;

// @Autowired
// PasswordEncoder passwordEncoder;

// @Autowired
// private AuthenticationManager authenticationManager;

// public UserManagementController(AuthenticationManager authenticationManager,
// UserService userService,
// RoleService roleService,
// EmployeeService employeeService, PasswordEncoder passwordEncoder) {
// this.authenticationManager = authenticationManager;
// this.userService = userService;
// this.roleService = roleService;
// this.employeeService = employeeService;
// this.passwordEncoder = passwordEncoder;
// }

// @GetMapping("register")
// public String register(Model model) {
// model.addAttribute("register", new Register());

// return "user-management/register";
// }

// @PostMapping("save")
// public String save(Register register) {

// Boolean resultEmployee;
// Boolean resultUser;
// Employee emp = new Employee();
// emp.setFullname(register.getFullname());
// emp.setEmail(register.getEmail());
// emp.setBirthdate(register.getBirthdate());
// emp.setAddress(register.getAddress());
// resultEmployee = employeeService.save(emp);

// User user = new User();
// user.setId(employeeService.getIdByEmail(register.getEmail()));

// Role role = new Role();
// role.setId(roleService.getIdByLevel());
// user.setRole(role);
// user.setPassword(passwordEncoder.encode(register.getPassword()));
// resultUser = userService.save(user);

// if (resultEmployee && resultUser) {
// return "user-management/login";
// } else {
// return "user-management/register";
// }
// }

// @GetMapping("login")
// public String login(Model model) {
// model.addAttribute("login", new Login());
// return "user-management/login";
// }

// @PostMapping(value = { "check" })
// public String authLogin(Login login, Model model) {
// org.springframework.security.core.Authentication authentication =
// authenticationManager
// .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),
// login.getPassword()));
// SecurityContextHolder.getContext().setAuthentication(authentication);
// return "user/dashboard";
// }
// }
