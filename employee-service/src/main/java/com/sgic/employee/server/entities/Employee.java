package com.sgic.employee.server.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "employee-service", name = "employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;	
	private String designation;	
	private String address;
	private String phoneNumber;
	private String email;
	private String active;
	private Date startDate;
	private Date leaveDate;
	private String remarks;
	private Date added_at;
	private Date updated_at;
	
	// CONSTRUCTOR =======================================================================================================
	
	public Employee(Long id, String firstName, String lastName, Date dateOfBirth, String designation, String address,
			String phoneNumber, String email, String active, Date startDate, Date leaveDate, String remarks,
			Date added_at, Date updated_at) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.designation = designation;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.active = active;
		this.startDate = startDate;
		this.leaveDate = leaveDate;
		this.remarks = remarks;
		this.added_at = added_at;
		this.updated_at = updated_at;
	}

	public Employee(String firstName, String lastName, Date dateOfBirth, String designation, String address,
			String phoneNumber, String email, String active, Date startDate, Date leaveDate, String remarks,
			Date added_at, Date updated_at) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.designation = designation;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.active = active;
		this.startDate = startDate;
		this.leaveDate = leaveDate;
		this.remarks = remarks;
		this.added_at = added_at;
		this.updated_at = updated_at;
	}

	public Employee() {
		super();
	}
	
	// CONSTRUCTOR END ===================================================================================================

	// GETTER AND SETTER =================================================================================================
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getAdded_at() {
		return added_at;
	}

	public void setAdded_at(Date added_at) {
		this.added_at = added_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// GETTER AND SETTER END =============================================================================================
	
}
