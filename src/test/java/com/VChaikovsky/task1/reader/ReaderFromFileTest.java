package com.VChaikovsky.task1.reader;

import com.VChaikovsky.task1.exception.WrongDataException;
import com.VChaikovsky.task1.reader.impl.ReaderFromFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReaderFromFileTest {
    final static Logger logger = LogManager.getLogger();
    private String filePath;
    private String expectedResult;
    private ReaderFromFile reader;

    @BeforeAll
    void setUp() {
        logger.info("Testing is starting...");
        filePath = "sources/testfile.txt";
        reader = new ReaderFromFile();
        expectedResult = "Hello my friends!\nLet have fun!\n";
    }

    @AfterAll
    void tearDown() {
        logger.info("The tests have been finished.");
    }

    @Test
   public void readText() throws WrongDataException {
        String result = reader.readText(filePath);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ifFileNotFound(){
        String notExistedPath = "_" + filePath;

        assertThrows(WrongDataException.class, ()->reader.readText(notExistedPath));
    }
}