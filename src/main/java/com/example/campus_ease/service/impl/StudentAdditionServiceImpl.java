package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.StudentInfoRepo;
import com.example.campus_ease.entity.StudentInfoEntity;
import com.example.campus_ease.mapper.StudentAdditionMapper;
import com.example.campus_ease.service.StudentAdditionService;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import org.springframework.stereotype.Service;

@Service
public class StudentAdditionServiceImpl implements StudentAdditionService {

    private StudentInfoRepo studentInfoRepo;

    private StudentAdditionMapper studentAdditionMapper;

    public StudentAdditionServiceImpl(StudentInfoRepo studentInfoRepo, StudentAdditionMapper studentAdditionMapper) {
        this.studentInfoRepo = studentInfoRepo;
        this.studentAdditionMapper = studentAdditionMapper;
    }

    @Override
    public StudentAdditionDto addUser(StudentAdditionDto studentAdditionDto) {
        StudentInfoEntity studentInfoEntity = studentAdditionMapper.studentAdditionDtoToStudentInfoEntity(studentAdditionDto);
        StudentInfoEntity savedEntity = studentInfoRepo.save(studentInfoEntity);
        StudentAdditionDto returnValue = studentAdditionMapper.studentInfoEntityToStudentAdditionDto(savedEntity);
        return returnValue;
    }


    @Override
    public StudentAdditionDto updateStudent(StudentAdditionDto studentAdditionDto) {
        StudentInfoEntity studentInfoEntity = studentAdditionMapper.studentAdditionDtoToStudentInfoEntity(studentAdditionDto);
        StudentInfoEntity savedEntity = studentInfoRepo.save(studentInfoEntity);
        StudentAdditionDto returnValue = studentAdditionMapper.studentInfoEntityToStudentAdditionDto(savedEntity);
        return returnValue;
    }
}
