package com.sgic.productservice.entity.mapping;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.sgic.productservice.dto.LicenseNameDTO;
import com.sgic.productservice.entities.License;

public class LicenseNameMapping {
	public static LicenseNameDTO licenseNameTolicenseNameDTO(License licenseName) {
		LicenseNameDTO licenseNameDto = new LicenseNameDTO();

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(licenseName, licenseNameDto);
		return licenseNameDto;
	}
	
	public static List<LicenseNameDTO> licenseNameDTOListToLicenseList(List<License> licenseList){
		List<LicenseNameDTO> licenseNameDtoList = new ArrayList<LicenseNameDTO>();
		if(licenseList!=null) {
			for(License licenseName: licenseList) {
				licenseNameDtoList.add(licenseNameTolicenseNameDTO(licenseName));
			}
		}
		return licenseNameDtoList;
	}
}
