package com.sgic.productservice.entity.mapping;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.sgic.productservice.dto.LicenseDTO;
import com.sgic.productservice.entities.License;


// for getting data

public class LicenseMapping {
	public static LicenseDTO licenseTolicenseDTO(License license) {
		LicenseDTO licenseDto = new LicenseDTO();
//		licenseDto.setId(license.getId());
//		licenseDto.setName(license.getName());
//		licenseDto.setDescription(license.getDescription());
//		licenseDto.setCreated_date(license.getCreated_date());
//		licenseDto.setUpdated_date(license.getUpdated_date());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(license, licenseDto);
		return licenseDto;
	}
	
	public static List<LicenseDTO> licenseDTOListToLicenseList(List<License> licenseList){
		List<LicenseDTO> licenseDtoList = new ArrayList<LicenseDTO>();
		if(licenseList!=null) {
			for(License license: licenseList) {
				licenseDtoList.add(licenseTolicenseDTO(license));
			}
		}
		return licenseDtoList;
	}
}
