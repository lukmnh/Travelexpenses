package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

public class History {
    private Integer id;
    private String fullname;
    private String status;
    private LocalDate date;
    private String start_journey;
    private String end_journey;
    private LocalDate start_date;
    private LocalDate end_date;
    private String description;
    private Integer employee_id;
    private Integer travelexpenses_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStart_journey() {
        return start_journey;
    }

    public void setStart_journey(String start_journey) {
        this.start_journey = start_journey;
    }

    public String getEnd_journey() {
        return end_journey;
    }

    public void setEnd_journey(String end_journey) {
        this.end_journey = end_journey;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getTravelexpenses_id() {
        return travelexpenses_id;
    }

    public void setTravelexpenses_id(Integer travelexpenses_id) {
        this.travelexpenses_id = travelexpenses_id;
    }

    @Autowired
    public History(Integer id, String fullname, String status, LocalDate date, String start_journey, String end_journey,
            LocalDate start_date, LocalDate end_date, String description, Integer employee_id,
            Integer travelexpenses_id) {
        this.id = id;
        this.fullname = fullname;
        this.status = status;
        this.date = date;
        this.start_journey = start_journey;
        this.end_journey = end_journey;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.employee_id = employee_id;
        this.travelexpenses_id = travelexpenses_id;
    }
}
