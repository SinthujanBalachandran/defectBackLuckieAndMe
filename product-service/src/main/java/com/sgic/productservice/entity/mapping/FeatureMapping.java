package com.sgic.productservice.entity.mapping;

import com.sgic.productservice.dto.FeatureDTO;
import com.sgic.productservice.entities.Feature;

public class FeatureMapping {

	public static FeatureDTO featureToFeatureDTO(Feature feature) {
		
		FeatureDTO featureDto = new FeatureDTO();
		featureDto.setId(feature.getId());
		featureDto.setFeatureName(feature.getFeatureName());
		featureDto.setFeatureDescription(feature.getFeatureDescription());
		
		
		
		return featureDto;
	}
}
	
	
