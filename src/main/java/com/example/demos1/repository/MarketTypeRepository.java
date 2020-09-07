package com.example.demos1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demos1.model.MarketType;

@Repository
public interface MarketTypeRepository extends JpaRepository<MarketType, Integer>{
	
	public List<MarketType> findAll();
}
