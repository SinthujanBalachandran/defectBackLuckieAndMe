package com.sgic.productservice.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.productservice.dto.LicenseDTO;
import com.sgic.productservice.dto.LicenseNameDTO;
import com.sgic.productservice.dto.mapping.LicenseDTOMapping;
import com.sgic.productservice.entities.License;
import com.sgic.productservice.entities.Feature;
import com.sgic.productservice.entity.mapping.LicenseMapping;
import com.sgic.productservice.entity.mapping.LicenseNameMapping;
import com.sgic.productservice.repositories.FeaturesRepository;
import com.sgic.productservice.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	private FeaturesRepository featureRepository;
	
	public License saveLicense(LicenseDTO licenseDto) {
		//addFeature
//		//System.out.println(licenseDto);
//		Set<Feature> features = new HashSet<Feature>();
//		for (Feature feature : features) {
//			addFeature(licenseDto.getId(), feature.getId());
//			
//		}
		//addFeature(licenseDto.getId(), licenseDto.getFeatures().get)
		return licenseRepository.save(LicenseDTOMapping.licenseDTOToLicense(licenseDto));
		
	}
		
    public List<LicenseDTO> getAllLicense() {
        return LicenseMapping.licenseDTOListToLicenseList(licenseRepository.findAll());
    	//return LicenseDTOMapping.licenseDTOToLicense(licenseRepository.findAll())
    }
    public List<LicenseNameDTO> getAllLicenseName() {
		// TODO Auto-generated method stub
		return LicenseNameMapping.licenseNameDTOListToLicenseList(licenseRepository.findAll());
	}
		
	public LicenseDTO getLicenseById(Long licenseId) {
		return LicenseMapping.licenseTolicenseDTO(licenseRepository.findById(licenseId).orElse(null));
	}
	
	public License updateLicense(Long licenseId,LicenseDTO licenseDto) {
		return (licenseRepository.findById(licenseId).map(license->{
			license.setLicenseName(licenseDto.getLicenseName());
			license.setLicenseValidity(licenseDto.getLicenseValidity());
			license.setLicenseCost(licenseDto.getLicenseCost());
			license.setCreated_date(licenseDto.getCreated_date());
			license.setUpdated_date(licenseDto.getUpdated_date());
			return licenseRepository.save(license);
		}).orElse(null));
	}
	
	public void deleteLicense(Long licenseId) {
		 licenseRepository.findById(licenseId).map(license->{
			  licenseRepository.delete(license);
			  return null;
		 }).orElse(null);
	}

	public Set<Feature> getFeatures(Long licenseId){
		 return this.licenseRepository.findById(licenseId).map((license) -> {
	            return license.getFeatures();
	        }).orElseThrow();
	}
	
	public Set<Feature> addFeature(Long id, Long featureId){
		Feature feature = this.featureRepository.findById(featureId).orElseThrow();
        
        // Finds a license and adds the given feature to the license's set.
        return this.licenseRepository.findById(id).map((license) -> {
            license.getFeatures().add(feature);
            return this.licenseRepository.save(license).getFeatures(); 
        }).orElseThrow();
	}
	
}
