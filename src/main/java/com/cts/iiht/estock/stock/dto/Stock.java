package com.cts.iiht.estock.stock.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Stock {

	private Long id;
	@NotNull(message = "Stock price cannot be null")
	private BigDecimal stockPrice;
	@NotNull(message = "Company code cannot be null")
	@Size(min = 1)
	private String companyCode;
	private LocalDateTime creatDtm;

}
