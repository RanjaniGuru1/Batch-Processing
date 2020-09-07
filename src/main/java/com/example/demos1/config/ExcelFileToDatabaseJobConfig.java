//package com.example.demos1.config;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Iterator;
//import javax.sql.DataSource;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import com.example.demos1.listener.JobCompletionNotificationListener;
//import com.example.demos1.model.StudentDTO;
//import com.example.demos1.processor.StudentItemProcessor;
//
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//
//
//@Configuration
//@EnableBatchProcessing
//public class ExcelFileToDatabaseJobConfig {
//   @Autowired
//   public JobBuilderFactory jobBuilderFactory;
//
//   @Autowired
//   public StepBuilderFactory stepBuilderFactory;
//
//   @Autowired
//   public DataSource dataSource;
//   
//   @Autowired
//   ResourceLoader resourceLoader;
//   
//   @Bean
//   public FlatFileItemReader<StudentDTO> reader() throws IOException {
//      FlatFileItemReader<StudentDTO> reader = new FlatFileItemReader<StudentDTO>();
//      Row row;
//      Resource resourceOutput = resourceLoader.getResource("classpath:students.csv");
//	  File resourceOutputFile = resourceOutput.getFile();
//	  FileOutputStream fos1 = new FileOutputStream(resourceOutputFile);
//	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos1));
//      Resource resource= resourceLoader.getResource("classpath:students.xlsx");
//      File xlsxFile = resource.getFile();
//      int sheetIdx = 0; // 0 for first sheet
//      FileInputStream fileInStream = new FileInputStream(xlsxFile);
//      
//      // Open the xlsx and get the requested sheet from the workbook
//      XSSFWorkbook workBook = new XSSFWorkbook(fileInStream);
//      XSSFSheet selSheet = workBook.getSheetAt(sheetIdx);
//
//      // Iterate through all the rows in the selected sheet
//      Iterator<Row> rowIterator = selSheet.iterator();
//      while (rowIterator.hasNext()) {
//
//          row = rowIterator.next();
//
//          // Iterate through all the columns in the row and build ","
//          // separated string
//          Iterator<Cell> cellIterator = row.cellIterator();
//          StringBuffer sb = new StringBuffer();
//          while (cellIterator.hasNext()) {
//              Cell cell = cellIterator.next();
//              if (sb.length() != 0) {
//                  sb.append(",");
//              }
//               
//              // If you are using poi 4.0 or over, change it to
//              // cell.getCellType
//              switch (cell.getCellTypeEnum()) {
//              case STRING:
//                  sb.append(cell.getStringCellValue());
//                  break;
//              case NUMERIC:
//                  sb.append(cell.getNumericCellValue());
//                  break;
//              case BOOLEAN:
//                  sb.append(cell.getBooleanCellValue());
//                  break;
//              default:
//              }
//          }
//         // System.out.println(sb.toString());
//		  
//		  bw.write(sb.toString());
//		  bw.newLine();
//      }
//      bw.close();
//      
//	  reader.setResource(new ClassPathResource("students.csv"));
//	  reader.setLinesToSkip(1); 
//	  reader.setLineMapper(new DefaultLineMapper<StudentDTO>() {
//         {
//            setLineTokenizer(new DelimitedLineTokenizer() {
//               {
//                  setNames(new String[] { "name", "emailAddress", "purchasedPackage" });
//               }
//            });
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<StudentDTO>() {
//               {
//                  setTargetType(StudentDTO.class);
//               }
//            });
//         }
//      });
//      
//      return reader;
//   }
//   @Bean
//   public StudentItemProcessor processor() {
//      return new StudentItemProcessor();
//   }
//   @Bean
//   public JdbcBatchItemWriter<StudentDTO> writer() {
//      JdbcBatchItemWriter<StudentDTO> writer = new JdbcBatchItemWriter<StudentDTO>();
//      writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<StudentDTO>());
//      writer.setSql("INSERT INTO students (name, email_address, purchase_package) VALUES (:name, :emailAddress, :purchasedPackage)");
//      writer.setDataSource(dataSource);
//      return writer;
//   }
//   @Bean
//   public Job importStudentDTOJob(JobCompletionNotificationListener listener) throws IOException {
//      return jobBuilderFactory.get("importStudentDTOJob").incrementer(
//         new RunIdIncrementer()).listener(listener).flow(step1()).end().build();
//   }
//   @Bean
//   public Step step1() throws IOException {
//      return stepBuilderFactory.get("step1").<StudentDTO, StudentDTO>chunk(10).reader(reader()).processor(processor()).writer(writer()).build();
//   }
//   
//   
//}