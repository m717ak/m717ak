package com.cts.iiht.estock.stock.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.iiht.estock.stock.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

	List<StockEntity> findByCompanyCodeAndCreatDtmBetween(String companyCode, Date date, Date date2);

}
