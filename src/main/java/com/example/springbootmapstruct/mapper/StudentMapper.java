package com.example.springbootmapstruct.mapper;

import com.example.springbootmapstruct.dto.StudentDto;
import com.example.springbootmapstruct.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student studentDtoToStudent(StudentDto studentDto);

    StudentDto studentToStudentDto(Student student);

    List<StudentDto> studentDtoToStudent(List<Student> students);
}
