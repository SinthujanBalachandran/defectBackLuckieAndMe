package com.sgic.productservice.dto;

import java.util.Date;

public class CompanyDTO {
	private Long id;

	private String companyName;

	private String email;

	private Date licenseType;

	private Date licenseStartDate;

	private String licenseExpiryDate;

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

	public Date getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(Date licenseType) {
		this.licenseType = licenseType;
	}

	public Date getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public String getLicenseExpiryDate() {
		return licenseExpiryDate;
	}

	public void setLicenseExpiryDate(String licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	
}
