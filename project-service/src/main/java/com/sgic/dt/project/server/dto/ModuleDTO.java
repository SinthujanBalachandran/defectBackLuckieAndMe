package com.sgic.dt.project.server.dto;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public class ModuleDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;

	private String name;
	
	private Long projectId;

	
	//=================== GETTERS AND SETTERS  =================//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	//================================================//
	
	
}
