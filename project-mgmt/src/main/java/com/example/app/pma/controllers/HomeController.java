package com.example.app.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.pma.dao.EmployeeRepository;
import com.example.app.pma.dao.ProjectRepository;
import com.example.app.pma.entities.Employee;
import com.example.app.pma.entities.Project;

@Controller
@RequestMapping(path = "/")
public class HomeController {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("")
	public String displayHome(Model model)
	{
		
		List<Project> projectList=projectRepository.findAll();
		List<Employee> employeeList=employeeRepository.findAll();
		model.addAttribute("projectList", projectList);
		model.addAttribute("employeeList", employeeList);
		return "Home";
	}
}
