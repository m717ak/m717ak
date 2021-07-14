package com.cts.iiht.estock.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.cts.iiht.estock.company.entity.CompanyEntity;

import lombok.Data;

@Entity
@Table(name = "STOCK")
@Data
public class StockEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	@Column(name = "STOCK_PRICE", nullable = false)
	@NotNull(message = "Stock price cannot be null")
	private BigDecimal stockPrice;
	@Column(name = "COMPANY_CODE", nullable = false)
	@NotNull(message = "Company code cannot be null")
	private String companyCode;
	@CreationTimestamp
	@Column(name = "CREAT_DTM")
	private Date creatDtm;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "company_code", referencedColumnName = "CODE", nullable = true, insertable = false, updatable = false)
	private CompanyEntity company;

}
