package com.sgic.defect.server.dto;

import java.time.LocalDateTime;
import com.mysql.cj.jdbc.Blob;

public class DefectDto {
	private Long id;
	private String name;
	private String description;
	private Long projectId;
	private Long moduleId;
	private Long submoduleId;
	private Long typeId;
	private Long severityId;
	private Long priorityId;
	private Long statusId;
	private Blob attachment;
	private String stepsToCreate;
	private String foundIn;
	private String fixedIn;
	private Long assignedTo;
	private Long assignedBy;
	private Long createdBy;	
	private LocalDateTime createdOn;	
	private Long updatedBy;	
	private LocalDateTime updatedOn;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Long getProjectId() {
		return projectId;
	}
	public Long getModuleId() {
		return moduleId;
	}
	public Long getSubmoduleId() {
		return submoduleId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public Long getSeverityId() {
		return severityId;
	}
	public Long getPriorityId() {
		return priorityId;
	}
	public Long getStatusId() {
		return statusId;
	}
	public Blob getAttachment() {
		return attachment;
	}
	public String getStepsToCreate() {
		return stepsToCreate;
	}
	public String getFoundIn() {
		return foundIn;
	}
	public String getFixedIn() {
		return fixedIn;
	}
	public Long getAssignedTo() {
		return assignedTo;
	}
	public Long getAssignedBy() {
		return assignedBy;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	public void setSubmoduleId(Long submoduleId) {
		this.submoduleId = submoduleId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public void setSeverityId(Long severityId) {
		this.severityId = severityId;
	}
	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public void setAttachment(Blob attachment) {
		this.attachment = attachment;
	}
	public void setStepsToCreate(String stepsToCreate) {
		this.stepsToCreate = stepsToCreate;
	}
	public void setFoundIn(String foundIn) {
		this.foundIn = foundIn;
	}
	public void setFixedIn(String fixedIn) {
		this.fixedIn = fixedIn;
	}
	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}
	public void setAssignedBy(Long assignedBy) {
		this.assignedBy = assignedBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	
}
