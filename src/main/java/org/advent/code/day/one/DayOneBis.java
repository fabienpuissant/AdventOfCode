package org.advent.code.day.one;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayOneBis {

    private static final Map<String, String> literalDigits = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9");

    public static Integer solvePuzzle(String filename) throws IOException {
        List<String> lines = Utils.getLinesFromFile(filename);
        return lines.stream().mapToInt(DayOneBis::extractCodeFromLine).sum();
    }

    public static Integer extractCodeFromLine(String s) {
        var convertedLiteralDigit = convertLiteralDigits(s);
        return DayOne.extractCodeFromLine(convertedLiteralDigit);
    }

    public static String convertLiteralDigits(String s) {
        Map<Integer, String> mapOfIntegerToInsert = new TreeMap<>();

        //Find all literals
        for (Map.Entry<String, String> entry : literalDigits.entrySet()) {
            Pattern pattern = Pattern.compile(entry.getKey());
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                mapOfIntegerToInsert.put(matcher.start(), entry.getValue());
            }
        }

        //Find all numbers
        for(String numberString : literalDigits.values()) {
            Pattern pattern = Pattern.compile(numberString);
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                mapOfIntegerToInsert.put(matcher.start(), numberString);
            }
        }
        return concatenateValues(mapOfIntegerToInsert);
    }

    private static String concatenateValues(Map<Integer, String> map) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.append(entry.getValue());
        }
        return result.toString();
    }

}
