package com.example.app.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.pma.dao.EmployeeRepository;
import com.example.app.pma.dao.ProjectRepository;
import com.example.app.pma.entities.Employee;
import com.example.app.pma.entities.Project;

@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;

	@RequestMapping("/new")
	public String displayForm(Model model)
	{
		model.addAttribute("employee", new Employee());
		List<Project> employeeList=projectRepository.findAll();
		model.addAttribute("allProjects", employeeList);
		return "new-employee";
	}
	
	@RequestMapping(value = "/save",method =RequestMethod.POST)
	public String createProject(Employee employee, Model model)
	{
		employeeRepository.save(employee);
		return "NewFile";
	}
	
}
