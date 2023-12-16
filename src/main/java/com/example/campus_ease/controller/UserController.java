package com.example.campus_ease.controller;

import com.example.campus_ease.management.CcpdAdditionManagement;
import com.example.campus_ease.management.StudentAdditionManagement;
import com.example.campus_ease.mapper.CcpdAdditionMapper;
import com.example.campus_ease.mapper.StudentAdditionMapper;
import com.example.campus_ease.mapper.StudentAdditionMapperImpl;
import com.example.campus_ease.request.CcpdAdditionReq;
import com.example.campus_ease.request.StudentAdditionReq;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    private StudentAdditionManagement studentAdditionManagement;

   private StudentAdditionMapper studentAdditionMapper;

   private CcpdAdditionMapper ccpdAdditionMapper;

   private CcpdAdditionManagement ccpdAdditionManagement;

    public UserController(StudentAdditionManagement studentAdditionManagement, StudentAdditionMapper studentAdditionMapper, CcpdAdditionMapper ccpdAdditionMapper, CcpdAdditionManagement ccpdAdditionManagement) {
        this.studentAdditionManagement = studentAdditionManagement;
        this.studentAdditionMapper = studentAdditionMapper;
        this.ccpdAdditionMapper = ccpdAdditionMapper;
        this.ccpdAdditionManagement = ccpdAdditionManagement;
    }

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody StudentAdditionReq studentAdditionReq){
        StudentAdditionDto studentAdditionDto = studentAdditionMapper.studentReqToStudentAdditionDto(studentAdditionReq);
        StudentAdditionDto standardDto = studentAdditionManagement.addUser(studentAdditionDto);
        return ResponseEntity.ok().body("Student added successfully");
    }

    @PostMapping("/ccpd")
    public ResponseEntity<String> addCcpd(@RequestBody CcpdAdditionReq ccpdAdditionReq){
        CcpdAdditionDto ccpdAdditionDto = ccpdAdditionMapper.ccpdAdditionReqToCcpdAdditionDto(ccpdAdditionReq);
        CcpdAdditionDto standardDto = ccpdAdditionManagement.addCcpd(ccpdAdditionDto);
        return ResponseEntity.ok().body("CCPD person added successfully");
    }
}
