package com.example.demos1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demos1.model.Product;
import com.example.demos1.service.ProductService;

@RestController
@RequestMapping("product_list")
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
}
