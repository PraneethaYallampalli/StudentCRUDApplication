package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Student;


@Repository
public interface StudentDataRepo extends JpaRepository<Student,Long> {

}
