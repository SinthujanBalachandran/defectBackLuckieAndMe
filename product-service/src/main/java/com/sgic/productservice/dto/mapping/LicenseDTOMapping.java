package com.sgic.productservice.dto.mapping;

import java.util.ArrayList;
import java.util.List;

import com.sgic.productservice.dto.LicenseDTO;
import com.sgic.productservice.entities.Feature;
import com.sgic.productservice.entities.License;


// to store data

public class LicenseDTOMapping {
	public static License licenseDTOToLicense(LicenseDTO licenseDto) {
		License license = new License();
		license.setId(licenseDto.getId());
		license.setLicenseName(licenseDto.getLicenseName());
		license.setLicenseValidity(licenseDto.getLicenseValidity());
		license.setLicenseCost(licenseDto.getLicenseCost());
		license.setCreated_date(licenseDto.getCreated_date());
		license.setUpdated_date(licenseDto.getUpdated_date());
		
		
		license.setFeatures(licenseDto.getFeatures());
		
		return license;
	}
}
