package com.example.springbootmapstruct.repository;

import com.example.springbootmapstruct.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenRepository extends JpaRepository<Student,Long> {

}
