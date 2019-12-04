package com.sgic.dt.project.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.dt.project.server.entities.Module;


public interface ModuleRepository extends JpaRepository<Module, Long>{
	Module findModuleById(Long id);
	Module findModuleByProjectId(Long id);
	List<Module> findModulesByProjectId(Long projectId);
	
	//@Query(value = "SELECT id,name,project_id FROM module m WHERE m.project_id <> ?1",nativeQuery = true)
	//List<Module> getModulesByProjectId(Long projectId);
	
	
	//List <Module> modules = findAllByProjectId(Long id);
	//long countByStatus(String status);
	
	
	
	//@Query("SELECT count (status) FROM Project p WHERE p.status <> ?1")
	//Long countStatus (String status);
}