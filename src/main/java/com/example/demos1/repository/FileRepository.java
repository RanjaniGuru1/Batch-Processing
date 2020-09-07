package com.example.demos1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demos1.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

}
