package com.VChaikovsky.task1.main;

import com.VChaikovsky.task1.entity.TextEntity;
import com.VChaikovsky.task1.exception.WrongDataException;
import com.VChaikovsky.task1.reader.impl.ReaderFromFile;
import com.VChaikovsky.task1.redactor.impl.TextRedactor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainTask1 {
    final static Logger logger = LogManager.getLogger();
    public final static String FILE_PATH = "sources/textfile.txt";

    public static void main(String[] args) throws WrongDataException {
        String dataFromFile = new ReaderFromFile().readText(FILE_PATH);
        TextEntity textEntity = new TextEntity(dataFromFile);
        String correctedText = new TextRedactor().redactText(textEntity.getText());

        logger.info("The source text is:\n"+dataFromFile+"\n" +
                "---------------------------------\n" +
                "The corrected text is:\n"+correctedText);
    }
}