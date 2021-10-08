package com.VChaikovsky.task1.redactor;

import com.VChaikovsky.task1.redactor.impl.TextRedactor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TextRedactorTest {
final static Logger logger = LogManager.getLogger();
private TextRedactor redactor;
private String sourceString;
private String expectedResult;

    @BeforeAll
    void prepare() {
        logger.info("Testing is starting...");
        redactor = new TextRedactor();
        sourceString = "Most of people have different tastes especially if it relates with food." +
                "Some of them join cheese with butter or a chicken with sauce and coffee with hot pepper" +
                "or an apple with honey are the most delicious for others.";
    }

    @AfterAll
    void tearDown() {
        logger.info("The tests have been finished.");
    }

    @Test
    public void redactText() {
        expectedResult = "Most of peopl hav diferent tastes espesialy if it relates with fud." +
                "Som of them join khis with buter or khiken with saus and kofi with hot peper" +
                "or apl with honey ar most delisious for others.";
        String result = redactor.redactText(sourceString);

        assertEquals(expectedResult, result);
    }

    @Test
    public void removeC() {
        expectedResult = "Most of people have different tastes espesially if it relates with food." +
                "Some of them join kheese with butter or a khiken with sause and koffee with hot pepper" +
                "or an apple with honey are the most delisious for others.";
        String result = redactor.removeC(sourceString);

        assertEquals(expectedResult, result);
    }

    @Test
    public void removeDoubleLetters() {
        expectedResult = "Most of people have diferent tastes especialy if it relates with fud." +
                "Some of them join chise with buter or a chicken with sauce and cofi with hot peper" +
                "or an aple with honey are the most delicious for others.";
        String result = redactor.removeDoubleLetters(sourceString);

        assertEquals(expectedResult, result);
    }

    @Test
    public void removeEAtWordEnd() {
        expectedResult = "Most of peopl hav different tastes especially if it relates with food." +
                "Som of them join chees with butter or a chicken with sauc and coffe with hot pepper" +
                "or an appl with honey ar th most delicious for others.";
        String result = redactor.removeEAtWordEnd(sourceString);

        assertEquals(expectedResult, result);
    }

    @Test
    public void removeArticle() {
        expectedResult = "Most of people have different tastes especially if it relates with food." +
                "Some of them join cheese with butter or chicken with sauce and coffee with hot pepper" +
                "or apple with honey are most delicious for others.";
        String result = redactor.removeArticle(sourceString);

        assertEquals(expectedResult, result);
    }
}