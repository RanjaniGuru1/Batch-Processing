package com.example.demos1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "files")
@Data
public class File {
	
	@Id
	private int id;
	
	private String filename;
	
	private String filetype;
	
	@Lob
	private byte[] data;
	
	public File(String fileName, String fileType, byte[] data) {
        this.filename = fileName;
        this.filetype = fileType;
        this.data = data;
    }
}
