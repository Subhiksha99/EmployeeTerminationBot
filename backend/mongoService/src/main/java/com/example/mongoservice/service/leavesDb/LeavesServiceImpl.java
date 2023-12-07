package com.example.mongoservice.service.leavesDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.LeaveFoundException;
import com.example.mongoservice.model.leavesDb.Leave;
import com.example.mongoservice.model.leavesDb.Leaves;
import com.example.mongoservice.repository.leavesDb.ILeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LeavesServiceImpl implements ILeavesService {

    @Autowired
    private ILeavesRepository leavesRepo;

    @Override
    public List<Leaves> getAllLeaveHistories() {
        return leavesRepo.findAll();
    }

    @Override
    public Leaves addLeave(Leave leave, int empId) throws EmployeeNotFoundException, LeaveFoundException {
        Leaves leaveTempObj = getLeaveTempByEmpId(empId);

        //the returned leave object is null exception is not handled here
        List<Leave> leaveListObj = leaveTempObj.getLeavesList();
        for(Leave leaveTemp:leaveListObj){
            if(leaveTemp.getLeaveId()==leave.getLeaveId()){
                throw new LeaveFoundException("A leave record with the given leave id is already present in the database. If you want to update the information please use appropriate API or modify the leave Id");
            }
        }
        leaveListObj.add(leave);
        leaveTempObj.setLeavesList(leaveListObj);
        return leavesRepo.save(leaveTempObj);
    }

    @Override
    public Leaves addLeaveTemp(Leaves leaveTemp) throws EmployeeFoundException {
        List<Leaves> leaveHistoriesObj=getAllLeaveHistories();
        for(Leaves leaveTempObj:leaveHistoriesObj){
            if(leaveTempObj.getEmployeeId()==leaveTemp.getEmployeeId()){
                throw new EmployeeFoundException("The Leave history record for the employee with the id"+leaveTemp.getEmployeeId()+"already exits in the database. Please verify the employee id or use API intended for Update operation");
            }
        }
        return leavesRepo.save(leaveTemp);
    }

    @Override
    public Leaves getLeaveTempByEmpId(int empId) throws EmployeeNotFoundException {
        Optional<Leaves> leaveTempOptional = leavesRepo.findById(empId);
        return leaveTempOptional.orElseThrow(() -> new EmployeeNotFoundException("No record found in LeaveHistory Database with Employee Id:" + empId));
    }

    @Override
    public Leaves updateLeaveTemp(Leaves leaveTemp) throws EmployeeNotFoundException {
        int empId=leaveTemp.getEmployeeId();
        Optional<Leaves> leaveTempOptional = leavesRepo.findById(empId);
        if(leaveTempOptional.isPresent()) {
            return leavesRepo.save(leaveTemp);
        }
        throw new EmployeeNotFoundException("No record found in LeaveHistory Database with Employee Id"+ empId +"present in the provided information:" );
    }


    @Override
    public void deleteLeaveHistoryByEmpIdVoidReturn(int empId) throws EmployeeNotFoundException {
        Optional<Leaves> leaveTempOptional = leavesRepo.findById(empId);
        if(leaveTempOptional.isPresent()) {
            leavesRepo.deleteById(empId);
            return;
        }
        throw new EmployeeNotFoundException("No record found in LeaveHistory Database with Employee Id:" + empId);
    }

    @Override
    public Leaves deleteLeaveHistoryByEmpId(int empId) throws EmployeeNotFoundException {
        Optional<Leaves> leaveTempOptional = leavesRepo.findById(empId);
        if(leaveTempOptional.isPresent()) {
            leavesRepo.deleteById(empId);
            return leaveTempOptional.get();
        }
        throw new EmployeeNotFoundException("No record found in LeaveHistory Database with Employee Id:" + empId);
    }
}
