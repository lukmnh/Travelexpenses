package com.example.demo.services;


import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.ApproveFinanceDTO;
import com.example.demo.dto.History;
import com.example.demo.dto.TravelRequestDTO;
import com.example.demo.dto.TravelSettlementDTO;
import com.example.demo.models.Status;

public interface StatusService {
    public Boolean save(Status status);

    public Integer getIdByEmail(String email);

    public List<Status>  getTravelExpenseStatus();

    public List<Status> getSettlementTravelStatus();

    public List<Status> getSettlementFinanceStatus();

    public Boolean approval(String status,LocalDate date, Integer manager_id, Integer id);

    public Status getById(Integer id);

    public List<TravelRequestDTO> getTravelExpenseStatusDTO(Integer id);

    public List<TravelSettlementDTO> getTravelSettlementStatusDTO(Integer id);

    public List<ApproveFinanceDTO> getFinanceSettlementStatusDTO(Integer id);
    
    public List<History> getHistoryTRA(Integer id);

    public List<Status> getHistory(Integer id);

    public List<History> getLastHistory(Integer id);
}
