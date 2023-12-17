package com.example.campus_ease.service;

import com.example.campus_ease.shared.dto.StudentAdditionDto;

public interface StudentAdditionService {
    StudentAdditionDto addStudent(StudentAdditionDto studentAdditionDto);

    StudentAdditionDto updateStudent(StudentAdditionDto standardStudentAdditionDto);

    StudentAdditionDto getStudent(String userID);
}
