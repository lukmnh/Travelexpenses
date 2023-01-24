package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // @Query(value = "select u.password from tbl_tr_user u where u.password = ?1",
    // nativeQuery = true)
    // User findByPassword(String password);
    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_tr_user u SET u.password = :password WHERE u.id = :id", nativeQuery = true)
    public void changePassword(@Param("password") String password, @Param("id") Integer id);
}
