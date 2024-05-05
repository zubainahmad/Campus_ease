package com.example.campus_ease.management;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface CsvDownloaderManagement {

    void generateCSVFile(HttpServletResponse response) throws IOException;

}
