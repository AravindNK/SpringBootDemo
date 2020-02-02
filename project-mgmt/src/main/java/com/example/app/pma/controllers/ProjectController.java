package com.example.app.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.pma.dao.EmployeeRepository;
import com.example.app.pma.dao.ProjectRepository;
import com.example.app.pma.entities.Employee;
import com.example.app.pma.entities.Project;

@Controller
@RequestMapping(path = "/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping("/new")
	public String displayForm(Model model)
	{
		model.addAttribute("project", new Project());
		List<Employee> employeeList=employeeRepository.findAll();
		model.addAttribute("allEmployees", employeeList);
		return "new-project";
	}
	
	@RequestMapping(value = "/save",method =RequestMethod.POST)
	public String createProject(Project project,Model model)
	{
		projectRepository.save(project);
		return "NewFile";
	}
	
}
