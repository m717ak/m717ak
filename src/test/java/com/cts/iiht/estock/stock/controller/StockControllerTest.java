package com.cts.iiht.estock.stock.controller;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.iiht.estock.stock.dto.Stock;
import com.cts.iiht.estock.stock.service.StockService;

public class StockControllerTest {
	@Mock
	private StockService stockService;
	@InjectMocks
	private StockController controller=new StockController();
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveCompany() throws Exception {
		controller.saveCompany("123", new Stock());
		assertNotNull(controller);
	}
	
	@Test
	public void findStocks() throws ParseException {
		controller.findStocks("123", "123", "123");
		assertNotNull(controller);
	}
	
	@Test
	public void handleException() {
		assertNotNull(controller.handleException(new Exception("exception")));
	}


}
