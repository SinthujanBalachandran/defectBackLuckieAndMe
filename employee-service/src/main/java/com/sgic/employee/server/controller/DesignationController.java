package com.sgic.employee.server.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.BasicResponse;
import com.sgic.employee.dto.mapper.Mapper;
import com.sgic.employee.server.dto.DesignationDto;
import com.sgic.employee.server.entities.Designation;
import com.sgic.employee.server.services.DesignationService;
import com.sgic.employee.server.util.ErrorCodes;
import com.sgic.employee.server.util.ValidationMessages;

@RestController
public class DesignationController {
	
	@Autowired
	private DesignationService designationservice;
	
	@Autowired
	ErrorCodes errorMessages;

	@Autowired
	private Mapper mapper;
	
	private static final Logger logger = Logger.getLogger(DesignationController.class);
	
	@PostMapping(value = "/designation")
	public ResponseEntity<Object> createDesignation(@RequestBody DesignationDto designationData){
		
		Designation designation = mapper.map(designationData, Designation.class);
		designationservice.createDesignation(designation);
		return new ResponseEntity<>(new BasicResponse<>(RestApiResponseStatus.OK, ValidationMessages.ADD_EMP),
				HttpStatus.OK);
		
	}

}
