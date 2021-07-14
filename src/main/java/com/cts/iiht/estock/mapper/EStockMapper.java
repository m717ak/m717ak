package com.cts.iiht.estock.mapper;

import java.lang.reflect.Type;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.iiht.estock.company.dto.Company;
import com.cts.iiht.estock.company.entity.CompanyEntity;
import com.cts.iiht.estock.stock.dto.Stock;
import com.cts.iiht.estock.stock.entity.StockEntity;

@Component
public class EStockMapper {
	@Autowired
	private ModelMapper modelMapper;

	public CompanyEntity mapCompanyToEntity(Company company) {
		if (Objects.isNull(company)) {
			return null;
		}
		Type type = new TypeToken<CompanyEntity>() {
		}.getType();
		return modelMapper.map(company, type);
	}

	public Company mapCompanyEntityToDto(CompanyEntity companyEntity) {
		if (Objects.isNull(companyEntity)) {
			return null;
		}
		Type type = new TypeToken<Company>() {
		}.getType();
		return modelMapper.map(companyEntity, type);
	}

	public StockEntity mapStockToEntity(Stock stock) {
		if (Objects.isNull(stock)) {
			return null;
		}
		Type type = new TypeToken<StockEntity>() {
		}.getType();
		return modelMapper.map(stock, type);
	}

	public Stock mapStockEntityToDto(StockEntity stockEntity) {
		if (Objects.isNull(stockEntity)) {
			return null;
		}
		Type type = new TypeToken<Stock>() {
		}.getType();
		return modelMapper.map(stockEntity, type);
	}

}
