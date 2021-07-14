package com.cts.iiht.estock.stock.service;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.cts.iiht.estock.mapper.EStockMapper;
import com.cts.iiht.estock.stock.dto.Stock;
import com.cts.iiht.estock.stock.repository.StockRepository;
import com.cts.iiht.estock.stock.service.impl.StockServiceImpl;

public class StockServiceTest {
	@Mock
	private StockRepository stockRepository;
	@Mock
	private EStockMapper estockMapper;
	@Mock
	private ModelMapper modelMapper;
	@InjectMocks
	private StockService service = new StockServiceImpl();

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = Exception.class)
	public void save() throws Exception {
		Stock stock=new Stock();
		stock.setCompanyCode("176");
		service.save("123",stock );
		assertNotNull(service);
	}

	@Test
	public void saveIf() throws Exception {
		Stock stock=new Stock();
		stock.setCompanyCode("123");
		service.save("123",stock );
		assertNotNull(service);
	}
	
	@Test
	public void findStocks() throws ParseException {
		service.findStocks("123", "2021-06-20", "2021-06-20");
		assertNotNull(service);
	}

}
