package com.example.springbootmapstruct.service;

import com.example.springbootmapstruct.model.Student;
import com.example.springbootmapstruct.repository.StudenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenServiceImpl implements StudentService {

    private final StudenRepository studenRepository;

    public StudenServiceImpl(StudenRepository studenRepository) {
        this.studenRepository = studenRepository;
    }

    @Override
    public List<Student> getAll() {
        return studenRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studenRepository.save(student);
    }

    @Override
    public Student updateStudent(Student newStudent, Long studentId) {
        Optional<Student> student = studenRepository.findById(studentId);
        if (student.isPresent()) {
            Student foundStudent = student.get();
            foundStudent.setTeacherNotes(newStudent.getTeacherNotes());
            studenRepository.save(foundStudent);
            return foundStudent;
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        studenRepository.deleteById(studentId);
    }
}
