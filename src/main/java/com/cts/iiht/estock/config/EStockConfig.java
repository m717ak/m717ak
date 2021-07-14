package com.cts.iiht.estock.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.iiht.estock.stock.dto.Stock;
import com.cts.iiht.estock.stock.entity.StockEntity;

@Configuration
public class EStockConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.addMappings(stockMap);
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper;
	}
	
	private PropertyMap<StockEntity, Stock> stockMap=new PropertyMap<StockEntity, Stock>() {
		@Override
		protected void configure() {
			map().setCompanyCode(source.getCompany().getCode());
		}
	};

}
