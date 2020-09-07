package com.example.demos1.listener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demos1.model.StudentDTO;
import com.example.demos1.model.User;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
   private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
   private final JdbcTemplate jdbcTemplate;

   @Autowired
   public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }
   @Override
   public void afterJob(JobExecution jobExecution) {
      if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
         log.info("!!! JOB FINISHED !! It's time to verify the results!!");

         List<StudentDTO> results = jdbcTemplate.query(
            "SELECT name, email_address, purchase_package FROM students", new RowMapper<StudentDTO>() {
            
            @Override
            public StudentDTO mapRow(ResultSet rs, int row) throws SQLException {
               return new StudentDTO(rs.getString(1), rs.getString(2), rs.getString(3));
            }
         });

         for (StudentDTO person : results) {
            log.info("Found <" + person + "> in the database.");
         }
      }
   }
}