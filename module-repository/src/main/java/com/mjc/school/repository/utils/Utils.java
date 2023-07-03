package com.mjc.school.repository.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private Utils(){}

    public static List<String> readFile(String fileName) {
        Utils app = new Utils();
        List<String> lines = new ArrayList<>();
        InputStream stream = app.getClass().getClassLoader().getResourceAsStream(fileName);
        if (stream == null){
            throw new IllegalArgumentException("File not found.");
        }
        try( InputStreamReader streamReader = new InputStreamReader(stream);
             BufferedReader reader = new BufferedReader(streamReader))
        {
             lines = reader.lines().toList();
        } catch (IOException e){
            System.out.println("Unable to read from file.");
            e.printStackTrace();
        }
        return lines;
    }

}
