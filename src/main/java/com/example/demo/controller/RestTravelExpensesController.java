package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FormTravelExpenses;
import com.example.demo.dto.History;
import com.example.demo.models.Employee;
import com.example.demo.models.Status;
import com.example.demo.models.TravelExpenses;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.StatusService;
import com.example.demo.services.TravelExpenseService;

@RestController
@CrossOrigin
@RequestMapping("/api/travel-expense")
public class RestTravelExpensesController {

    @Autowired
    TravelExpenseService travelExpenseService;

    @Autowired
    EmployeeService employeeService;
    @Autowired
    StatusService statusService;

    @PostMapping("/form-request")
    public ResponseEntity<?> request(@RequestBody FormTravelExpenses formTravelExpenses) {
        Boolean resultTravel;
        Boolean resultStatus;
        TravelExpenses travel = new TravelExpenses();
        travel.setEmail(formTravelExpenses.getEmail());
        travel.setStartJourney(formTravelExpenses.getStart_journey());
        travel.setEndJourney(formTravelExpenses.getEnd_journey());
        travel.setStartDate(formTravelExpenses.getStart_date());
        travel.setEndDate(formTravelExpenses.getEnd_date());
        travel.setDescription(formTravelExpenses.getDescription());
        resultTravel = travelExpenseService.save(travel);

        Status status = new Status();
        // status.setId(statusService.getIdbyId(formTravelExpenses.getId()));
        status.setStatus("Request");
        status.setDate(java.time.LocalDate.now());

        // status.setEmployee(employeeService.getCurrentUser());
        Employee employee = new Employee();
        employee.setId(employeeService.getIdByEmail(formTravelExpenses.getEmail()));
        status.setEmployee(employee);
        travel.setId(statusService.getIdByEmail(formTravelExpenses.getEmail()));
        status.setTravelExpenses(travel);

        resultStatus = statusService.save(status);

        if (resultTravel == true && resultStatus == true) {
            return ResponseEntity.ok().body("Request Successful");
        } else {
            return ResponseEntity.badRequest().body("Request Failed");
        }
    }

    @GetMapping("history-employee/{id}")
    public List<Status> historyList(@PathVariable(required = true) Integer id) {
        return statusService.getHistory(id);
    }

    @GetMapping("/lastHistory-TRA/")
    public List<History> lastHistoryTRA(Authentication authentication) {
        String email = authentication.getName();
        Integer id = employeeService.getIdByEmail(email);
        return statusService.getLastHistory(id);
    }

    @GetMapping("history-tra/{id}")
    public List<History> historyTRA(@PathVariable(required = true) Integer id) {
        return statusService.getHistoryTRA(id);
    }

}
