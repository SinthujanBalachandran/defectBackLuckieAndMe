package com.sgic.productservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.productservice.dto.CompanyRequestDTO;
import com.sgic.productservice.dto.CompanyResponseDTO;
import com.sgic.productservice.entities.Company;
import com.sgic.productservice.services.CompanyService;

@CrossOrigin
@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@PostMapping("/company")
	public ResponseEntity<Company> saveCompany(@RequestBody CompanyRequestDTO companyRequestDTO) {
		return new ResponseEntity<>(companyService.saveCompany(companyRequestDTO),HttpStatus.CREATED);
	}

	@GetMapping("/company")
	public ResponseEntity<List<CompanyResponseDTO>> findCompany() {
		return new ResponseEntity<>(companyService.findAllCompany(), HttpStatus.FOUND);
	}
	
//	@GetMapping("/company/{companyId}")
//	public ResponseEntity<CompanyResponseDTO> findAllCompany(@PathVariable Long companyId) {
//		return new ResponseEntity<>(companyService.findCompany(companyId),HttpStatus.FOUND);		
//	}

	@PutMapping("/company/{id}")
	public ResponseEntity<?> editCompany(@PathVariable Long id, @RequestBody CompanyRequestDTO companyDto) {
		return new ResponseEntity<>(companyService.editCompany(companyDto, id), HttpStatus.CREATED);
	}

	@DeleteMapping("/company/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return ResponseEntity.ok().build();
	}
}
