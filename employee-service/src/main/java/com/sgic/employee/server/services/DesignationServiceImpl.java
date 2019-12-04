package com.sgic.employee.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.employee.server.entities.Designation;
import com.sgic.employee.server.repositories.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService {
	
	@Autowired
	private DesignationRepository designationRepository;
	
	@Transactional(readOnly = false)
	public Designation createDesignation(Designation designation) {
		
		Designation responseDesignation = designationRepository.save(designation);
		return responseDesignation;
	}

}
