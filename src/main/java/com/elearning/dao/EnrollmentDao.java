package com.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.elearning.models.EnrollmentTable;

public interface EnrollmentDao extends JpaRepository<EnrollmentTable, Integer>{
}
