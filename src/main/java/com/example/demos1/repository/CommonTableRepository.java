//package com.example.demos1.repository;
//
//import java.util.Collection;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.example.demos1.model.CommonTable;
//
//public interface CommonTableRepository extends JpaRepository<CommonTable, Integer>{
//	
//	@Query("SELECT * FROM CommonTable WHERE region_id = 1")
//	Collection<CommonTable> findAllEnumLists();
//
//}
