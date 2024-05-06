package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.CsvDownloaderManagement;
import com.example.campus_ease.service.CsvDownloaderService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Transactional
@Component
public class CsvDownloaderManagementImpl implements CsvDownloaderManagement {
    private final CsvDownloaderService csvDownloaderService;

    public CsvDownloaderManagementImpl(CsvDownloaderService csvDownloaderService) {
        this.csvDownloaderService = csvDownloaderService;
    }

    @Override
    public void generateCSVFile(HttpServletResponse response) throws IOException {
        csvDownloaderService.generateCSVFile(response);
    }

    @Override
    public void generateRegisteredCSVFile(ArrayList<Long> id, HttpServletResponse response) throws IOException {
        csvDownloaderService.generateRegisteredCsvFile(id, response);
    }

    @Override
    public void generateUnRegisteredCSVFile(ArrayList<Long> id, HttpServletResponse response) throws IOException {
        csvDownloaderService.generateUnRegisteredCsvFile(id, response);
    }

    @Override
    public void generateAllCSVFile(ArrayList<Long> id, HttpServletResponse response) throws IOException {
        csvDownloaderService.generateAllCSVFile(id,response);
    }
}
