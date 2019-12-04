package com.sgic.productservice.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

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

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ListContentResponse;
import com.sgic.productservice.entities.Feature;
import com.sgic.productservice.entities.License;
import com.sgic.productservice.services.FeatureService;
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class FeatureController {

	
	@Autowired
    private FeatureService featureService;
    
    @PostMapping("/feature") // Validates the request body as a Feature type
    public Feature createFeature(@Valid @RequestBody Feature feature){
        // Saves and return the new feature
        return this.featureService.createFeature(feature);
    }
    
    @GetMapping("/feature/{id}") // Finds a feature by id 
    public ResponseEntity<Feature> findFeature(@PathVariable Long id) {
		return new ResponseEntity<>(featureService.getFeatureById(id),HttpStatus.FOUND);
		//return new ResponseEntity<>(new ListContentResponse<Feature> (RestApiResponseStatus.RECEIVED), HttpStatus.OK);
	}
    
    @GetMapping("/feature") // Finds all stored features
    public ResponseEntity<List<Feature>> getAllFeature() {
		return new ResponseEntity<>(featureService.getAllFeature(),HttpStatus.OK);	
	}
    
//    @GetMapping("/feature/name") // Finds all stored features
//    public ResponseEntity<List<Feature>> getAllFeatureName() {
//		return new ResponseEntity<>(featureService.getAllFeatureName(),HttpStatus.OK);	
//	}
    
    @PutMapping("/feature/{featureId}")
    public Feature updateFeature(@PathVariable Long featureId, @RequestBody Feature featureDto) {
		return featureService.updateFeature(featureId, featureDto);
	}
    
    
    @DeleteMapping("/feature/{id}") // Find feature by id
    public ResponseEntity<?> deleteFeature(@PathVariable Long id){
        // If id exists, delete the record and return a response message, otherwise throws exception
      featureService.deleteFeature(id);
      return ResponseEntity.ok().build();
           
    }
    
    @GetMapping("/feature/{id}/license")
    public Set<License> getLicense(@PathVariable Long id){
        // Finds feature by id and returns it's recorded licenses, otherwise throws exception
        return this.featureService.getLicense(id);
    }
    
}
