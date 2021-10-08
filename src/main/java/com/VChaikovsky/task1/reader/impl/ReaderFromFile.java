package com.VChaikovsky.task1.reader.impl;

import com.VChaikovsky.task1.exception.WrongDataException;
import com.VChaikovsky.task1.reader.ReaderFromFileInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class ReaderFromFile implements ReaderFromFileInt {
    final static Logger logger = LogManager.getLogger();

    @Override
    public String readText(String filePath) throws WrongDataException {
        String text = "";
        try {
            List<String> listStrings = Files.readAllLines(Paths.get(filePath));
            for (String str : listStrings){
                text += str + "\n";
            }
        } catch (IOException e){
            logger.error("The file " + filePath + " was not found.");
            throw new WrongDataException("The file was not found", e);
        }
        return text;
    }
}