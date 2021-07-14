package com.cts.iiht.estock.stock.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iiht.estock.stock.dto.Stock;
import com.cts.iiht.estock.stock.service.StockService;

import lombok.extern.slf4j.Slf4j;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1.0/market/stock")
@Slf4j
public class StockController {
	@Autowired
	private StockService stockService;

	@PostMapping("/add/{companycode}")
	@ResponseStatus(HttpStatus.OK)
	public Stock saveCompany(@PathVariable("companycode") String companyCode, @RequestBody @Validated Stock stock) throws Exception {
		log.info("Received Request to save Stock: {}",stock.toString());
		return stockService.save(companyCode,stock);
	}
	
	@GetMapping("/get/{companycode}/{startdate}/{enddate}")
	@ResponseStatus(HttpStatus.OK)
	public List<Stock> findStocks(@PathVariable("companycode") String companyCode,@PathVariable("startdate")String startDate,@PathVariable("enddate") String enddate) throws ParseException{
		System.out.println("hello app");
		return stockService.findStocks(companyCode,startDate,enddate);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
