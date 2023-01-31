package com.example.demo.services;

import java.time.LocalDate;

import com.example.demo.models.TravelExpenses;

public interface TravelExpenseService {

    public Boolean save(TravelExpenses travelExpenses);

    public Boolean updateEndDate(Integer id, LocalDate end_date);
}
