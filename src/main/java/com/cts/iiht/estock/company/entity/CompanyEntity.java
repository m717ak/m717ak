package com.cts.iiht.estock.company.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.cts.iiht.estock.stock.entity.StockEntity;

import lombok.Data;

@Entity
@Table(name = "COMPANY")
@Data
public class CompanyEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODE", unique = true, nullable = false)
	private String code;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "CEO", nullable = false)
	private String ceo;
	@Column(name = "TURNOVER", nullable = false)
	private BigDecimal turnOver;
	@Column(name = "WEBSITE", nullable = false)
	private String website;
	@Column(name = "STOCK_EXCHANGE", nullable = false)
	private String stockExchange;
	@CreationTimestamp
	@Column(name = "CREAT_DTM")
	private Date creatDtm;

	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StockEntity> stocks;

}
