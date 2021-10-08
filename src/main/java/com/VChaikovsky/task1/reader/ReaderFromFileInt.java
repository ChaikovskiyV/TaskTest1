package com.VChaikovsky.task1.reader;

import com.VChaikovsky.task1.exception.WrongDataException;

public interface ReaderFromFileInt {
    String readText(String filePath) throws WrongDataException;
}
