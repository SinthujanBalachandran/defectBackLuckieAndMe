package com.sgic.productservice.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sgic.productservice.entities.Feature;
import com.sgic.productservice.entities.License;
import com.sgic.productservice.repositories.FeaturesRepository;

@Service
public class FeatureService {

	@Autowired
	private FeaturesRepository featureRepository;
	
	public Feature createFeature(Feature feature) {
		return featureRepository.save(feature);
	}
	
	public Feature getFeatureById(Long id){
		return this.featureRepository.findById(id).orElseThrow();
	}
	
	public List<Feature> getAllFeature() {
        return featureRepository.findAll();
    }
	
	
	public Feature updateFeature(Long featureId, Feature featureDto) {
		return this.featureRepository.findById(featureId).map((toUpdate) -> {
            toUpdate.setFeatureName(featureDto.getFeatureName());
            toUpdate.setFeatureDescription(featureDto.getFeatureDescription());
            return this.featureRepository.save(toUpdate);
        }).orElseThrow();
	}
	
	public void deleteFeature(Long featureId) {
		featureRepository.findById(featureId).map(feature->{
			featureRepository.delete(feature);
			  return null;
		 }).orElse(null);
	}
	
	//find the licenses for a feature
	public Set<License> getLicense(long id){
		return this.featureRepository.findById(id).map((feature) -> {
	        return feature.getLicense();
	    }).orElseThrow();
	}

//	public List<Feature> getAllFeatureName() {
//		// TODO Auto-generated method stub
//		return (List<Feature>) featureRepository.findAllFeatureName();
//	}
}
