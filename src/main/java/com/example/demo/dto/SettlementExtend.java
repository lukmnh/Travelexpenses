package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class SettlementExtend {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  LocalDate end_date;

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
}
