package com.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFiles {
    public static String[] readFile (String filename) {
        Path filePath = Paths.get(filename);
        String[] stringLines = new String[0];
        try {
            List<String> allLines = Files.readAllLines(filePath);
            //String[] stringArray = list.toArray(new String[0]);
            stringLines =  allLines.toArray(new String[0]);
            return stringLines;
        } catch (IOException e) {
            System.out.println("Błąd! Nie znaleziono pliku! ");
            e.printStackTrace();
        }
        return stringLines;
    }
    public static void saveToFile (String[] lines, String filename) {
        Path filePath = Paths.get(filename);
        List<String> linesToSave = Arrays.asList(lines);

        try {
            Files.write(filePath, linesToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
