package com.example.demo.repositories;


import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.ApproveFinanceDTO;
import com.example.demo.dto.History;
import com.example.demo.dto.TravelRequestDTO;
import com.example.demo.dto.TravelSettlementDTO;
import com.example.demo.models.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

    @Query(value = "select t.id from tbl_tr_travelexpenses t where t.email = ?1 order by id desc limit 1", nativeQuery = true)
    Integer findIdByEmail(String email);

    @Query(value = "Select s.*,t.*, e.* FROM tbl_m_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_tr_travelexpenses t ON s.travelexpenses_id = t.id WHERE s.status = 'Request' AND s.employee_id =(select s.employee_id from tbl_m_status s group by s.employee_id having count(s.employee_id)= 1)", nativeQuery = true)
    public List<Status> findTravelExpenseStatus();

    @Query(value = "Select s.*, e.*, t.* FROM tbl_m_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_tr_travelexpenses t ON s.travelexpenses_id = t.id WHERE s.status = 'Request' AND s.employee_id =(select s.employee_id from tbl_m_status s group by s.employee_id having count(s.employee_id)= 1)", nativeQuery = true)
    public List<TravelRequestDTO> findTravelExpenseStatusDTO(Integer id);

    @Query(value = "Select s.*,t.*, e.* FROM tbl_m_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_tr_travelexpenses t ON s.travelexpenses_id = t.id WHERE s.status = 'Settlement Request' AND s.employee_id =(select s.employee_id from tbl_m_status s group by s.employee_id having count(s.employee_id)= 3)", nativeQuery = true)
    public List<Status> findSettlementTravelStatus();

    @Query(value = "Select s.*, e.*, t.* FROM tbl_m_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_tr_travelexpenses t ON s.travelexpenses_id = t.id WHERE s.status = 'Settlement Request' AND s.employee_id =(select s.employee_id from tbl_m_status s group by s.employee_id having count(s.employee_id)= 3)", nativeQuery = true)
    public List<TravelSettlementDTO> findSettlementTravelStatusDTO(Integer id);

    @Query(value = "Select s.*,t.*, e.* FROM tbl_m_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_tr_travelexpenses t ON s.travelexpenses_id = t.id WHERE s.status = 'Approved Settlement Manager' AND s.employee_id =(select s.employee_id from tbl_m_status s group by s.employee_id having count(s.employee_id)= 4)", nativeQuery = true)
    public List<Status> findSettlementFinanceStatus();

    @Query(value = "Select s.*, e.*, t.* FROM tbl_m_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_tr_travelexpenses t ON s.travelexpenses_id = t.id WHERE s.status = 'Approved Settlement Manager' AND s.employee_id =(select s.employee_id from tbl_m_status s group by s.employee_id having count(s.employee_id)= 4)", nativeQuery = true)
    public List<ApproveFinanceDTO> findSettlementFinanceStatusDTO(Integer id);

    @Query(value = "Select s.id, e.fullname, s.date, t.start_journey, t.end_journey, t.start_date, t.end_date, t.description, s.status FROM tbl_m_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_tr_travelexpenses t ON s.travelexpenses_id = t.id where e.id = ?1", nativeQuery = true)
    List<History> findHistoryTRA(Integer id);

    @Query(value = "Select * FROM tbl_m_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_tr_travelexpenses t ON s.travelexpenses_id = t.id where e.id = ?1", nativeQuery = true)
    List<Status> findHistory(Integer id);

    @Query(value = "select s.*,e.fullname, s.status, s.date from tbl_m_status s join tbl_m_employee e on s.employee_id = e.id where date in (select max(date) from tbl_m_status group by employee_id, travelexpenses_id) and e.email = ?1", nativeQuery = true)
    List<History> findLastHistoryTRA(String email);

    @Query(value = "select s.*,e.fullname, s.status, s.date from tbl_m_status s join tbl_m_employee e on s.employee_id = e.id where date in (select max(date) from tbl_m_status group by employee_id, travelexpenses_id) and e.id = ?1", nativeQuery = true)
    List<Status> findLastHistoryTRA(Integer id);

    @Modifying
    @Transactional
    @Query(value = "Update tbl_m_status s JOIN tbl_m_employee e Set s.status = :status, s.date = :date where s.id = :id AND e.manager_id = :manager_id", nativeQuery = true)
    public void approval(@Param("status")String status,@Param ("date") LocalDate date,@Param ("manager_id") Integer manager_id, @Param("id")Integer id);


    
   // "UPDATE Team t LEFT JOIN t.members m SET t.current = :current WHERE t.current = :current_true AND m.account = :account"

    // @Modifying
    // @Transactional
    // @Query(value = "Update tbl_m_status s JOIN tbl_tr_travelexpenses t Set s.status = :status, s.date = :date, t.end_date ")

}
