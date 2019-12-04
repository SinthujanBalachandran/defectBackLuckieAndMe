package com.sgic.dt.project.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.dt.project.server.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	Project findProjectById(Long id);
	long countByStatus(String status);
	
	
	//@Query("SELECT count (status) FROM Project p WHERE p.status <> ?1")
	//Long countStatus (String status);
}