package com.sgic.productservice.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.sgic.productservice.dto.LicenseDTO;

public class CompanyResponseDTO {
	private Long id;
	private String companyName;
	private String email;
	private Date licenseExpiryDate;
	private LocalDateTime licenseCreatedDate;
	private LicenseDTO license;
	
	
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
	public LicenseDTO getLicense() {
		return license;
	}
	public void setLicense(LicenseDTO license) {
		this.license = license;
	}


	

}
