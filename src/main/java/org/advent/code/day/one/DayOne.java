package org.advent.code.day.one;

import org.advent.code.day.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DayOne {

    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        return lines.stream().mapToInt(DayOne::extractCodeFromLine).sum();
    }

    public static Integer extractCodeFromLine(String s) {
        var digits = parseDigits(s);
        if(digits.isEmpty()) throw new RuntimeException(String.format("File contains a line without any digit : '%s'", s));
        if(digits.size() == 1) {
            return Utils.concatenateIntegers(digits.getFirst(), digits.getFirst());
        }
        return Utils.concatenateIntegers(digits.getFirst(), digits.getLast());
    }

    public static List<Integer> parseDigits(String s) {
        List<Integer> digits = new ArrayList<>();
        for (byte character: s.getBytes()) {
            if(Character.isDigit(character)) digits.add(Character.getNumericValue(character));
        }
        return digits;
    }

}
