package com.cts.iiht.estock.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.iiht.estock.company.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {

}
