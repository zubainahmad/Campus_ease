package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.StudentAdditionManagement;
import com.example.campus_ease.service.StudentAdditionService;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import com.example.campus_ease.utils.enums.Branch;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
@Transactional
@Component
public class StudentAdditionManagementImpl implements StudentAdditionManagement {
    private StudentAdditionService studentAdditionService;

    public StudentAdditionManagementImpl(StudentAdditionService studentAdditionService) {
        this.studentAdditionService = studentAdditionService;
    }

    @Override
    public StudentAdditionDto addUser(StudentAdditionDto studentAdditionDto) {

        StudentAdditionDto standardStudentAdditionDto = getBranchId(studentAdditionDto);
        return studentAdditionService.addUser(standardStudentAdditionDto);
    }

    StudentAdditionDto getBranchId(StudentAdditionDto studentAdditionDto)
    {
        Long branchId;
        if(studentAdditionDto.getBranch().equals("CS"))
            branchId = Branch.CS.getBranchId();
        else if(studentAdditionDto.getBranch().equals("IT"))
            branchId = Branch.IT.getBranchId();
        else if(studentAdditionDto.getBranch().equals("EE"))
            branchId = Branch.EE.getBranchId();
        else if(studentAdditionDto.getBranch().equals("EC"))
            branchId = Branch.EC.getBranchId();
        else if(studentAdditionDto.getBranch().equals("ME"))
            branchId = Branch.ME.getBranchId();
        else if(studentAdditionDto.getBranch().equals("CE"))
            branchId = Branch.CE.getBranchId();
        else
            branchId = null;
        studentAdditionDto.setBranchId(branchId);
        return studentAdditionDto;
    }
}
