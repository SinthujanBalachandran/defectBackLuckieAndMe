package com.sgic.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.productservice.entities.License;

public interface LicenseRepository extends JpaRepository<License, Long> {

}
