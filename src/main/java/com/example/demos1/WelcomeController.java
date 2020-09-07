package com.example.demos1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	 @Autowired
	 ResourceLoader resourceLoader;
	 
	 @Autowired
	 ServletContext context;
	 
	@GetMapping(value = "/")
	public void hello() throws IOException {
		// For storing data into CSV files
//	      StringBuffer data = new StringBuffer();
//	    //reading file from desktop
//	      
	      Resource resource1= resourceLoader.getResource("classpath:students.csv");
          File inputFile = resource1.getFile();
        //  System.out.println(inputFile);
//          //writing excel data to csv 
//          Resource resourceOut = resourceLoader.getResource("classpath:filename.txt");
//          File outputFile = resourceOut.getFile();
//          FileOutputStream fos = new FileOutputStream(outputFile);
//          FileWriter myWriter = new FileWriter(outputFile);
//
//	      try {
//	    	  
//	          // Get the workbook object for XLSX file
//	          XSSFWorkbook wBook = new XSSFWorkbook(new FileInputStream(inputFile));
//	          // Get first sheet from the workbook
//	          XSSFSheet sheet = wBook.getSheetAt(0);
//	          Row row;
//	          Cell cell;
//	          // Iterate through each rows from first sheet
//	          Iterator<Row> rowIterator = sheet.iterator();
//	          System.out.println("row"+rowIterator);
//	          while (rowIterator.hasNext()) {
//	              row = rowIterator.next();
//
//	              // For each row, iterate through each columns
//	              Iterator<Cell> cellIterator = row.cellIterator();
//	              while (cellIterator.hasNext()) {
//
//	                  cell = cellIterator.next();
//
//	                  switch (cell.getCellType()) {
//	                      case Cell.CELL_TYPE_BOOLEAN:
//	                          data.append(cell.getBooleanCellValue() + ",");
//
//	                          break;
//	                      case Cell.CELL_TYPE_NUMERIC:
//	                          data.append(cell.getNumericCellValue() + ",");
//
//	                          break;
//	                      case Cell.CELL_TYPE_STRING:
//	                          data.append(cell.getStringCellValue() + ",");
//	                          break;
//
//	                      case Cell.CELL_TYPE_BLANK:
//	                          data.append("" + ",");
//	                          break;
//	                      default:
//	                          data.append(cell + ",");
//
//	                  }
//	              }
//	          }
////	          System.out.println("data"+data);
////	          ClassLoader classLoader = getClass().getClassLoader();
////	          File file = new File(classLoader.getResource(".").getFile() + "/test.xml");
////	          if (file.createNewFile()) {
////	              System.out.println("File is created!");
////	          } else {
////	              System.out.println("File already exists.");
////	          }
//	         // myWriter.write("Files in Java might be tricky, but it is fun enough!");
//	         // myWriter.close();
//	          
//	          String thing = "Text to write to the file";
//	          //String dir = WriteResource.class.getResource("/").getFile();
//	          //String dir = WriteResource.class.getResource("/dir").getFile();
//	          //OutputStream os = new FileOutputStream(dir + "/file.txt");
////	          final PrintStream printStream = new PrintStream(fos);
////	          printStream.println(thing);
////	          printStream.close();
//	        //write objects to file:
////	          String uri = "src/main/resources/filename.txt";
////	          URL url = getClass().getResource(uri);
////	          if (outputFile != null) { //if there is a file in the location
////	              //File f = new File(url.getFile());
////	              if (outputFile.exists()) { System.out.println("exists");
////	                  ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(outputFile));
////	                  in.writeUTF("test");
////	                  in.close();
////	                  //write object into files
////	                  //....
////	              } else { System.out.println("not");
////	                  //create file and then writes data.
////	              }
////	          } else {// if URL is null, there's no such file. must jump to its parent folder and creates the file.
////	        	  System.out.println("nullfile"+outputFile);
////	          }
//	          
//	          //OutputStreamWriter osw = new OutputStreamWriter(fos);
//	            
//	          //osw.write(thing);File file = new File(classLoader.getResource(".").getFile() + "/test.xml");
//	          //File fout = new File("out.txt");
//	         // File inputFile1 = new File("C:\\Users\\DELL\\Desktop\\filename.txt");
//	         // ClassLoader classLoader = getClass().getClassLoader();
//	          Path currentWorkingDir = Paths.get("").toAbsolutePath();
//	          String rootPath = currentWorkingDir.normalize().toString();
//	          File inputFile1 = new File(rootPath+"\\src\\main\\resources\\filename.txt"); 
//	         // System.out.println(absolutePath);
//	      	FileOutputStream fos1 = new FileOutputStream(inputFile1);
//	       
//	      	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos1));
//	       
//	      //	for (int i = 0; i < 10; i++) {
//	      		bw.write("something");
//	      	//	bw.newLine();
//	      	//}
//	       
//	      	//bw.close();
//
//	      } catch (Exception ioe) { System.out.println("error file");
//	          ioe.printStackTrace();
//	      }
	      
		  Row row;
//	      Resource resourceOutput = resourceLoader.getResource("classpath:filename.txt");
//	      File outputFile = resourceOutput.getFile();
		  Path currentWorkingDir = Paths.get("").toAbsolutePath();
		  String rootPath = currentWorkingDir.normalize().toString();
		  File outputFilePath = new File(rootPath+"\\src\\main\\resources\\students.csv");
		  FileOutputStream fos1 = new FileOutputStream(inputFile);
		  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos1));
		  
	      Resource resource= resourceLoader.getResource("classpath:students.xlsx");
	      File xlsxFile = resource.getFile();
	      System.out.println(xlsxFile);
	      File newFile = new File(rootPath+"\\src\\main\\resources\\sample.text");
	      if (!newFile.exists()) {
              newFile.createNewFile();
          }
	      //File myFile = new File("Employee-Data.xlsx");
	      int sheetIdx = 0; // 0 for first sheet
	      FileInputStream fileInStream = new FileInputStream(xlsxFile);
	      
	      // Open the xlsx and get the requested sheet from the workbook
	      XSSFWorkbook workBook = new XSSFWorkbook(fileInStream);
	      XSSFSheet selSheet = workBook.getSheetAt(sheetIdx);

	      // Iterate through all the rows in the selected sheet
	      Iterator<Row> rowIterator = selSheet.iterator();
	      while (rowIterator.hasNext()) {

	          row = rowIterator.next();

	          // Iterate through all the columns in the row and build ","
	          // separated string
	          Iterator<Cell> cellIterator = row.cellIterator();
	          StringBuffer sb = new StringBuffer();
	          while (cellIterator.hasNext()) {
	              Cell cell = cellIterator.next();
	              if (sb.length() != 0) {
	                  sb.append(",");
	              }
	               
	              // If you are using poi 4.0 or over, change it to
	              // cell.getCellType
	              switch (cell.getCellTypeEnum()) {
	              case STRING:
	                  sb.append(cell.getStringCellValue());
	                  break;
	              case NUMERIC:
	                  sb.append(cell.getNumericCellValue());
	                  break;
	              case BOOLEAN:
	                  sb.append(cell.getBooleanCellValue());
	                  break;
	              default:
	              }
	          }
	          System.out.println(outputFilePath);
	          System.out.println(sb.toString());
			  
			  bw.write(sb.toString());
			  bw.newLine();
	      }
	     // workBook.close();
	      bw.close();

		//return "Welcome";
	}
}
