package com.cts.iiht.estock.company.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.estock.company.dto.Company;
import com.cts.iiht.estock.company.entity.CompanyEntity;
import com.cts.iiht.estock.company.repository.CompanyRepository;
import com.cts.iiht.estock.company.service.CompanyService;
import com.cts.iiht.estock.mapper.EStockMapper;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private EStockMapper eStockMapper;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Company save(Company company) {
		CompanyEntity savedEntity = companyRepository.save(eStockMapper.mapCompanyToEntity(company));
		Company savedCompany = eStockMapper.mapCompanyEntityToDto(savedEntity);
		return savedCompany;
	}

	@Override
	public Company findById(String companyCode) {
		Optional<CompanyEntity> companyEntity = companyRepository.findById(companyCode);
		return eStockMapper.mapCompanyEntityToDto(companyEntity.get());
	}

	@Override
	public List<Company> findAll() {
		List<CompanyEntity> companyList = companyRepository.findAll();
		Type type = new TypeToken<List<Company>>() {}.getType();
		return modelMapper.map(companyList, type);
	}

	@Override
	public void deleteByCompanyId(String companyCode) {
		companyRepository.deleteById(companyCode);
	}

}
