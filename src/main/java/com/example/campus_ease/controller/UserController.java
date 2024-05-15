package com.example.campus_ease.controller;

import com.example.campus_ease.management.CcpdAdditionManagement;
import com.example.campus_ease.management.StudentAdditionManagement;
import com.example.campus_ease.mapper.CcpdAdditionMapper;
import com.example.campus_ease.mapper.NotificationMapper;
import com.example.campus_ease.mapper.StudentAdditionMapper;
import com.example.campus_ease.request.CcpdAdditionReq;
import com.example.campus_ease.request.NotificationReq;
import com.example.campus_ease.request.NotificationStatusReq;
import com.example.campus_ease.request.StudentAdditionReq;
import com.example.campus_ease.response.CcpdRes;
import com.example.campus_ease.response.NotificationResponse;
import com.example.campus_ease.response.StudentsRes;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;
import com.example.campus_ease.shared.dto.NotificationDto;
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


   private NotificationMapper notificationMapper;

    public UserController(StudentAdditionManagement studentAdditionManagement, StudentAdditionMapper studentAdditionMapper, CcpdAdditionMapper ccpdAdditionMapper, CcpdAdditionManagement ccpdAdditionManagement, NotificationMapper notificationMapper) {
        this.studentAdditionManagement = studentAdditionManagement;
        this.studentAdditionMapper = studentAdditionMapper;
        this.ccpdAdditionMapper = ccpdAdditionMapper;
        this.ccpdAdditionManagement = ccpdAdditionManagement;
        this.notificationMapper = notificationMapper;
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

    @GetMapping("/ccpd/{userID}")
    public ResponseEntity<CcpdRes> getCcpd(@PathVariable String userID){
     CcpdRes ccpdRes = ccpdAdditionManagement.getCcpd(userID);
        return ResponseEntity.ok().body(ccpdRes);
    }

    @GetMapping("/student/{userID}")
    public ResponseEntity<String> getStudent(@PathVariable String userID){
        StudentAdditionDto studentAdditionDto = studentAdditionManagement.getStudent(userID);
        if(Objects.nonNull(studentAdditionDto))
            return ResponseEntity.ok().body("User exists");
        else
            return ResponseEntity.ok().body("User does not exist");
    }

    @GetMapping("/students/registered")
public ResponseEntity<List<StudentsRes>> getRegisteredStudents(@RequestParam ArrayList<Long> jobId){
        List<StudentAdditionDto> studentAdditionDto = studentAdditionManagement.getRegisteredStudents(jobId);
        List<StudentsRes> res = new ArrayList<>();
        for (StudentAdditionDto standarDto:studentAdditionDto) {
            StudentsRes studentsRes = studentAdditionMapper.studentAdditionDtoToStudentsRes(standarDto);
            res.add(studentsRes);
        }
        return ResponseEntity.ok().body(res);
    }


    @GetMapping("/students/all")
    public ResponseEntity<List<StudentsRes>> getAllStudents(@RequestParam ArrayList<Long> jobId){
        List<StudentAdditionDto> studentAdditionDto = studentAdditionManagement.getAllStudents(jobId);
        List<StudentsRes> res = new ArrayList<>();
        for (StudentAdditionDto standarDto:studentAdditionDto) {
            StudentsRes studentsRes = studentAdditionMapper.studentAdditionDtoToStudentsRes(standarDto);
            res.add(studentsRes);
        }
        return ResponseEntity.ok().body(res);
    }


    @GetMapping("/students/unregistered")
    public ResponseEntity<List<StudentsRes>> getUnregisteredStudents(@RequestParam ArrayList<Long> jobId){
        List<StudentAdditionDto> studentAdditionDto = studentAdditionManagement.getUnregisteredStudents(jobId);
        List<StudentsRes> res = new ArrayList<>();
        for (StudentAdditionDto standarDto:studentAdditionDto) {
            StudentsRes studentsRes = studentAdditionMapper.studentAdditionDtoToStudentsRes(standarDto);
            res.add(studentsRes);
        }
        return ResponseEntity.ok().body(res);
    }


    @GetMapping("students/notify/all")
    public ResponseEntity<ArrayList<String>> notifyAllStudents(@RequestParam ArrayList<Long> jobId){
        ArrayList<String> all = studentAdditionManagement.notifyAllStudents(jobId);
        return ResponseEntity.ok().body(all);
    }


    @GetMapping("students/notify/registered")
    public ResponseEntity<ArrayList<String>> notifyRegisteredStudents(@RequestParam ArrayList<Long> jobId){
        ArrayList<String> registered = studentAdditionManagement.notifyRegisteredStudents(jobId);
        return ResponseEntity.ok().body(registered);
    }

    @GetMapping("students/notify/unregistered")
    public ResponseEntity<ArrayList<String>> notifyUnregisteredStudents(@RequestParam ArrayList<Long> jobId){
        ArrayList<String> unregistered = studentAdditionManagement.notifyUnregisteredStudents(jobId);
        return ResponseEntity.ok().body(unregistered);
    }


    @PostMapping("/notification/data")
    public ResponseEntity<String> addNotificationData(@RequestBody NotificationReq notificationReq){
        ArrayList<String> receiverId = notificationReq.getReceiverId();
        for (String receiver: receiverId) {
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setReceiverId(receiver);
            notificationDto.setContent(notificationReq.getContent());
            notificationDto.setStatus(notificationReq.getStatus());
            studentAdditionManagement.addNotificationData(notificationDto);
        }
        return ResponseEntity.ok().body("Records added successfully");
    }


    @GetMapping ("/notification/data/{receiverId}")
    public ResponseEntity<List<NotificationResponse>> getNotificationData(@PathVariable String receiverId){
        List<NotificationDto> notificationDto = studentAdditionManagement.getNotificationData(receiverId);
        List<NotificationResponse> notificationResponses = new ArrayList<>();
        for (NotificationDto notificationData:notificationDto) {
            NotificationResponse notificationResponse = notificationMapper.notificationDtoToNotificationResponse(notificationData);
            notificationResponses.add(notificationResponse);
        }
        return ResponseEntity.ok().body(notificationResponses);
    }


    @PostMapping ("/notification/status")
    public ResponseEntity<String> updateNotificationStatus(@RequestBody NotificationStatusReq notificationStatusReq)
    {
        studentAdditionManagement.updateNotificationStatus(notificationStatusReq);
        return ResponseEntity.ok().body("Status updated successfully");
    }






}
