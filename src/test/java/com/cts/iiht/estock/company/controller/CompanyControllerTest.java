package com.cts.iiht.estock.company.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.iiht.estock.company.dto.Company;
import com.cts.iiht.estock.company.service.CompanyService;

public class CompanyControllerTest {
	@Mock
	private CompanyService companyService;
	@InjectMocks
	private CompanyController controller = new CompanyController();

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveCompany() {
		Company company = new Company();
		when(companyService.save(company)).thenReturn(company);
		assertNotNull(controller.saveCompany(company));
	}

	@Test
	public void findCompany() {
		Company company = new Company();
		when(companyService.findById("123")).thenReturn(company);
		assertNotNull(controller.findCompany("123"));
	}
	
	@Test
	public void getAll() {
		when(companyService.findAll()).thenReturn(new ArrayList<>());
		assertNotNull(controller.getAll());
	}
	
	@Test
	public void deleteCompany() {
		doNothing().when(companyService).deleteByCompanyId("123");
		controller.deleteCompany("123");
		assertNotNull(controller);
	}
	
	@Test
	public void handleException() {
		assertNotNull(controller.handleException(new Exception("exception")));
	}

}
