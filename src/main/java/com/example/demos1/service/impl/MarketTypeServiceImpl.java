package com.example.demos1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demos1.model.MarketType;
import com.example.demos1.repository.MarketTypeRepository;
import com.example.demos1.service.MarketTypeService;

@Service
public class MarketTypeServiceImpl implements MarketTypeService {
	
	@Autowired
	MarketTypeRepository marketTypeRepository;
	public List<MarketType> getAllMarketType() {
		return marketTypeRepository.findAll();
	}
}
