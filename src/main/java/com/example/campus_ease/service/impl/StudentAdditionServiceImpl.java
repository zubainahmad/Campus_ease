package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.StudentInfoRepo;
import com.example.campus_ease.entity.StudentInfoEntity;
import com.example.campus_ease.mapper.StudentAdditionMapper;
import com.example.campus_ease.service.StudentAdditionService;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import com.example.campus_ease.shared.utils.enums.Branch;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentAdditionServiceImpl implements StudentAdditionService {

    private StudentInfoRepo studentInfoRepo;

    private StudentAdditionMapper studentAdditionMapper;

    public StudentAdditionServiceImpl(StudentInfoRepo studentInfoRepo, StudentAdditionMapper studentAdditionMapper) {
        this.studentInfoRepo = studentInfoRepo;
        this.studentAdditionMapper = studentAdditionMapper;
    }

    @Override
    public StudentAdditionDto addStudent(StudentAdditionDto studentAdditionDto) {
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

    @Override
    public StudentAdditionDto getStudent(String userID) {
        StudentInfoEntity studentInfoEntity = studentInfoRepo.findById(userID).orElse(null);
        StudentAdditionDto returnValue = studentAdditionMapper.studentInfoEntityToStudentAdditionDto(studentInfoEntity);
        return returnValue;
    }

    @Override
    public StudentAdditionDto getStudents(String userId)
    {
        StudentInfoEntity studentInfoEntity = studentInfoRepo.findById(userId).orElse(null);
        if(Objects.isNull(studentInfoEntity))
        {
            return null;
        }
        String branch = getBranchNameByString(studentInfoEntity.getBranchId());
        StudentAdditionDto returnValue = studentAdditionMapper.studentInfoEntityToStudentAdditionDto(studentInfoEntity);
        returnValue.setBranch(branch);
        return returnValue;
    }

    String  getBranchNameByString(Long branchId)
    {
        String name;
        if(branchId.equals(Branch.CS.getBranchId()))
            name = "CS";
        else if(branchId .equals(Branch.IT.getBranchId()))
            name = "IT";
        else if(branchId.equals(Branch.EN.getBranchId()))
            name = "EN";
        else if (branchId.equals(Branch.ECE.getBranchId()))
            name = "ECE";
        else if(branchId.equals(Branch.ME.getBranchId()))
            name = "ME";
        else if(branchId.equals(Branch.CE.getBranchId()))
            name = "CE";
        else if(branchId.equals(Branch.CSE.getBranchId()))
            name = "CSE";
        else if(branchId.equals(Branch.CSE_AIML.getBranchId()))
            name = "CSE-AIML";
        else if(branchId.equals(Branch.CSE_DS.getBranchId()))
            name = "CSE-DS";
        else
            name = null;
        return name;
    }

}
