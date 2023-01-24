package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.TravelExpenses;

public interface TravelExpenseRepository extends JpaRepository<TravelExpenses, Integer> {

}
