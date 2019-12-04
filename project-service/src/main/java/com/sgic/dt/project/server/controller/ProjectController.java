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
import com.sgic.dt.project.server.dto.ProjectDTO;
import com.sgic.dt.project.server.entities.Project;
import com.sgic.dt.project.server.services.ProjectService;
import com.sgic.dt.project.server.util.ErrorCodes;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ErrorCodes errorMessages;

	@Autowired
	private Mapper mapper;
	
	private static final Logger logger = Logger.getLogger(ProjectController.class);	
	
	//=============== ADD A PROJECT =================================================//
	@PostMapping(value = "/project")
	public ResponseEntity<Object> createProject(@RequestBody ProjectDTO projectDto)
	{
		Project project = mapper.map(projectDto, Project.class);
		projectService.createProject(project);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.CREATED), HttpStatus.CREATED);
	}
	
	//=============== GET ALL PROJECTS ===============================//
	@GetMapping(value = "/project")
	 public ResponseEntity<Object> getProjects() 
	{
		List <Project> projectList = projectService.getAllProjects();
		List<ProjectDTO> projectDtoList = mapper.map(projectList, ProjectDTO.class);
		//return projectDtoList;
		return new ResponseEntity<>(new ListContentResponse<ProjectDTO>("List",projectDtoList, RestApiResponseStatus.RECEIVED), HttpStatus.OK);
		
	}
	
	
	//=============== GET A PROJECT BY ID =====================================//
	@GetMapping(value = "/project/{id}")
	public ResponseEntity<Object> getProjectById(@PathVariable Long id)
	{
		Project project = projectService.getProjectById(id);
		ProjectDTO projectDto = mapper.map(project, ProjectDTO.class);
		//return new ResponseEntity<ProjectDTO>(projectDto, HttpStatus.OK);
		return new ResponseEntity<>(new ContentResponse<ProjectDTO>("Object", projectDto, RestApiResponseStatus.RECEIVED), HttpStatus.OK);	
		
	}
	
	//=============== UPDATE PROJECT ============================================================//
	@PutMapping(value = "/project")
	public ResponseEntity<Object> saveProject(@RequestBody ProjectDTO projectDto)
	{
		Project project = mapper.map(projectDto, Project.class);
		projectService.updateProject(project);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.UPDATED), HttpStatus.OK);
	}
	
	//=============== DELETE PROJECT BY ID =========================//
	@DeleteMapping(value = "/project/{id}")
	public ResponseEntity<Object> deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
	    //return new ResponseEntity<>(id, HttpStatus.OK);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.DELETED), HttpStatus.OK);
	}
	
	//=============== TOTAL NUMBER OF PROJECTS =======================//
	@GetMapping(value = "/project/total")
	public Long getTotalProjects() 
	{
		List <Project> projectList = projectService.getAllProjects();
		Long totalNum=(long) projectList.size();
		return totalNum;
	}
	
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

	
}
