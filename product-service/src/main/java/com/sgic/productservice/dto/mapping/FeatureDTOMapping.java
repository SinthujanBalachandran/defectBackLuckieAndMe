package com.sgic.productservice.dto.mapping;

import com.sgic.productservice.dto.FeatureDTO;
import com.sgic.productservice.entities.Feature;

public class FeatureDTOMapping {
	public static Feature featureDTOtoFeature(FeatureDTO featureDto) {
		Feature feature = new Feature();
		feature.setId(featureDto.getId());
		feature.setFeatureName(featureDto.getFeatureName());
		feature.setFeatureDescription(feature.getFeatureDescription());
		return feature;
	}
}
