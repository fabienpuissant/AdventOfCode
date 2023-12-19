package org.advent.code.day;

import org.advent.code.day.one.DayOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static List<String> getLinesFromFile(String fileName) throws IOException {
        List<String> result = new ArrayList<>();
        try (InputStream inputStream = DayOne.class.getClassLoader().getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int concatenateIntegers(int num1, int num2) {
        String concatenatedString = Integer.toString(num1) + Integer.toString(num2);
        return Integer.parseInt(concatenatedString);
    }

    public static List<Double> getAllNumbersFromString(String numbers) {
        numbers = numbers.replaceAll("[^0-9]+", " ");
        if(numbers.isEmpty()) return Collections.emptyList();
        return Stream.of(numbers.trim().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public static Double getAggregatedNumbersFromString(String numbers) {
        return Double.parseDouble(numbers.replaceAll("[^0-9]+", ""));
    }

}
