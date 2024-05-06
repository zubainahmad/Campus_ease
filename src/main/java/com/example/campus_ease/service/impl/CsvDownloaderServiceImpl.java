package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.StudentInfoRepo;
import com.example.campus_ease.entity.StudentInfoEntity;
import com.example.campus_ease.service.CsvDownloaderService;
import com.example.campus_ease.service.StudentAdditionService;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CsvDownloaderServiceImpl implements CsvDownloaderService {

    private final StudentInfoRepo studentInfoRepo;

    private final StudentAdditionService studentAdditionService;

    public CsvDownloaderServiceImpl(StudentInfoRepo studentInfoRepo, StudentAdditionService studentAdditionService) {
        this.studentInfoRepo = studentInfoRepo;
        this.studentAdditionService = studentAdditionService;
    }

    @Override
    public void generateCSVFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=filename" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<StudentInfoEntity> list_dto = studentInfoRepo.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        // provide the column name as per the requiremnt (which you want to displayin CSV file)
        String[] csvHeader = {"user_id","first_name","last_name","roll_number","college_admission","email","token_id","branch_id","sgpa","percentage","image_url","unknown"};
        // actual field name that DTO_Class contains (*make sure the name mapping should be correct)
        String[] nameMapping = {"userId","firstName","lastName","rollNumber","collegeAdmissionNumber","email","tokenId","branchId","sgpa","percentage","imageUrl","unknown2"};

        csvWriter.writeHeader(csvHeader);

        for (StudentInfoEntity dtoClasss: list_dto) {
            csvWriter.write(dtoClasss, nameMapping);
        }
        csvWriter.close();


    }

    @Override
    public void generateRegisteredCsvFile(ArrayList<Long> id, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=filename" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<StudentAdditionDto> res = studentAdditionService.getRegisteredStudents(id);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"BranchId","CollegeAdmissionNumber","Email","FirstName","LastName","Percentage","RollNumber","Sgpa","ImageUrl"};
        String [] nameMapping = {"branchId","collegeAdmissionNumber","email","firstName","lastName","percentage","rollNumber","sgpa","imageUrl"};

        csvWriter.writeHeader(csvHeader);

        for(StudentAdditionDto dto : res)
        {
            csvWriter.write(dto, nameMapping);
        }

        csvWriter.close();
    }

    @Override
    public void generateUnRegisteredCsvFile(ArrayList<Long> id, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=filename" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<StudentAdditionDto> res = studentAdditionService.getUnregisteredStudents(id);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"BranchId","CollegeAdmissionNumber","Email","FirstName","LastName","Percentage","RollNumber","Sgpa","ImageUrl"};
        String [] nameMapping = {"branchId","collegeAdmissionNumber","email","firstName","lastName","percentage","rollNumber","sgpa","imageUrl"};

        csvWriter.writeHeader(csvHeader);

        for(StudentAdditionDto dto : res)
        {
            csvWriter.write(dto, nameMapping);
        }

        csvWriter.close();
    }

    @Override
    public void generateAllCSVFile(ArrayList<Long> id, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=filename" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<StudentAdditionDto> res = studentAdditionService.getAllStudents(id);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"BranchId","CollegeAdmissionNumber","Email","FirstName","LastName","Percentage","RollNumber","Sgpa","ImageUrl"};
        String [] nameMapping = {"branchId","collegeAdmissionNumber","email","firstName","lastName","percentage","rollNumber","sgpa","imageUrl"};

        csvWriter.writeHeader(csvHeader);

        for(StudentAdditionDto dto : res)
        {
            csvWriter.write(dto, nameMapping);
        }

        csvWriter.close();
    }


}
