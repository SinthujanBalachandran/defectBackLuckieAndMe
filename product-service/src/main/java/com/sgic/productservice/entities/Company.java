package com.sgic.productservice.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;



@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String companyName;
	private String email;
	
	
	private Date licenseExpiryDate;
	
	@CreationTimestamp
	private LocalDateTime licenseCreatedDate;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private License license;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	

	public Date getLicenseExpiryDate() {
		return licenseExpiryDate;
	}


	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}


	public LocalDateTime getLicenseCreatedDate() {
		return licenseCreatedDate;
	}


	public void setLicenseCreatedDate(LocalDateTime licenseCreatedDate) {
		this.licenseCreatedDate = licenseCreatedDate;
	}


	public License getLicense() {
		return license;
	}


	public void setLicense(License license) {
		this.license = license;
	}

	

}