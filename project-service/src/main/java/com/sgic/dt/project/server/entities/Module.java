package com.sgic.dt.project.server.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(schema = "project-service", name = "module")

public class Module {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private Long projectId;
	
	/*//------------------ RELATIONSHIP BETWEEN MODULE AND PROJECT  -------------------//
		@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.PERSIST})
		@JoinColumn(name = "projectId", referencedColumnName = "id", nullable = true)
		private Project project;
			public Project getProject() {
				return project;
			}

			public void setProject(Project project) {
				this.project = project;
			}
	*/
	
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
