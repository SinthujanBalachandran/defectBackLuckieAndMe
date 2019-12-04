package com.sgic.productservice.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.productservice.dto.LicenseDTO;
import com.sgic.productservice.dto.LicenseNameDTO;
import com.sgic.productservice.entities.Feature;
import com.sgic.productservice.entities.License;
import com.sgic.productservice.services.LicenseService;



@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class LicenseController {
	@Autowired
	private LicenseService licenseService;
	//@Autowired
	//private LicenseDTO licenseDto;
	
	@PostMapping("/license")
	public ResponseEntity<License> saveProject(@RequestBody LicenseDTO licenseDto) {
		//licenseService.addFeature(licenseDto.getId(),);
		//System.out.println(licenseDto.getFeatures());
		return new ResponseEntity<>(licenseService.saveLicense(licenseDto),HttpStatus.CREATED);
		//licenseService.saveProject(licenseDto) which returns the <License>
	}
	
	@GetMapping("/license")
	public ResponseEntity<List<LicenseDTO>> getAllLicense() {
		return new ResponseEntity<>(licenseService.getAllLicense(),HttpStatus.OK);	
	}
	
	@GetMapping("/license/{licenseId}")
	public ResponseEntity<LicenseDTO> findProject(@PathVariable Long licenseId) {
		return new ResponseEntity<>(licenseService.getLicenseById(licenseId),HttpStatus.FOUND);
	}
	@GetMapping("/license/{licenseName}")
	public ResponseEntity<List<LicenseNameDTO>> getAllLicenseName() {
		return new ResponseEntity<>(licenseService.getAllLicenseName(),HttpStatus.OK);	
	}
	
	@PutMapping("/license/{licenseId}")
	public License updateProject(@PathVariable Long licenseId, @RequestBody LicenseDTO licenseDto) {
		return licenseService.updateLicense(licenseId, licenseDto);
	}
	
	@DeleteMapping("/license/{licenseId}")
	public ResponseEntity<?> deleteLicense(@PathVariable Long licenseId) {
		licenseService.deleteLicense(licenseId);
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/{licenseId}/features")
    public Set<Feature> getFeatures(@PathVariable Long licenseId){
        // Finds license by id and returns it's recorded features, otherwise throws exception 
        return this.licenseService.getFeatures(licenseId);
    }
	
    
//    @PostMapping("/{id}/features/{featureId}") // Path variable need to be changed with 
//    public Set<Feature> addFeature(@PathVariable Long id, @PathVariable Long featureId){
//        // Finds a persisted feature
//        //Feature feature = this.featureRepository.findById(featureId).orElseThrow();
//        
//        // Finds a license and adds the given feature to the license's set.
//        return this.licenseService.addFeature(id, featureId);
//    }
	@PostMapping("licensefeature") // Path variable need to be changed with 
    public Set<Feature> addFeature(Long id, Long featureId){
        // Finds a persisted feature
        //Feature feature = this.featureRepository.findById(featureId).orElseThrow();
        
        // Finds a license and adds the given feature to the license's set.
        return this.licenseService.addFeature(id, featureId);
    }
}
