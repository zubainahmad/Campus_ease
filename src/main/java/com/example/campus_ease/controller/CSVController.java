package com.example.campus_ease.controller;

import com.example.campus_ease.management.CsvDownloaderManagement;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
public class CSVController {
    private final CsvDownloaderManagement csvDownloaderManagement;



    public CSVController(CsvDownloaderManagement csvDownloaderManagement) {
        this.csvDownloaderManagement = csvDownloaderManagement;
    }

    @GetMapping("/download")
    public void generateCSV(HttpServletResponse response) throws IOException {
        csvDownloaderManagement.generateCSVFile(response);
        System.out.println("CSV generated");
    }
}
