package com.sgic.productservice.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.productservice.entities.Feature;


public interface FeaturesRepository extends JpaRepository<Feature, Long> {
//	@Query("SELECT feature_name FROM Feature ")
//	List<Feature> findAllFeatureName();
//	@Query(
//			  value = "SELECT feature_name FROM Feature", 
//			  nativeQuery = true)
//	List<Feature> findAllFeatureName();
}
