package com.example.demo.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class FormTravelExpeneses {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "start_journey")
    private String start_journey;
    @Column(name = "end_journey")
    private String end_journey;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate start_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate end_date;
    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public String getStartJourney() {
        return start_journey;
    }

    public String getEndJourney() {
        return end_journey;
    }

    public LocalDate getStarDate() {
        return start_date;
    }

    public LocalDate getEndDate() {
        return end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartJourney(String start_journey) {
        this.start_journey = start_journey;
    }

    public void setEndJourney(String end_journey) {
        this.end_journey = end_journey;
    }

    public void setStartDate(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEndDate(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
