package com.sgic.productservice.entity.mapping;

import java.util.ArrayList;
import java.util.List;

import com.sgic.productservice.dto.CompanyRequestDTO;
import com.sgic.productservice.dto.CompanyResponseDTO;
import com.sgic.productservice.dto.LicenseDTO;
import com.sgic.productservice.entities.Company;

public class CompanyMapping {

	public static CompanyResponseDTO companyToCompanyResponseDTO(Company company) {
		CompanyResponseDTO companyResponseDto = new CompanyResponseDTO();
		companyResponseDto.setId(company.getId());
		companyResponseDto.setCompanyName(company.getCompanyName());
		companyResponseDto.setEmail(company.getEmail());
		companyResponseDto.setLicenseCreatedDate(company.getLicenseCreatedDate());
		companyResponseDto.setLicenseExpiryDate(company.getLicenseExpiryDate());
		
		LicenseDTO licenseDto = new LicenseDTO();
		licenseDto.setId(company.getLicense().getId());
		licenseDto.setLicenseName(company.getLicense().getLicenseName());
		licenseDto.setLicenseValidity(company.getLicense().getLicenseValidity());
		licenseDto.setLicenseCost(company.getLicense().getLicenseCost());
		licenseDto.setCreated_date(company.getLicense().getCreated_date());
		licenseDto.setUpdated_date(company.getLicense().getUpdated_date());
		
		companyResponseDto.setLicense(licenseDto);
		
		return companyResponseDto;
	}
	
	public static List<CompanyResponseDTO> companyListToCompanyDTOList(List<Company> companyList) {
		List<CompanyResponseDTO> companyResponseDtoList = new ArrayList<>();
		if(companyResponseDtoList!=null) {
			for(Company company: companyList) {
				companyResponseDtoList.add(companyToCompanyResponseDTO(company));
			}
		}
		return companyResponseDtoList;
	}
	public static CompanyRequestDTO companyToCompanyRequestDTO(Company company) {
		CompanyRequestDTO companyRequestDto = new CompanyRequestDTO();
		companyRequestDto.setId(company.getId());
		companyRequestDto.setCompanyName(company.getCompanyName());
		companyRequestDto.setEmail(company.getEmail());
		companyRequestDto.setLicenseCreatedDate(company.getLicenseCreatedDate());
		companyRequestDto.setLicenseExpiryDate(company.getLicenseExpiryDate());
		
		return companyRequestDto;
	}
	
	public static List<CompanyRequestDTO> companyListToCompanyRequestListDTO(List<Company> companyList) {
		List<CompanyRequestDTO> companyRequestDtoList = new ArrayList<>();
		if(companyRequestDtoList!=null) {
			for(Company company: companyList) {
				companyRequestDtoList.add(companyToCompanyRequestDTO(company));
			}
		}
		return companyRequestDtoList;
	}
}
