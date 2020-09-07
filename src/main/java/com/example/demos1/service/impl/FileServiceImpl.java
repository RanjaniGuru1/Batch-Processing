package com.example.demos1.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demos1.model.File;
import com.example.demos1.repository.FileRepository;
import com.example.demos1.service.FileService;

import antlr.StringUtils;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	FileRepository fileRepository;
	
	@Override
	public void storeFile(MultipartFile file)  {
        String fileName = file.getOriginalFilename();
        File dbFile;
		try {
			dbFile = new File(fileName, file.getContentType(), file.getBytes());
			fileRepository.save(dbFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
