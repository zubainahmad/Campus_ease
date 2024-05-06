package com.example.campus_ease.controller;

import com.example.campus_ease.management.CsvDownloaderManagement;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

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

    @GetMapping("/download/registered")
    public void generateRegisteredCSV(@RequestParam ArrayList<Long> id, HttpServletResponse response) throws IOException {
        csvDownloaderManagement.generateRegisteredCSVFile(id , response);
        System.out.println("Registered CSV generated");
    }


    @GetMapping("/download/unregistered")
    public void generateUnRegisteredCSV(@RequestParam ArrayList<Long> id, HttpServletResponse response) throws IOException {
        csvDownloaderManagement.generateUnRegisteredCSVFile(id , response);
        System.out.println("Unregistered CSV generated");
    }

    @GetMapping("/download/all")
    public void generateAllCSV(@RequestParam ArrayList<Long> id, HttpServletResponse response) throws IOException {
        csvDownloaderManagement.generateAllCSVFile(id , response);
        System.out.println("All CSV generated");
    }

}
