package com.example.campus_ease.management;

import com.example.campus_ease.response.StudentsRes;
import com.example.campus_ease.shared.dto.StudentAdditionDto;

import java.util.ArrayList;
import java.util.List;

public interface StudentAdditionManagement {
     StudentAdditionDto addStudent(StudentAdditionDto studentAdditionDto);

     StudentAdditionDto updateStudent(StudentAdditionDto studentAdditionDto);

     StudentAdditionDto getStudent(String userID);


     StudentAdditionDto getStudents(String userId);

    List<StudentAdditionDto> getRegisteredStudents(ArrayList<Long> jobId);

    List<StudentAdditionDto> getAllStudents(ArrayList<Long> jobId);

    List<StudentAdditionDto> getUnregisteredStudents(ArrayList<Long> jobId);

    ArrayList<String> notifyAllStudents(ArrayList<Long> jobId);

    ArrayList<String> notifyRegisteredStudents(ArrayList<Long> jobId);

    ArrayList<String> notifyUnregisteredStudents(ArrayList<Long> jobId);
}
