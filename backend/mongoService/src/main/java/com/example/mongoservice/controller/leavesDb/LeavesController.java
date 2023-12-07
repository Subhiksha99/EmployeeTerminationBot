package com.example.mongoservice.controller.leavesDb;


import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.LeaveFoundException;
import com.example.mongoservice.model.leavesDb.Leave;
import com.example.mongoservice.model.leavesDb.Leaves;
import com.example.mongoservice.service.leavesDb.ILeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeavesController {
    @Autowired
    private ILeavesService leavesService;

    //get leave history of all employees
    @GetMapping("/leaves/all")
    public List<Leaves> getLeaves() {
        return leavesService.getAllLeaveHistories();
    }

    //get leave history of all employees
    @GetMapping("/leaves/getById")
    public Leaves getLeavesById(@RequestParam("id") int empId ) throws EmployeeNotFoundException {
        return leavesService.getLeaveTempByEmpId(empId);
    }

    //post a new entry of leave template for a new employee
    @PostMapping("/leaves/add")
    public Leaves addCustomer(@RequestBody Leaves leaveTempObj) throws EmployeeFoundException {
        return leavesService.addLeaveTemp(leaveTempObj);
    }

    //post a new entry of leave for an existing employee
    @PostMapping("/leaves/leave/add/{id}")
    public Leaves addCustomer(@RequestBody Leave leaveObj, @PathVariable("id") int empId) throws LeaveFoundException, EmployeeNotFoundException {
        return leavesService.addLeave(leaveObj,empId);
    }



    //PUT - update more than one property of the leave template
    @PutMapping("/leaves/update")
    public Leaves updateCustomer(@RequestBody Leaves leaveTempObj) throws EmployeeNotFoundException {
        return leavesService.updateLeaveTemp(leaveTempObj);
    }

    //Delete- leaveHistory entry of an employee returns removed leave template
    @DeleteMapping("/leaves/deleteById")
    public Leaves deleteLeavesById(@RequestParam("id") int empId) throws EmployeeNotFoundException {
        return leavesService.deleteLeaveHistoryByEmpId((empId));
    }
    //Delete- leaveHistory entry of an employee returns nothing
    @DeleteMapping("/leaves/deleteVoid/{id}")
    public void deleteLeavesByIdVoidReturn(@PathVariable("id") int empId) throws EmployeeNotFoundException {
        leavesService.deleteLeaveHistoryByEmpIdVoidReturn(empId);
    }

}
