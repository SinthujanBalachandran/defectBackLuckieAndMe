package com.sgic.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.productservice.entities.Company;


public interface CompanyRepository extends JpaRepository<Company, Long>{

}
