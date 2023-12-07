package com.example.mongoservice.service.projectsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.projectsDb.Projects;

import java.util.List;

public interface IProjectService {
    List<Projects> getAllProjects();
    //Get: get all learnings by ID
    Projects getProjectsById(long empId) throws EmployeeNotFoundException;

    //Get : delete Learning by Id
    Projects deleteProjectById(long empId) throws EmployeeNotFoundException;

    Projects addProject(Projects projects) throws EmployeeFoundException;

    //Update: an already exisiting learning
    Projects updateProject(Projects projects) throws EmployeeNotFoundException;

}
