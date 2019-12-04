package com.sgic.employee.server.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.BasicResponse;
import com.sgic.common.api.response.ValidationFailure;
import com.sgic.employee.dto.mapper.Mapper;
import com.sgic.employee.server.dto.EmployeeDto;
import com.sgic.employee.server.entities.Employee;
import com.sgic.employee.server.services.EmployeeService;
import com.sgic.employee.server.util.Constants;
import com.sgic.employee.server.util.ErrorCodes;
import com.sgic.employee.server.util.ValidationMessages;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	ErrorCodes errorMessages;

	@Autowired
	private Mapper mapper;

	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	// ADD EMPLOYEE =========================================================================================================

	@PostMapping(value = "/employee")
	public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDto employeeData) {
		if (employeeService.isEmailAlreadyExist(employeeData.getEmail())) {
			logger.debug("Email already exists: createEmployee(), email: {}");
			return new ResponseEntity<>(
					new BasicResponse<>(new ValidationFailure(Constants.EMAIL, errorMessages.getEmailAlreadyExist()),
							RestApiResponseStatus.VALIDATION_FAILURE, ValidationMessages.EMAIL_EXIST),
					HttpStatus.BAD_REQUEST);
		}

		Employee employee = mapper.map(employeeData, Employee.class);
		employeeService.createEmployee(employee);
		return new ResponseEntity<>(new BasicResponse<>(RestApiResponseStatus.OK, ValidationMessages.ADD_EMP),
				HttpStatus.OK);
		// return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK),
		// HttpStatus.OK);
	}
	
	// ADD EMPLOYEE END =====================================================================================================
	
	// LIST ALL EMPLOYEE ====================================================================================================

	@GetMapping(value = "/employee")
	public List<EmployeeDto> getEmployee() {
		List<Employee> employeeData = employeeService.getAllEmployee();
		List<EmployeeDto> employeeDtoData = mapper.map(employeeData, EmployeeDto.class);
		System.out.println(employeeDtoData);
		return employeeDtoData;
	}
	
	// LIST ALL EMPLOYEE END ================================================================================================
	
	// GET EMPLOYEE BY ID ===================================================================================================

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		EmployeeDto employeeDtoData = mapper.map(employeeService.findEmployeeById(id), EmployeeDto.class);
		return new ResponseEntity<EmployeeDto>(employeeDtoData, HttpStatus.OK);
	}
	
	// GET EMPLOYEE BY ID END ===============================================================================================
	
	// UPDATE EMPLOYEE ======================================================================================================

	@PutMapping(value = "/employee")
	public ResponseEntity<Object> updateBook(@Valid @RequestBody EmployeeDto employeeData) {
		Employee employee = mapper.map(employeeData, Employee.class);
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>(
				new BasicResponse<>(RestApiResponseStatus.OK, ValidationMessages.UPDATE_EMP),
				HttpStatus.OK);
		// return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK),
		// HttpStatus.OK);
	}
	
	// UPDATE EMPLOYEE END ==================================================================================================
	
	// DELETE EMPLOYEE ======================================================================================================

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<Long> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	// DELETE EMPLOYEE END ==================================================================================================
	
	// LIST EMPLOYEE BY DESIGNATION =========================================================================================

	@GetMapping(value = "/employee/job/{designation}")
	public List<EmployeeDto> getEmployeeByDesignation(@PathVariable String designation) {
		List<EmployeeDto> employeeDtoData = mapper.map(employeeService.findEmployeeByDesignation(designation),
				EmployeeDto.class);
		return employeeDtoData;
	}
	
	// LIST EMPLOYEE BY DESIGNATION END =====================================================================================

}
