package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class FormTravelExpenses {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String start_journey;

    public String getStart_journey() {
        return start_journey;
    }

    public void setStart_journey(String start_journey) {
        this.start_journey = start_journey;
    }

    private String end_journey;

    public String getEnd_journey() {
        return end_journey;
    }

    public void setEnd_journey(String end_journey) {
        this.end_journey = end_journey;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start_date;

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end_date;

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
