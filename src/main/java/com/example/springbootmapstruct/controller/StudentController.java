package com.example.springbootmapstruct.controller;

import com.example.springbootmapstruct.dto.StudentDto;
import com.example.springbootmapstruct.mapper.StudentMapper;
import com.example.springbootmapstruct.model.Student;
import com.example.springbootmapstruct.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        List<Student> students = studentService.getAll();
        List<StudentDto> studentDtos = studentMapper.studentDtoToStudent(students);
        return ResponseEntity.ok(studentDtos);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        Student student = studentMapper.studentDtoToStudent(studentDto);
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);

    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(name = "studentId") Long studentId,@RequestBody StudentDto studentDto) {
        Student student = studentMapper.studentDtoToStudent(studentDto);
        studentService.updateStudent(student,studentId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentDto);

    }


    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
