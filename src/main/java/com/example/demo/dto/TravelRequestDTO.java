package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

public class TravelRequestDTO {
    private Integer id_status;
    private Integer id_travel;
    private String fullname;
    private LocalDate date;
    private String start_journey;
    private String end_journey;
    private LocalDate start_date;
    private LocalDate end_date;
    private String description;
    private String status;
    @Autowired
    public TravelRequestDTO(Integer id_status, Integer id_travel, String fullname, LocalDate date, String start_journey,
            String end_journey, LocalDate start_date, LocalDate end_date, String description, String status) {
        this.id_status = id_status;
        this.id_travel = id_travel;
        this.fullname = fullname;
        this.date = date;
        this.start_journey = start_journey;
        this.end_journey = end_journey;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.status = status;
    }
    public Integer getId_status() {
        return id_status;
    }
    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }
    public Integer getId_travel() {
        return id_travel;
    }
    public void setId_travel(Integer id_travel) {
        this.id_travel = id_travel;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
