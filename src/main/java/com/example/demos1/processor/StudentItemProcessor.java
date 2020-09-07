package com.example.demos1.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.demos1.model.StudentDTO;
import com.example.demos1.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentItemProcessor implements ItemProcessor<StudentDTO, StudentDTO> {
   private static final Logger log = LoggerFactory.getLogger(StudentItemProcessor.class);

   @Override
   public StudentDTO process(final StudentDTO student) throws Exception {
      final String name = student.getName();
      final String emailAddress = student.getEmailAddress();
      final String purchasePackage = student.getPurchasedPackage();
      final StudentDTO transformedPerson = new StudentDTO(name, emailAddress, purchasePackage);

      log.info("Converting (" + student + ") into (" + transformedPerson + ")");
      return transformedPerson;
   }
}
