package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e.id from tbl_m_employee e where e.email  = ?1", nativeQuery = true)
    Integer findIdByEmail(String email);

    @Query(value = "select e.id, e.fullname, e.email, e.birthdate, e.address, u.password, r.name,e.manager_id FROM tbl_m_employee e JOIN tbl_tr_user u ON e.id = u.id JOIN tbl_m_role r ON u.role_id = r.id WHERE e.email = ?1", nativeQuery = true)
    
    Employee findEmail(String email);
}
