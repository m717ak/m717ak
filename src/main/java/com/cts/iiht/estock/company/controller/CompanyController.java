package com.cts.iiht.estock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iiht.estock.company.dto.Company;
import com.cts.iiht.estock.company.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1.0/market/company")
@Slf4j
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.OK)
	public Company saveCompany(@RequestBody @Validated Company company) {
		log.info("Received Request to save company: {}", company.toString());
		return companyService.save(company);
	}

	@GetMapping("/info/{companycode}")
	@ResponseStatus(HttpStatus.OK)
	public Company findCompany(@PathVariable("companycode") String companyCode) {
		log.info("received Request to find Company: {}", companyCode);
		return companyService.findById(companyCode);
	}

	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> getAll() {
		log.info("received Request to get ALL company details");
		return companyService.findAll();
	}

	@DeleteMapping("/delete/{companycode}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCompany(@PathVariable("companycode") String companyCode) {
		log.info("received Request to delete Company: {}", companyCode);
		companyService.deleteByCompanyId(companyCode);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
