package com.example.demo.repositories;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.TravelExpenses;

public interface TravelExpenseRepository extends JpaRepository<TravelExpenses, Integer> {
    @Modifying
    @Transactional
    @Query(value = "Update tbl_tr_travelexpenses t  set t.end_date = :end_date where t.id = :id", nativeQuery = true)
    public void updateEndDate(@Param("id") Integer id, @Param("end_date") LocalDate end_date);
}
