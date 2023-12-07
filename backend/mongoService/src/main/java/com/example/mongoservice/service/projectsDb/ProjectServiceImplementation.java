package com.example.mongoservice.service.projectsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.projectsDb.Projects;
import com.example.mongoservice.repository.projectsDb.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImplementation implements IProjectService{

    @Autowired
    private IProjectRepository projectsRepo;
    @Override
    public List<Projects> getAllProjects() {
        return projectsRepo.findAll();
    }

    @Override
    public Projects getProjectsById(long empId) throws EmployeeNotFoundException {
        Optional<Projects> tempProjects =  projectsRepo.findById(empId);
        if(tempProjects.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the Given ID"+empId+" does not exist");
        }
        return tempProjects.get();
    }

    @Override
    public Projects deleteProjectById(long empId) throws EmployeeNotFoundException {
        Optional<Projects> tempProjects =  projectsRepo.findById(empId);
        if(tempProjects.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the Given ID"+empId+" does not exist");
        }
        projectsRepo.deleteById(empId);
        return tempProjects.get();
    }

    @Override
    public Projects addProject(Projects projects) throws EmployeeFoundException {
        long empId = projects.getEmployeeId();
        Optional<Projects> tempProjects =  projectsRepo.findById(empId);
        if(tempProjects.isPresent()){
            throw new EmployeeFoundException("Employee with the Given ID"+empId+" already exist");
        }
        projectsRepo.save(projects);
        return projectsRepo.save(projects);
    }

    @Override
    public Projects updateProject(Projects projects) throws EmployeeNotFoundException {
        long empId = projects.getEmployeeId();
        Optional<Projects> tempProjects =  projectsRepo.findById(empId);
        if(tempProjects.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the Given ID"+empId+" does not exist");
        }
        projectsRepo.save(projects);
        return tempProjects.get();
    }
}

