package com.example.app.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.app.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	List<Project> findAll();
}
