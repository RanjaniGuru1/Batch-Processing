package com.example.demos1.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

//@Configuration
public class XLSXToCSVConverter {
	
	@Autowired
	ResourceLoader resourceLoader;
	
    //@Bean
	public void echoAsCSV(Sheet sheet) {
        Row row = null;
        for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print("\"" + row.getCell(j) + "\";");
        }
        System.out.println();
    }
}
    //@Bean
    public void getCSVFile() {
		InputStream inp = null;
		try {
		    //inp = new FileInputStream("students.xlsx");
			Resource resource=resourceLoader.getResource("classpath:students.xlsx");
			InputStream resourcee = resource.getInputStream();
			//File file = resource.getFile();
		    Workbook wb = WorkbookFactory.create(resourcee);
		
		    for(int i=0;i<wb.getNumberOfSheets();i++) {
		        System.out.println(wb.getSheetAt(i).getSheetName());
		        this.echoAsCSV(wb.getSheetAt(i));
		    }
		    System.out.println("try");
		} catch (InvalidFormatException ex) { System.out.println("catch1");
		    Logger.getLogger(XLSXToCSVConverter.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException ex) { System.out.println("catch2");
		    Logger.getLogger(XLSXToCSVConverter.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) { System.out.println("catch3");
		    Logger.getLogger(XLSXToCSVConverter.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
		    try {
		        inp.close();
		    } catch (IOException ex) {
		        Logger.getLogger(XLSXToCSVConverter.class.getName()).log(Level.SEVERE, null, ex);
		    }
		}
   }
}