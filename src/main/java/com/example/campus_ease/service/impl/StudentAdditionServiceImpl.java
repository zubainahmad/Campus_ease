package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.JobPostedRepo;
import com.example.campus_ease.dao.NotificationRepo;
import com.example.campus_ease.dao.StudentInfoRepo;
import com.example.campus_ease.entity.NotificationInfoEntity;
import com.example.campus_ease.entity.StudentInfoEntity;
import com.example.campus_ease.mapper.NotificationMapper;
import com.example.campus_ease.mapper.StudentAdditionMapper;
import com.example.campus_ease.request.NotificationStatusReq;
import com.example.campus_ease.service.StudentAdditionService;
import com.example.campus_ease.shared.dto.NotificationDto;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import com.example.campus_ease.shared.utils.enums.Branch;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentAdditionServiceImpl implements StudentAdditionService {

    private StudentInfoRepo studentInfoRepo;

    private StudentAdditionMapper studentAdditionMapper;


    private JobPostedRepo jobPostedRepo;

    private NotificationRepo notificationRepo;

    private NotificationMapper notificationMapper;

    private EntityManager entityManager;

    public StudentAdditionServiceImpl(StudentInfoRepo studentInfoRepo, StudentAdditionMapper studentAdditionMapper, JobPostedRepo jobPostedRepo, NotificationRepo notificationRepo, NotificationMapper notificationMapper, EntityManager entityManager) {
        this.studentInfoRepo = studentInfoRepo;
        this.studentAdditionMapper = studentAdditionMapper;
        this.jobPostedRepo = jobPostedRepo;
        this.notificationRepo = notificationRepo;
        this.notificationMapper = notificationMapper;
        this.entityManager = entityManager;
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

    @Override
    public List<StudentAdditionDto> getRegisteredStudents(ArrayList<Long> jobId) {
        String name = jobPostedRepo.findCompanyNameByIds(jobId);
        if(Objects.isNull(name))
            return new ArrayList<>();

        String query ="SELECT JSON_BUILD_OBJECT('userId',se.user_id,'branchId',se.branch_id,'collegeAdmissionNumber',se.college_admission_number,'email',se.email,'firstName',se.first_name,'lastName',se.last_name,'percentage',se.percentage,'rollNumber',se.roll_number,'sgpa',se.sgpa,'imageUrl',se.image_url) FROM \"public\".job_posted_entity AS je JOIN \"public\".student_info_entity AS\n" +
                "se ON je.branch_id = se.branch_id JOIN \"public\".job_management_entity AS jme ON jme.id = je.id WHERE company_name = :name\n" +
                "AND se.user_id = ANY(applied_students)";
        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery(query);
        nativeQuery.setParameter("name",name);
        List<Object> result = nativeQuery.getResultList();
        ObjectMapper objectMapper = new ObjectMapper();
        List<StudentAdditionDto> studentAdditionDtos = new ArrayList<>();
        try {
            for(Object object : result)
            {
                StudentAdditionDto studentAdditionDto = objectMapper.readValue(object.toString(),StudentAdditionDto.class);
                studentAdditionDtos.add(studentAdditionDto);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return studentAdditionDtos;
    }

    @Override
    public List<StudentAdditionDto> getAllStudents(ArrayList<Long> jobId) {
        String name = jobPostedRepo.findCompanyNameByIds(jobId);
        if(Objects.isNull(name))
            return new ArrayList<>();

        String query = "SELECT JSON_BUILD_OBJECT('userId',se.user_id,'branchId',se.branch_id,'collegeAdmissionNumber',se.college_admission_number,'email',se.email,'firstName',se.first_name,'lastName',se.last_name,'percentage',se.percentage,'rollNumber',se.roll_number,'sgpa',se.sgpa,'imageUrl',se.image_url) FROM \"public\".job_posted_entity AS je JOIN \"public\".student_info_entity AS\n" +
                "se ON je.branch_id = se.branch_id WHERE company_name = :name\n";
        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery(query);
        nativeQuery.setParameter("name",name);
        List<Object> result = nativeQuery.getResultList();
        ObjectMapper objectMapper = new ObjectMapper();
        List<StudentAdditionDto> studentAdditionDtos = new ArrayList<>();
        try {
            for(Object object : result)
            {
                StudentAdditionDto studentAdditionDto = objectMapper.readValue(object.toString(),StudentAdditionDto.class);
                studentAdditionDtos.add(studentAdditionDto);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return studentAdditionDtos;
    }

    @Override
    public List<StudentAdditionDto> getUnregisteredStudents(ArrayList<Long> jobId) {
        String name = jobPostedRepo.findCompanyNameByIds(jobId);
        if(Objects.isNull(name))
            return new ArrayList<>();

        String query = "SELECT JSON_BUILD_OBJECT('userId',se.user_id,'branchId',se.branch_id,'collegeAdmissionNumber',se.college_admission_number,'email',se.email,'firstName',se.first_name,'lastName',se.last_name,'percentage',se.percentage,'rollNumber',se.roll_number,'sgpa',se.sgpa,'imageUrl',se.image_url) FROM \"public\".job_posted_entity AS je JOIN \"public\".student_info_entity AS\n" +
                "se ON je.branch_id = se.branch_id JOIN \"public\".job_management_entity AS jme ON jme.id = je.id WHERE company_name = :name\n" +
                "AND NOT se.user_id = ANY(applied_students)\n";
        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery(query);
        nativeQuery.setParameter("name",name);
        List<Object> result = nativeQuery.getResultList();
        ObjectMapper objectMapper = new ObjectMapper();
        List<StudentAdditionDto> studentAdditionDtos = new ArrayList<>();
        try {
            for(Object object : result)
            {
                StudentAdditionDto studentAdditionDto = objectMapper.readValue(object.toString(),StudentAdditionDto.class);
                studentAdditionDtos.add(studentAdditionDto);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return studentAdditionDtos;
    }

    @Override
    public ArrayList<String> notifyAllStudents(ArrayList<Long> jobId) {
        String name = jobPostedRepo.findCompanyNameByIds(jobId);
        if(Objects.isNull(name))
            return new ArrayList<>();

        ArrayList<String> all = jobPostedRepo.findIdsAll(name);
        return all;
    }

    @Override
    public ArrayList<String> notifyRegisteredStudents(ArrayList<Long> jobId) {

        String name = jobPostedRepo.findCompanyNameByIds(jobId);
        if(Objects.isNull(name))
            return new ArrayList<>();

        ArrayList<String> registered = jobPostedRepo.findIdsRegistered(name);
        return registered;
    }

    @Override
    public ArrayList<String> notifyUnregisteredStudents(ArrayList<Long> jobId) {
        String name = jobPostedRepo.findCompanyNameByIds(jobId);
        if(Objects.isNull(name))
            return new ArrayList<>();

        ArrayList<String> unregistered = jobPostedRepo.findIdsUnregistered(name);
        return unregistered;
    }

    @Override
    public void addNotificationData(NotificationDto notificationDto) {
        NotificationInfoEntity notificationInfoEntity = notificationMapper.notificationDtoToNotificationInfoEntity(notificationDto);
        notificationRepo.save(notificationInfoEntity);
    }

    @Override
    public List<NotificationDto> getNotificationData(String receiverId) {
        List<NotificationInfoEntity> notificationInfoEntities = notificationRepo.findByReceiverId(receiverId);
        List<NotificationDto> notificationDtos = new ArrayList<>();
        for(NotificationInfoEntity notificationInfoEntity : notificationInfoEntities)
        {
            NotificationDto notificationDto = notificationMapper.notificationInfoEntityToNotificationDto(notificationInfoEntity);
            notificationDtos.add(notificationDto);
        }
        return notificationDtos;
    }

    @Override
    public void updateNotificationStatus(NotificationStatusReq notificationStatusReq) {
        ArrayList<Long> notificationId = notificationStatusReq.getId();
        for (Long id: notificationId) {
            NotificationInfoEntity notificationInfoEntity = notificationRepo.findById(id).orElse(null);
            notificationInfoEntity.setStatus(notificationStatusReq.getStatus());
            notificationRepo.save(notificationInfoEntity);
        }
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
