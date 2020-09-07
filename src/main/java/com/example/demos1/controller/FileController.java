package com.example.demos1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demos1.model.File;
import com.example.demos1.service.FileService;

@RestController
@RequestMapping
public class FileController {
	
	@Autowired
	FileService fileService;
	
	@PostMapping("/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		fileService.storeFile(file);
	}
}
