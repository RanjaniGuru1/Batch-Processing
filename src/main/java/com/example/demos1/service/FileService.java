package com.example.demos1.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demos1.model.File;

public interface FileService {
	
	void storeFile(MultipartFile file);
}
