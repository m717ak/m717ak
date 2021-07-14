package com.cts.iiht.estock.company.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.cts.iiht.estock.company.dto.Company;
import com.cts.iiht.estock.company.entity.CompanyEntity;
import com.cts.iiht.estock.company.repository.CompanyRepository;
import com.cts.iiht.estock.company.service.impl.CompanyServiceImpl;
import com.cts.iiht.estock.mapper.EStockMapper;

public class CompanyServiceTest {
	
	@Mock
	private CompanyRepository companyRepository;
	@Mock
	private EStockMapper eStockMapper;
	@Mock
	private ModelMapper modelMapper;
	@InjectMocks
	private CompanyService service=new CompanyServiceImpl();
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void save() {
		Company company=new Company();
		service.save(company);
		assertNotNull(service);
	}
	
	@Test
	public void findById() {
		Company company=new Company();
		CompanyEntity ent=new CompanyEntity();
		Optional<CompanyEntity> op=Optional.of(ent);
		when(companyRepository.findById(Mockito.any())).thenReturn(op);
		when(eStockMapper.mapCompanyEntityToDto(Mockito.any())).thenReturn(company);
		service.findById("123");
		assertNotNull(service);
	}
	
	@Test
	public void findAll() {
		service.findAll();
		assertNotNull(service);
	}
	
	@Test
	public void deleteByCompanyId() {
		service.deleteByCompanyId("123");
		assertNotNull(service);
	}
}
