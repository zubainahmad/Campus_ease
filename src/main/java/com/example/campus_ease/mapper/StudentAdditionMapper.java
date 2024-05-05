package com.example.campus_ease.mapper;

import com.example.campus_ease.entity.StudentInfoEntity;
import com.example.campus_ease.request.StudentAdditionReq;
import com.example.campus_ease.response.StudentsJobsInfoRes;
import com.example.campus_ease.response.StudentsRes;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import com.example.campus_ease.shared.dto.StudentsJobsInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentAdditionMapper {
    StudentAdditionDto studentReqToStudentAdditionDto(StudentAdditionReq studentAdditionReq);

    StudentInfoEntity studentAdditionDtoToStudentInfoEntity(StudentAdditionDto studentAdditionDto);

    StudentAdditionDto studentInfoEntityToStudentAdditionDto(StudentInfoEntity studentInfoEntity);


    StudentsRes studentAdditionDtoToStudentsRes(StudentAdditionDto studentAdditionDto);


    StudentsJobsInfoRes studentsJobsInfoDtoToStudentsJobsInfoRes(StudentsJobsInfoDto studentsJobsInfoDto);
}
