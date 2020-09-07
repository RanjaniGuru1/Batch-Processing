package com.example.demos1.mapper;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import com.example.demos1.model.StudentDTO;
 
public class StudentExcelRowMapper implements RowMapper<StudentDTO> {
 
    @Override
    public StudentDTO mapRow(RowSet rowSet) throws Exception {
        StudentDTO student = new StudentDTO();
 
        student.setName(rowSet.getColumnValue(0));
        student.setEmailAddress(rowSet.getColumnValue(1));
        student.setPurchasedPackage(rowSet.getColumnValue(2));
 
        return student;
    }
}