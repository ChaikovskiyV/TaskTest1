package com.VChaikovsky.task1.redactor.impl;

import com.VChaikovsky.task1.redactor.TextRedactorInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextRedactor implements TextRedactorInt {
    final static Logger logger = LogManager.getLogger();
    private final String DELIMITER = "\\s";

    @Override
    public String redactText(String sourceText) {
        String correctedText = "";

        if(!sourceText.isEmpty()){
            String afterRemovingC = removeC(sourceText);
            String afterRemovingDoubleLetters = removeDoubleLetters(afterRemovingC);
            String afterRemovingE = removeEAtWordEnd(afterRemovingDoubleLetters);
            correctedText = removeArticle(sourceText, afterRemovingE);
        } else {
            logger.info("The string is empty.");
        }
        return correctedText;
    }

    public String removeC(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
            for (int i = 0, j = i + 1; i < stringBuilder.length() && j < stringBuilder.length() &&
                    stringBuilder.indexOf("c") >= 0; i++, j++) {
                if(stringBuilder.charAt(i) == 'c'){
                    if(stringBuilder.charAt(j) == 'e' || stringBuilder.charAt(j) == 'i') {
                        stringBuilder.setCharAt(i, 's');
                    }else if(stringBuilder.charAt(j) == 'k') {
                        stringBuilder.deleteCharAt(i);
                    } else {
                        stringBuilder.setCharAt(i, 'k');
                    }
                }
            }
        return stringBuilder.toString();
    }

    public String removeDoubleLetters(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0, j = i + 1; i < stringBuilder.length() && j < stringBuilder.length(); i++, j++) {
            if(stringBuilder.charAt(i) == stringBuilder.charAt(j)){
                if(stringBuilder.charAt(i) == 'e') {
                    stringBuilder.replace(i, j + 1, "i");
                } else if(stringBuilder.charAt(i) == 'o') {
                    stringBuilder.replace(i, j + 1, "u");
                } else {
                    stringBuilder.deleteCharAt(i);
                }
            }
        }
        return stringBuilder.toString();
    }

    public String removeEAtWordEnd(String string) {
        String[] strings = string.split(DELIMITER);
        String newString = "";
        for(String str : strings){
            if(str.length() > 1 && str.charAt(str.length()-1) == 'e'){
                str = str.substring(0, str.length() - 1);
            }
            newString += str + " ";
        }
        return newString.trim();
    }

    private String removeArticle(String sourceText, String string) {
        String[] strings = string.split(DELIMITER);
        String[] source = sourceText.split(DELIMITER);
        String newString = "";

        for (int i = 0; i < strings.length; i++) {
            if(!source[i].equals("an") && !source[i].equals("a") && !source[i].equals("the")) {
                newString += strings[i] + " ";
            }
        }
        return newString.trim();
    }

    public String removeArticle(String string){
        String[] strings = string.split(DELIMITER);
        String newString = "";

        for (int i = 0; i < strings.length; i++) {
            if(!strings[i].equals("an") && !strings[i].equals("a") && !strings[i].equals("the")) {
                newString += strings[i] + " ";
            }
        }
        return newString.trim();
    }
}