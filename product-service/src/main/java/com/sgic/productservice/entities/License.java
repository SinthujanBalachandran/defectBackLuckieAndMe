package com.sgic.productservice.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "license")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	//@Column(updatable=false)
	private LocalDateTime created_date;

	@UpdateTimestamp
	private LocalDateTime updated_date;

	private String licenseName;
	private String licenseValidity;
	private String licenseCost;
	// private String description;
	
	@ManyToMany(
            fetch = FetchType.LAZY,
            //cascade = {CascadeType.MERGE, CascadeType.PERSIST}
            cascade = {CascadeType.MERGE}
    )
    @JoinTable(
            name = "license_features",
            joinColumns = {@JoinColumn(name = "license_id")},
            inverseJoinColumns = {@JoinColumn(name = "feature_id")}
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Feature> features = new HashSet<>();
	
	public License() {
		
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

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	
}
