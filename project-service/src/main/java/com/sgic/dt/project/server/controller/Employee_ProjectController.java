package com.sgic.dt.project.server.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.common.api.response.ContentResponse;
import com.sgic.common.api.response.ListContentResponse;
import com.sgic.dt.project.dto.mapper.Mapper;
import com.sgic.dt.project.server.dto.Employee_ProjectDTO;
import com.sgic.dt.project.server.dto.ProjectDTO;
import com.sgic.dt.project.server.entities.Employee_Project;
import com.sgic.dt.project.server.services.Employee_ProjectService;
import com.sgic.dt.project.server.util.ErrorCodes;

@RestController
@RequestMapping("/api/v1")
public class Employee_ProjectController {
	@Autowired
	Employee_ProjectService employee_projectService;
	
	@Autowired
	ErrorCodes errorMessages;

	@Autowired
	private Mapper mapper;
	
	private static final Logger logger = Logger.getLogger(Employee_ProjectController.class);	
	
	//=============== ADD A Employee_Project =================================================//
	@PostMapping(value = "/employee_project")
	public ResponseEntity<Object> createEmployee_Project(@RequestBody Employee_ProjectDTO employee_projectDTO)
	{
		Employee_Project employee_project = mapper.map(employee_projectDTO, Employee_Project.class);
		
		employee_projectService.createEmployee_Project(employee_project);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.CREATED), HttpStatus.CREATED);
	}
	
	//=============== GET ALL Employee_Project ===============================//
	@GetMapping(value = "/employee_project")
	  public ResponseEntity<Object> getmployee_Projects() 
	{
		List <Employee_Project> employee_projectList = employee_projectService.getAllEmployee_Projects();
		List<Employee_ProjectDTO> employee_projectDTOList = mapper.map(employee_projectList, Employee_ProjectDTO.class);
		//return employee_projectDTOList;
		return new ResponseEntity<>(new ListContentResponse<Employee_ProjectDTO>("List",employee_projectDTOList, RestApiResponseStatus.RECEIVED), HttpStatus.OK);
	}
	
	//=============== GET A Employee_Project BY ID =====================================//
	@GetMapping(value = "/employee_project/{id}")
	public ResponseEntity<Object> getEmployee_ProjectById(@PathVariable Long id)
	{
		Employee_Project employee_project = employee_projectService.getEmployee_ProjectById(id);
		
		Employee_ProjectDTO employee_projectDTO = mapper.map(employee_project, Employee_ProjectDTO.class);
		//return new ResponseEntity<Employee_ProjectDTO>(employee_projectDTO, HttpStatus.OK);
		return new ResponseEntity<>(new ContentResponse<Employee_ProjectDTO>("Object", employee_projectDTO, RestApiResponseStatus.RECEIVED), HttpStatus.OK);	
		
	}
	
	
	//=============== UPDATE Employee_Project ============================================================//
	@PutMapping(value = "/employee_project")
	public ResponseEntity<Object> updateEmployee_Project(@RequestBody Employee_ProjectDTO employee_projectDTO)
	{
		Employee_Project employee_project = mapper.map(employee_projectDTO, Employee_Project.class);
		employee_projectService.updateEmployee_Project(employee_project);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.UPDATED), HttpStatus.OK);
	}
	
	//=============== DELETE Employee_Project BY ID =========================//
	@DeleteMapping(value = "/employee_project/{id}")
	public ResponseEntity<Object> deleteEmployee_Project(@PathVariable Long id) {
		employee_projectService.deleteById(id);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.DELETED), HttpStatus.OK);
	}
	
	
	//=============== GET ALL BY PROJECT ID ===============================//
	@GetMapping(value = "/employee_project/byproject/{id}")
	  public ResponseEntity<Object> getALLByProjectId(@PathVariable Long id) 
	{
		List <Employee_Project> employee_projectList = employee_projectService.getAllByProjectId(id);
		
		List<Employee_ProjectDTO> employee_projectDTOList = mapper.map(employee_projectList, Employee_ProjectDTO.class);
		
		//return employee_projectDTOList;
		return new ResponseEntity<>(new ListContentResponse<Employee_ProjectDTO>("List",employee_projectDTOList, RestApiResponseStatus.RECEIVED), HttpStatus.OK);
	}
	/*
	
	//=============== NUMBER OF INPROCESS PROJECTS =======================//
	@GetMapping(value = "/project/inprocess")
	public Long getInProcessProjects() 
	{
		Long num  = projectService.getNumberOfInprocess();
		System.out.println(projectService.getNumberOfInprocess());
		//Long totalNum=(long) projectList.size();
		return num;
	}
	//=============== NUMBER OF INPROCESS PROJECTS =======================//
	@GetMapping(value = "/project/completed")
	public Long getCompletedProjects() 
	{
		Long num  = projectService.getNumberOfCompleted();
		//System.out.println(projectService.getNumberOfInprocess());
		//Long totalNum=(long) projectList.size();
		return num;
	}
*/
	
}
