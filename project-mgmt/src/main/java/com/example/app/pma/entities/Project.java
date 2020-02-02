package com.example.app.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projectId;
	private String projectName;
	private String projectStatus;
	private String projectDesc;
	// @OneToMany(mappedBy = "projectID")

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "Employee_Project", joinColumns = @JoinColumn(name = "projectId"), inverseJoinColumns = @JoinColumn(name = "employeeId"))
	private List<Employee> employees;

	public long getProjectId() {
		return projectId;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String projectName, String projectStatus, String projectDesc) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.projectDesc = projectDesc;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

}
