package com.cts.iiht.estock.stock.service.impl;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.estock.mapper.EStockMapper;
import com.cts.iiht.estock.stock.dto.Stock;
import com.cts.iiht.estock.stock.entity.StockEntity;
import com.cts.iiht.estock.stock.repository.StockRepository;
import com.cts.iiht.estock.stock.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private EStockMapper estockMapper;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Stock save(String companyCode,Stock stock) throws Exception {
		if(!stock.getCompanyCode().equals(companyCode)) {
			throw new Exception("Invalid COmpany Code");
		}
		StockEntity savedEntity = stockRepository.save(estockMapper.mapStockToEntity(stock));
		Stock savedStock = estockMapper.mapStockEntityToDto(savedEntity);
		return savedStock;
	}

	@Override
	public List<Stock> findStocks(String companyCode, String startDate, String enddate) throws ParseException {
		List<StockEntity> stocks=stockRepository.findByCompanyCodeAndCreatDtmBetween(companyCode,new SimpleDateFormat("yyyy-MM-dd").parse(startDate),new SimpleDateFormat("yyyy-MM-dd").parse(enddate));
		Type type = new TypeToken<List<Stock>>() {}.getType();
		return modelMapper.map(stocks,type);
	}

}
