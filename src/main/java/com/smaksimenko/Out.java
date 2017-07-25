package com.smaksimenko;

import com.smaksimenko.entities.Army;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Out {
    List<String> listOfLog = new LinkedList<>();

    public void log(String text) {
        System.out.println(text);
        listOfLog.add(text);
    }

    //write to file
    public void logToFile(Army army1, Army army2) {
        File fileName = new File(army1.getRace() + " vs " + army2.getRace() + ".txt");
        int i = 0;
        //if file exists, then rename file
        while (fileName.exists()) {
            fileName.renameTo(new File(fileName.getName().replace(".txt", i++ + ".txt")));
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : listOfLog) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
