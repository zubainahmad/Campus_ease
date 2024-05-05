package com.example.campus_ease.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface CsvDownloaderService {
    void generateCSVFile(HttpServletResponse response) throws IOException;
}
