package com.example.demo.services;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApproveFinanceDTO;
import com.example.demo.dto.History;
import com.example.demo.dto.TravelRequestDTO;
import com.example.demo.dto.TravelSettlementDTO;
import com.example.demo.models.Status;
import com.example.demo.repositories.StatusRepository;


@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Boolean save(Status status) {
        statusRepository.save(status);
        return statusRepository.findById(status.getId()).isPresent();
    }

    @Override
    public Integer getIdByEmail(String email) {
        return statusRepository.findIdByEmail(email);
    }

    @Override
    public List<Status> getTravelExpenseStatus() {
        return statusRepository.findTravelExpenseStatus();
    }


    @Override
    public Status getById(Integer id) {
        return statusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("status not found"));
    }

    @Override
    public Boolean approval(String status,LocalDate date,Integer manager_id, Integer id) {
        statusRepository.approval(status, date,manager_id, id);
        return statusRepository.findById(id).isPresent();
    }

    @Override
    public List<TravelRequestDTO> getTravelExpenseStatusDTO(Integer id) {
        List<Status> status = statusRepository.findTravelExpenseStatus();

        return status.stream().map(it -> convertToDto(it)).collect(Collectors.toList());
    }

    public TravelRequestDTO convertToDto(Status status){
        return new TravelRequestDTO(status.getId(),
                            status.getTravelExpenses().getId(),
                            status.getEmployee().getFullname(),
                            status.getDate(),
                            status.getTravelExpenses().getStartJourney(),
                            status.getTravelExpenses().getEndJourney(),
                            status.getTravelExpenses().getStartDate(),
                            status.getTravelExpenses().getEndDate(),
                            status.getTravelExpenses().getDescription(),
                            status.getStatus()
                            );
    }

    @Override
    public List<Status> getSettlementTravelStatus() {
        return statusRepository.findSettlementTravelStatus();
    }

    @Override
    public List<TravelSettlementDTO> getTravelSettlementStatusDTO(Integer id) {
        List<Status> status = statusRepository.findSettlementTravelStatus();
        return status.stream().map(it -> convertToDTO(it)).collect(Collectors.toList());
    }

    public TravelSettlementDTO convertToDTO(Status status){
        return new TravelSettlementDTO(status.getId(),
                            status.getTravelExpenses().getId(), 
                            status.getEmployee().getFullname(),
                            status.getDate(),
                            status.getTravelExpenses().getStartJourney(),
                            status.getTravelExpenses().getEndJourney(),
                            status.getTravelExpenses().getStartDate(),
                            status.getTravelExpenses().getEndDate(),
                            status.getTravelExpenses().getDescription(),
                            status.getStatus()
                            );
    }

    @Override
    public List<Status> getSettlementFinanceStatus() {
        return statusRepository.findSettlementFinanceStatus();
    }

    @Override
    public List<ApproveFinanceDTO> getFinanceSettlementStatusDTO(Integer id) {
        List<Status> status = statusRepository.findSettlementFinanceStatus();
        return status.stream().map(it -> converttoDTO(it)).collect(Collectors.toList());
    }

    public ApproveFinanceDTO converttoDTO(Status status){
        return new ApproveFinanceDTO(status.getId(),
                            status.getTravelExpenses().getId(), 
                            status.getEmployee().getFullname(),
                            status.getDate(),
                            status.getTravelExpenses().getStartJourney(),
                            status.getTravelExpenses().getEndJourney(),
                            status.getTravelExpenses().getStartDate(),
                            status.getTravelExpenses().getEndDate(),
                            status.getTravelExpenses().getDescription(),
                            status.getStatus()
                            );
    }

    @Override
    public List<History> getHistoryTRA(Integer id) {
        List<Status> status = statusRepository.findHistory(id);
        return status.stream().map(this::convertToDtoo).collect(Collectors.toList());
    }

    @Override
    public List<Status> getHistory(Integer id) {
        return statusRepository.findHistory(id);
    }

    public History convertToDtoo(Status status) {
        return new History(status.getId(), status.getEmployee().getFullname(), status.getStatus(), status.getDate(),
                status.getTravelExpenses().getStartJourney(), status.getTravelExpenses().getEndJourney(),
                status.getTravelExpenses().getStartDate(), status.getTravelExpenses().getEndDate(),
                status.getTravelExpenses().getDescription(),
                status.getEmployee().getId(), status.getTravelExpenses().getId());
    }

    @Override
    public List<History> getLastHistory(Integer id) {
        List<Status> status = statusRepository.findLastHistoryTRA(id);
        return status.stream().map(this::convertToDtoo).collect(Collectors.toList());
    }
}