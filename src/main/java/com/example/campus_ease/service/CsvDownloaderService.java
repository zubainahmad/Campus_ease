package com.example.campus_ease.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public interface CsvDownloaderService {
    void generateCSVFile(HttpServletResponse response) throws IOException;

    void generateRegisteredCsvFile(ArrayList<Long> id, HttpServletResponse response) throws IOException;

    void generateUnRegisteredCsvFile(ArrayList<Long> id, HttpServletResponse response) throws IOException;

    void generateAllCSVFile(ArrayList<Long> id, HttpServletResponse response) throws IOException;
}
