package com.cts.iiht.estock.company.service;

import java.util.List;

import com.cts.iiht.estock.company.dto.Company;

public interface CompanyService {

	Company save(Company company);

	Company findById(String companyCode);

	List<Company> findAll();

	void deleteByCompanyId(String companyCode);
}
