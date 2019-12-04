package com.sgic.productservice.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.sgic.productservice.entities.Feature;

public class LicenseDTO {

	private Long id;	
	private LocalDateTime created_date;
	private LocalDateTime updated_date;
	private String licenseName;
	private String licenseValidity;
	private String licenseCost;
	private Set<Feature> features;

	
	
	public Set<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}
	
	public Long getId() {
		return id;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public LocalDateTime getUpdated_date() {
		return updated_date;
	}
	public String getLicenseName() {
		return licenseName;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	public String getLicenseValidity() {
		return licenseValidity;
	}
	public void setLicenseValidity(String licenseValidity) {
		this.licenseValidity = licenseValidity;
	}
	public String getLicenseCost() {
		return licenseCost;
	}
	public void setLicenseCost(String licenseCost) {
		this.licenseCost = licenseCost;
	}
	
	
}
