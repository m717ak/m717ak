package com.cts.iiht.estock.stock.service;

import java.text.ParseException;
import java.util.List;

import com.cts.iiht.estock.stock.dto.Stock;

public interface StockService {
	
	Stock save(String companyCode, Stock stock) throws Exception;

	List<Stock> findStocks(String companyCode, String startDate, String enddate) throws ParseException;

}
