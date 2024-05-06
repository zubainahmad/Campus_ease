package com.example.campus_ease.management;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public interface CsvDownloaderManagement {

    void generateCSVFile(HttpServletResponse response) throws IOException;

    void generateRegisteredCSVFile(ArrayList<Long> id,HttpServletResponse response) throws IOException;

    void generateUnRegisteredCSVFile(ArrayList<Long> id, HttpServletResponse response) throws IOException;

    void generateAllCSVFile(ArrayList<Long> id, HttpServletResponse response) throws IOException;
}
