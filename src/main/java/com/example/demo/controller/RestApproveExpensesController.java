package com.example.demo.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Approve;
import com.example.demo.dto.ApproveFinanceDTO;
import com.example.demo.dto.DecisionApproval;
import com.example.demo.dto.TravelRequestDTO;
import com.example.demo.dto.TravelSettlementDTO;
import com.example.demo.dto.SettlementExtend;
import com.example.demo.models.Employee;
import com.example.demo.models.Status;
import com.example.demo.models.TravelExpenses;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.StatusService;
import com.example.demo.services.TravelExpenseService;

@RestController
@CrossOrigin
@RequestMapping("/api/approval")
public class RestApproveExpensesController {
    private StatusService statusService;
    private EmployeeService employeeService;
    private TravelExpenseService travelExpenseService;
    
    @Autowired
    public RestApproveExpensesController(StatusService statusService, EmployeeService employeeService,
            TravelExpenseService travelExpenseService) {
        this.statusService = statusService;
        this.employeeService = employeeService;
        this.travelExpenseService = travelExpenseService;
    }
   
    //manager
    @GetMapping(value = "/request-travel")

    public List<TravelRequestDTO> getTravelExpenseStatus(Authentication authentication){
        return statusService.getTravelExpenseStatusDTO(null);
    }
    //manager
    @GetMapping(value = "/settlement-request-manager")
    public List<TravelSettlementDTO> getSettlementTravelStatus(Authentication authentication){
        return statusService.getTravelSettlementStatusDTO(null);
    }

    @GetMapping(value = "/settlement-request-finance")
    public List<ApproveFinanceDTO> getSettlementFinanceStatus(Authentication authentication){
        return statusService.getFinanceSettlementStatusDTO(null);
    }
    

    @GetMapping(value = "/{id}")
    public Status getById(@PathVariable(required = true)Integer id){
        return statusService.getById(id);
    }


    @PostMapping("/decision-approval-request/{id}")
    public ResponseEntity<?> approval(@PathVariable(required = true)Integer id,@RequestBody DecisionApproval decisionApproval, Authentication authentication){
        Status status = statusService.getById(id);
        Status stat = new Status();
        stat.setDate(java.time.LocalDate.now());
        stat.setStatus(decisionApproval.getDecisionApproval());

        Employee employee = new Employee();
        employee.setId(status.getEmployee().getId());
         
        
        stat.setEmployee(employee);
        TravelExpenses travel = new TravelExpenses();
        travel.setId(status.getTravelExpenses().getId());
        stat.setTravelExpenses(travel);
        statusService.save(stat);
        return new ResponseEntity<>("Updated status", HttpStatus.OK);
    }

    @PostMapping("/decision-approvalManager-settlement/{id}")
    public ResponseEntity<?> approvalManager(@PathVariable(required = true)Integer id,@RequestBody DecisionApproval decisionApproval, Authentication authentication){

        Status status = statusService.getById(id);
        Status stat = new Status();
        stat.setDate(java.time.LocalDate.now());
        stat.setStatus(decisionApproval.getDecisionApproval());
        
        
        Employee employee = new Employee();
        employee.setId(status.getEmployee().getId());

        stat.setEmployee(employee);
        TravelExpenses travel = new TravelExpenses();
        travel.setId(status.getTravelExpenses().getId());
        stat.setTravelExpenses(travel);
        statusService.save(stat);
        return new ResponseEntity<>("Updated status", HttpStatus.OK);
    }

    @PostMapping("/decision-approvalFinance-settlement/{id}")
    public ResponseEntity<?> approvalFinance(@PathVariable(required = true)Integer id,@RequestBody DecisionApproval decisionApproval, Authentication authentication){
        
        Status status = statusService.getById(id);
        Status stat = new Status();
        stat.setDate(java.time.LocalDate.now());
        stat.setStatus(decisionApproval.getDecisionApproval());
        
        
        Employee employee = new Employee();
        employee.setId(status.getEmployee().getId());

        stat.setEmployee(employee);
        TravelExpenses travel = new TravelExpenses();
        travel.setId(status.getTravelExpenses().getId());
        stat.setTravelExpenses(travel);
        statusService.save(stat);
        return new ResponseEntity<>("Updated status", HttpStatus.OK);
    }

    @PostMapping("/settlement/{id}")
    public ResponseEntity<?> suttlement(@PathVariable(required = true)Integer id, Authentication authentication){
        String approval = "Settlement Request";
        Status status = statusService.getById(id);
        Status stat = new Status();
        stat.setDate(java.time.LocalDate.now());
        stat.setStatus(approval);
        Employee employee = new Employee();
        employee.setId(status.getEmployee().getId());
        stat.setEmployee(employee);
        TravelExpenses travel = new TravelExpenses();
        travel.setId(status.getTravelExpenses().getId());
        stat.setTravelExpenses(travel);
        statusService.save(stat);
        return new ResponseEntity<>("Settlement Successful", HttpStatus.OK);
    }

    @PostMapping("/settlement-extends/{id}")
    public ResponseEntity<?> suttlement(@PathVariable(required = true) Integer id, Authentication authentication,@RequestBody SettlementExtend suttle){
        TravelExpenses travel = new TravelExpenses();
        travel.setEndDate(suttle.getEnd_date()); //dto
       
        travelExpenseService.updateEndDate(id, travel.getEndDate());
        String approval = "Settlement Request";
        Status status = statusService.getById(id);
        Status stat = new Status();
        stat.setDate(java.time.LocalDate.now());
        stat.setStatus(approval);
        Employee employee = new Employee();
        employee.setId(status.getEmployee().getId());
        stat.setEmployee(employee);
        travel.setId(status.getTravelExpenses().getId());
        stat.setTravelExpenses(travel);
        statusService.save(stat);
        
        return new ResponseEntity<>("Settlement-extend Successful", HttpStatus.OK);
        
    }

}
