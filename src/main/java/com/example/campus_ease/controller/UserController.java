package com.example.campus_ease.controller;

import com.example.campus_ease.management.CcpdAdditionManagement;
import com.example.campus_ease.management.StudentAdditionManagement;
import com.example.campus_ease.mapper.CcpdAdditionMapper;
import com.example.campus_ease.mapper.StudentAdditionMapper;
import com.example.campus_ease.request.CcpdAdditionReq;
import com.example.campus_ease.request.StudentAdditionReq;
import com.example.campus_ease.response.StudentsRes;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        StudentAdditionDto standardDto = studentAdditionManagement.addStudent(studentAdditionDto);
        return ResponseEntity.ok().body("Details added successfully");
    }

    @PutMapping("/student")
    public ResponseEntity<String> updateStudent(@RequestBody StudentAdditionReq studentAdditionReq){
        StudentAdditionDto studentAdditionDto = studentAdditionMapper.studentReqToStudentAdditionDto(studentAdditionReq);
        StudentAdditionDto standardDto = studentAdditionManagement.updateStudent(studentAdditionDto);
        return ResponseEntity.ok().body("User updated successfully");
    }

    @GetMapping("/students/{userId}")
    public ResponseEntity<StudentsRes> getStudents(@PathVariable String userId){
        StudentAdditionDto studentAdditionDto = studentAdditionManagement.getStudents(userId);
        StudentsRes studentsRes = studentAdditionMapper.studentAdditionDtoToStudentsRes(studentAdditionDto);
        return ResponseEntity.ok().body(studentsRes);
    }
    @PostMapping("/ccpd")
    public ResponseEntity<String> addCcpd(@RequestBody CcpdAdditionReq ccpdAdditionReq){
        CcpdAdditionDto ccpdAdditionDto = ccpdAdditionMapper.ccpdAdditionReqToCcpdAdditionDto(ccpdAdditionReq);
        CcpdAdditionDto standardDto = ccpdAdditionManagement.addCcpd(ccpdAdditionDto);
        return ResponseEntity.ok().body("User added successfully");
    }

    @GetMapping("/student/{userID}")
    public ResponseEntity<String> getStudent(@PathVariable String userID){
        StudentAdditionDto studentAdditionDto = studentAdditionManagement.getStudent(userID);
        if(Objects.nonNull(studentAdditionDto))
            return ResponseEntity.ok().body("User exists");
        else
            return ResponseEntity.ok().body("User does not exist");
    }

    @GetMapping("/students/registered/{jobId}")
public ResponseEntity<List<StudentsRes>> getRegisteredStudents(@PathVariable ArrayList<Long> jobId){
        List<StudentAdditionDto> studentAdditionDto = studentAdditionManagement.getRegisteredStudents(jobId);
        List<StudentsRes> res = new ArrayList<>();
        for (StudentAdditionDto standarDto:studentAdditionDto) {
            StudentsRes studentsRes = studentAdditionMapper.studentAdditionDtoToStudentsRes(standarDto);
            res.add(studentsRes);
        }
        return ResponseEntity.ok().body(res);
    }


    @GetMapping("/students/all/{jobId}")
    public ResponseEntity<List<StudentsRes>> getAllStudents(@PathVariable ArrayList<Long> jobId){
        List<StudentAdditionDto> studentAdditionDto = studentAdditionManagement.getAllStudents(jobId);
        List<StudentsRes> res = new ArrayList<>();
        for (StudentAdditionDto standarDto:studentAdditionDto) {
            StudentsRes studentsRes = studentAdditionMapper.studentAdditionDtoToStudentsRes(standarDto);
            res.add(studentsRes);
        }
        return ResponseEntity.ok().body(res);
    }


    @GetMapping("/students/unregistered/{jobId}")
    public ResponseEntity<List<StudentsRes>> getUnregisteredStudents(@PathVariable ArrayList<Long> jobId){
        List<StudentAdditionDto> studentAdditionDto = studentAdditionManagement.getUnregisteredStudents(jobId);
        List<StudentsRes> res = new ArrayList<>();
        for (StudentAdditionDto standarDto:studentAdditionDto) {
            StudentsRes studentsRes = studentAdditionMapper.studentAdditionDtoToStudentsRes(standarDto);
            res.add(studentsRes);
        }
        return ResponseEntity.ok().body(res);
    }




}
