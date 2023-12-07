package com.example.mongoservice.service.leavesDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.LeaveFoundException;
import com.example.mongoservice.exception.LeaveNotFoundException;
import com.example.mongoservice.model.leavesDb.Leave;
import com.example.mongoservice.model.leavesDb.Leaves;

import java.util.List;

public interface ILeavesService {

        List<Leaves> getAllLeaveHistories();
        Leaves addLeave(Leave leave, int empId) throws EmployeeNotFoundException, LeaveFoundException;
        Leaves addLeaveTemp(Leaves leave) throws EmployeeFoundException;
        Leaves getLeaveTempByEmpId(int empId) throws EmployeeNotFoundException;
        Leaves updateLeaveTemp(Leaves leaveTemp) throws EmployeeNotFoundException;
        void deleteLeaveHistoryByEmpIdVoidReturn(int empId) throws EmployeeNotFoundException;
        Leaves deleteLeaveHistoryByEmpId(int empId) throws EmployeeNotFoundException;

}
