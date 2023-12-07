package com.example.mongoservice.controller.projectsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.projectsDb.Projects;
import com.example.mongoservice.service.projectsDb.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectsController {
    @Autowired
    private IProjectService projectService;

    @GetMapping("/projects/all")
    public ResponseEntity<List<Projects>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
    }
    @GetMapping("/projects/getById")
    public ResponseEntity<Projects> getProjectsById(@RequestParam long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(projectService.getProjectsById(empId),HttpStatus.OK);
    }
    @DeleteMapping("/projects/deleteById")
    public ResponseEntity<Projects> deleteProjectsById(@RequestParam("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(projectService.deleteProjectById(empId),HttpStatus.OK);
    }
    @PostMapping("/projects/add")
    public ResponseEntity<Projects> addProjects(@RequestBody Projects projects) throws EmployeeFoundException {
        return new ResponseEntity<>(projectService.addProject(projects),HttpStatus.OK);
    }

    @PutMapping("/projects/update")
    public ResponseEntity<Projects> updateProjects(@RequestBody Projects projects) throws EmployeeNotFoundException {
        return new ResponseEntity<>(projectService.updateProject(projects), HttpStatus.OK);
    }
}
