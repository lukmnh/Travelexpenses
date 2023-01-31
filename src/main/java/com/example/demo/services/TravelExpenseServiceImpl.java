package com.example.demo.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TravelExpenses;
import com.example.demo.repositories.TravelExpenseRepository;

@Service
public class TravelExpenseServiceImpl implements TravelExpenseService {

    @Autowired
    TravelExpenseRepository travelExpenseRepository;

    @Override
    public Boolean save(TravelExpenses travelExpenses) {
        travelExpenseRepository.save(travelExpenses);
        return travelExpenseRepository.findById(travelExpenses.getId()).isPresent();
    }

    @Override
    public Boolean updateEndDate(Integer id, LocalDate end_date) {
        travelExpenseRepository.updateEndDate(id, end_date);
        return travelExpenseRepository.findById(id).isPresent();
    }

}
