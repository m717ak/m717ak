package com.cts.iiht.estock.company.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cts.iiht.estock.stock.dto.Stock;

import lombok.Data;

@Data
public class Company {

	@NotNull(message = "Company code cannot be null")
	@Size(min = 1)
	private String code;
	@NotNull(message = "Company name cannot be null")
	@Size(min = 1)
	private String name;
	@NotNull(message = "CEO cannot be null")
	@Size(min = 1)
	private String ceo;
	@NotNull(message = "Turn over cannot be null")
	@Min(100000001)
	private BigDecimal turnOver;
	@NotNull(message = "Website cannot be null")
	@Size(min = 1)
	private String website;
	@NotNull(message = "Stock exchange cannot be null")
	@Size(min = 1)
	private String stockExchange;
	private LocalDateTime creatDtm;

	private List<Stock> stocks;

}
