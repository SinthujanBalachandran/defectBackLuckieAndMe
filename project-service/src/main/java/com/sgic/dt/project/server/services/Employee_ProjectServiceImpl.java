package com.sgic.dt.project.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.dt.project.server.entities.Employee_Project;
import com.sgic.dt.project.server.repositories.Employee_ProjectRepository;

@Service
public class Employee_ProjectServiceImpl implements Employee_ProjectService{
	@Autowired
	private Employee_ProjectRepository employee_ProjectRepository;
	
	 @Transactional(readOnly = false)
	 public Employee_Project createEmployee_Project (Employee_Project employee_project)
	 {
		 Employee_Project responseEmployee_Project = employee_ProjectRepository.save(employee_project);
		return responseEmployee_Project;
	 }
	 
	 @Transactional(readOnly = false)
	 public List<Employee_Project> getAllEmployee_Projects() 
	 {
		 List <Employee_Project> employees_projects = 	employee_ProjectRepository.findAll();
		 return employees_projects;
	 }
	 
	 @Transactional(readOnly = false)
	 public Employee_Project getEmployee_ProjectById(Long id) 
	 {
		 Employee_Project responseModule  = employee_ProjectRepository.findEmployee_ProjectById(id);
		return responseModule;
	 }
	 
	 @Transactional(readOnly = false)
	 public Employee_Project updateEmployee_Project (Employee_Project employee_Project)
	 {
		 Employee_Project responseEmployee_Project = employee_ProjectRepository.save(employee_Project);
		return responseEmployee_Project;
	 }
	 
	 @Transactional(readOnly = false)
	 public boolean deleteById(Long id) 
	 {
		 employee_ProjectRepository.deleteById(id);
		return true;
	 }
	 
	 //================== GET ALL BY PROJECT ID ===================//
	 @Transactional(readOnly = false)
	 public List<Employee_Project> getAllByProjectId(Long id) 
	 {
		 List <Employee_Project> employee_projects = employee_ProjectRepository.findEmployee_ProjectsByProjectId(id);
		 return employee_projects;
	 }
	 
	 @Transactional(readOnly = false)
	 public List<Employee_Project> getAllByEmployeeId(Long id) 
	 {
		 List <Employee_Project> employee_projects = employee_ProjectRepository.findEmployee_ProjectsByEmployeeId(id);
		 return employee_projects;
	 }
	 
	 @Transactional(readOnly = false)
	 public boolean deleteByEmployeeId_ProjectId(Long employeeId, Long projectId) 
	 {
		 employee_ProjectRepository.deleteByEmployeeId_ProjectId(employeeId, projectId);
		return true;
	 }
	 /*
	//================ Get Count of InProcess Projects ====================//
	 @Transactional(readOnly = false)
	 public Long getNumberOfInprocess() 
	 {
		Long count =projectRepository.countByStatus("In Process");
		return count;
	 }
	 //================ Get Count of Completed Projects ====================//
	 @Transactional(readOnly = false)
	 public Long getNumberOfCompleted() 
	 {
		Long count =projectRepository.countByStatus("Completed");
		return count;
	 }*/

}
