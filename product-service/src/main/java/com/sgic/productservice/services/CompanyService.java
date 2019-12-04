package com.sgic.productservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.productservice.dto.CompanyRequestDTO;
import com.sgic.productservice.dto.CompanyResponseDTO;
import com.sgic.productservice.dto.mapping.CompanyDTOMapping;
import com.sgic.productservice.entities.Company;
import com.sgic.productservice.entity.mapping.CompanyMapping;
import com.sgic.productservice.repositories.CompanyRepository;
import com.sgic.productservice.repositories.LicenseRepository;


@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private LicenseRepository licenseRepository;
	/*
	public Company saveCompany(Long licenseId, CompanyRequestDTO companyRequestDto) {
		return licenseRepository.findById(licenseId).map(license->{
			Company company = CompanyDTOMapping.companyDTOToCompany(companyRequestDto);
			company.setLicense(license);
			return companyRepository.save(company);
		}).orElse(null);
	}
	*/
	public Company saveCompany(CompanyRequestDTO companyRequestDto) {
		return licenseRepository.findById(companyRequestDto.getLicense().getId()).map(license->{
			Company company = CompanyDTOMapping.companyDTOToCompany(companyRequestDto);
			company.setLicense(license);
			return companyRepository.save(company);
		}).orElse(null);
	}
	
	
	public CompanyResponseDTO findCompany(Long id) {
		return CompanyMapping.companyToCompanyResponseDTO(companyRepository.findById(id).orElse(null));
	}
	/*
	public List<CompanyRequestDTO> licenseHasCompanies(Long licenseId) {
		return CompanyMapping.companyListToCompanyRequestListDTO(licenseRepository.findById(licenseId).map(license->{
			return license.getCompanies();
		}).orElse(null));
	}
	*/
	
	public List<CompanyResponseDTO> findAllCompany(){
		return CompanyMapping.companyListToCompanyDTOList(companyRepository.findAll());
	}
	
	public CompanyResponseDTO editCompany(CompanyRequestDTO companyDto,Long id){
		return CompanyMapping.companyToCompanyResponseDTO(companyRepository.findById(id).map(company->{
			company.setCompanyName(companyDto.getCompanyName());
			company.setEmail(companyDto.getEmail());
			company.setLicenseCreatedDate(companyDto.getLicenseCreatedDate());
			company.setLicenseExpiryDate(companyDto.getLicenseExpiryDate());
			company.setLicense(companyDto.getLicense());
			return companyRepository.save(company);
		}).orElse(null));
	}
	
	public void deleteCompany(Long id) {
		companyRepository.findById(id).map(company->{
			companyRepository.delete(company);
			return null;
		}).orElse(null);
	}
}