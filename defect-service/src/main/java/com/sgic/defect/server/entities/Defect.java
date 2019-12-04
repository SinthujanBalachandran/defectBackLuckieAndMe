package com.sgic.defect.server.entities;

import java.sql.Blob;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sgic.defect.server.entities.Priority;
import com.sgic.defect.server.entities.Severity;
import com.sgic.defect.server.entities.Status;
import com.sgic.defect.server.entities.Type;


@Entity
@Table(schema = "defect-service", name = "defect")
public class Defect {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdOn;	
	private Long updatedBy;	
	@Column(columnDefinition="TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime updatedOn;
	
	
//	@ManyToOne()
//	@JoinColumn(name="projectId", insertable=false, updatable=false)
//	private Project project;
//	
//	@ManyToOne()
//	@JoinColumn(name="moduleId", insertable=false, updatable=false)
//	private ProjectModule module;
//	
//	@ManyToOne()
//	@JoinColumn(name="submoduleId", insertable=false, updatable=false)
//	private Submodule submodule;
	
	@ManyToOne()
	@JoinColumn(name="typeId", insertable=false, updatable=false)
	private Type type;
	
	@ManyToOne()
	@JoinColumn(name="severityId", insertable=false, updatable=false)
	private Severity severity;
	
	@ManyToOne()
	@JoinColumn(name="priorityId", insertable=false, updatable=false)
	private Priority priority;
	
	@ManyToOne()
	@JoinColumn(name="statusId", insertable=false, updatable=false)
	private Status status;
	
//	@ManyToOne()
//	@JoinColumn(name="assignedTo", insertable=false, updatable=false)
//	private Employee employee;
//	
//	@ManyToOne()
//	@JoinColumn(name="assignedBy", insertable=false, updatable=false)
//	private Employee employee;
//	
//	@ManyToOne()
//	@JoinColumn(name="createdBy", insertable=false, updatable=false)
//	private Employee employee;
//	
//	@ManyToOne()
//	@JoinColumn(name="updatedBy", insertable=false, updatable=false)
//	private Employee employee;

	public Defect() {

	}

	public Defect(Long id, String name, String description, Long projectId, Long moduleId, Long submoduleId, Long typeId,
			Long severityId, Long priorityId, Long statusId, Blob attachment, String stepsToCreate, String foundIn,
			String fixedIn, Long assignedTo, Long assignedBy, Long createdBy, LocalDateTime createdOn, Long updatedBy,
			LocalDateTime updatedOn) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.projectId = projectId;
		this.moduleId = moduleId;
		this.submoduleId = submoduleId;
		this.typeId = typeId;
		this.severityId = severityId;
		this.priorityId = priorityId;
		this.statusId = statusId;
		this.attachment = attachment;
		this.stepsToCreate = stepsToCreate;
		this.foundIn = foundIn;
		this.fixedIn = fixedIn;
		this.assignedTo = assignedTo;
		this.assignedBy = assignedBy;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

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
	
//	public Project getProject() {
//		return project;
//	}
//	
//	public ProjectModule getModule() {
//		return module;
//	}
//	
//	public Submodule getSubmodule() {
//		return submodule;
//	}
	
	public Type getType() {
		return type;
	}
	
	public Severity getSeverity() {
		return severity;
	}
	
	public Priority getPriority() {
		return priority;
	}
	
	public Status getStatus() {
		return status;
	}
	
//	public Employee getEmployee() {
//		return employee;
//	}
	
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
	
//	public void setProject(Project project) {
//		this.project = project;
//	}
//	
//	public void setModule(ProjectModule module) {
//		this.module = module;
//	}
//	
//	public void setSubmodule(Submodule submodule) {
//		this.submodule = submodule;
//	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

}
