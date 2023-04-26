package com.example.springbootmapstruct.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    long tcNumber;

    String nameSurname;

    String motherName;

    String fatherName;

    int age;

    String schoolName;

    String country;

    String city;

    String postalCode;

    String schoolScore;

    String healthNotes;

    String teacherNotes;
}
