package com.sgic.productservice.dto.mapping;

import com.sgic.productservice.dto.CompanyRequestDTO;
import com.sgic.productservice.entities.Company;

public class CompanyDTOMapping {
	public static Company companyDTOToCompany(CompanyRequestDTO companyDto) {
		Company company = new Company();
		company.setId(companyDto.getId());
		company.setCompanyName(companyDto.getCompanyName());
		company.setEmail(companyDto.getEmail());
		company.setLicenseCreatedDate(companyDto.getLicenseCreatedDate());
		company.setLicenseExpiryDate(companyDto.getLicenseExpiryDate());
		
		//company.setLicenseExpiryDate(companyDto.getLicense().getLicenceDuration()); //calculate the expiry date
		return company;
	}
}