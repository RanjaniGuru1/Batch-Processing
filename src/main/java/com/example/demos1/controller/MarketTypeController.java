package com.example.demos1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demos1.model.MarketType;
import com.example.demos1.service.MarketTypeService;

@RestController
@RequestMapping("market_type")
@CrossOrigin
public class MarketTypeController {
	
	@Autowired
	MarketTypeService marketTypeService;
	
	@GetMapping
	public List<MarketType> getAllMarketType() {
		return marketTypeService.getAllMarketType();
	}
}
