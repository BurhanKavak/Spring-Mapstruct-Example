package com.example.springbootmapstruct.service;


import com.example.springbootmapstruct.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student createStudent(Student student);

    Student updateStudent(Student student, Long studentId);

    void deleteStudent(Long studentId);

}
