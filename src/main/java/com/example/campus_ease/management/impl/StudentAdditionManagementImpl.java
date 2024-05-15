package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.StudentAdditionManagement;
import com.example.campus_ease.request.NotificationStatusReq;
import com.example.campus_ease.service.StudentAdditionService;
import com.example.campus_ease.shared.dto.NotificationDto;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import com.example.campus_ease.shared.utils.enums.Branch;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class StudentAdditionManagementImpl implements StudentAdditionManagement {
    private StudentAdditionService studentAdditionService;

    public StudentAdditionManagementImpl(StudentAdditionService studentAdditionService) {
        this.studentAdditionService = studentAdditionService;
    }

    @Override
    public StudentAdditionDto addStudent(StudentAdditionDto studentAdditionDto) {

        StudentAdditionDto standardStudentAdditionDto = getBranchId(studentAdditionDto);
        return studentAdditionService.addStudent(standardStudentAdditionDto);
    }

    @Override
    public StudentAdditionDto updateStudent(StudentAdditionDto studentAdditionDto) {
        StudentAdditionDto standardStudentAdditionDto = getBranchId(studentAdditionDto);
        return studentAdditionService.updateStudent(standardStudentAdditionDto);
    }

    @Override
    public StudentAdditionDto getStudent(String userID) {
        return studentAdditionService.getStudent(userID);
    }

    @Override
    public StudentAdditionDto getStudents(String userId) {
        return studentAdditionService.getStudents(userId);
    }

    @Override
    public List<StudentAdditionDto> getRegisteredStudents(ArrayList<Long> jobId) {
    return studentAdditionService.getRegisteredStudents(jobId);
    }

    @Override
    public List<StudentAdditionDto> getAllStudents(ArrayList<Long> jobId) {
        return studentAdditionService.getAllStudents(jobId);
    }

    @Override
    public List<StudentAdditionDto> getUnregisteredStudents(ArrayList<Long> jobId) {
        return studentAdditionService.getUnregisteredStudents(jobId);
    }

    @Override
    public ArrayList<String> notifyAllStudents(ArrayList<Long> jobId) {
        return studentAdditionService.notifyAllStudents(jobId);
    }

    @Override
    public ArrayList<String> notifyRegisteredStudents(ArrayList<Long> jobId) {
        return studentAdditionService.notifyRegisteredStudents(jobId);
    }

    @Override
    public ArrayList<String> notifyUnregisteredStudents(ArrayList<Long> jobId) {
        return studentAdditionService.notifyUnregisteredStudents(jobId);
    }

    @Override
    public void addNotificationData(NotificationDto notificationDto) {
        studentAdditionService.addNotificationData(notificationDto);
    }

    @Override
    public List<NotificationDto> getNotificationData(String receiverId) {
       return studentAdditionService.getNotificationData(receiverId);
    }

    @Override
    public void updateNotificationStatus(NotificationStatusReq notificationStatusReq) {
        studentAdditionService.updateNotificationStatus(notificationStatusReq);
    }

    StudentAdditionDto getBranchId(StudentAdditionDto studentAdditionDto)
    {
        Long branchId;
        if(studentAdditionDto.getBranch().equals("CS"))
            branchId = Branch.CS.getBranchId();
        else if(studentAdditionDto.getBranch().equals("IT"))
            branchId = Branch.IT.getBranchId();
        else if(studentAdditionDto.getBranch().equals("EN"))
            branchId = Branch.EN.getBranchId();
        else if(studentAdditionDto.getBranch().equals("ECE"))
            branchId = Branch.ECE.getBranchId();
        else if(studentAdditionDto.getBranch().equals("ME"))
            branchId = Branch.ME.getBranchId();
        else if(studentAdditionDto.getBranch().equals("CE"))
            branchId = Branch.CE.getBranchId();
        else if (studentAdditionDto.getBranch().equals("CSE"))
            branchId = Branch.CSE.getBranchId();
        else if(studentAdditionDto.getBranch().equals("CSE-AIML"))
            branchId = Branch.CSE_AIML.getBranchId();
        else if(studentAdditionDto.getBranch().equals("CSE-DS"))
            branchId = Branch.CSE_DS.getBranchId();
        else
            branchId = null;
        studentAdditionDto.setBranchId(branchId);
        return studentAdditionDto;
    }
}
