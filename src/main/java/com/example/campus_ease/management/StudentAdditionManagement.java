package com.example.campus_ease.management;

import com.example.campus_ease.shared.dto.StudentAdditionDto;

public interface StudentAdditionManagement {
     StudentAdditionDto addStudent(StudentAdditionDto studentAdditionDto);

     StudentAdditionDto updateStudent(StudentAdditionDto studentAdditionDto);

     StudentAdditionDto getStudent(String userID);
}
