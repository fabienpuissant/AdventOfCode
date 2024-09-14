package org.advent.code.day.height;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.*;

public class DayHeight {


    private static final String PATH_SEPARATOR = "=";
    private static final char LEFT_SEPARATOR = 40;
    private static final char RIGHT_SEPARATOR = 41;
    private static final char MIDDLE_SEPARATOR = 44;

    public static int solvePuzzle(String fileName) throws IOException {

        List<String> lines = Utils.getLinesFromFile(fileName);
        List<Direction> directions = extractDirections(lines);
        Map<String, List<String>> path = extractPath(lines);
        List<String> currentPath = path.get("AAA");
        int pathIteration = 0;
        int counter = 0;
        boolean end = false;

        while (!end) {
            if(pathIteration >= directions.size()) pathIteration = 0;
            Direction direction = directions.get(pathIteration);
            pathIteration++;

            if(currentPath.get(direction.ordinal()).equals("ZZZ")){
                end = true;
            }
            currentPath = path.get(currentPath.get(direction.ordinal()));
            counter++;
        }

        return counter;

    }

    public static Map<String, List<String>> extractPath(List<String> lines) {
        List<String> linesToParse = lines.stream().dropWhile(line -> !line.isBlank()).skip(1).toList();
        Map<String, List<String>> result = new HashMap<>();
        linesToParse.forEach(line -> {
            var content = line.split(PATH_SEPARATOR);
            var key = Arrays.stream(content).findFirst().orElseThrow().strip();
            var left = Arrays.stream(Arrays.stream(content).skip(1).findFirst().orElseThrow().split(""))
                    .dropWhile(ch -> !Objects.equals(ch.charAt(0), LEFT_SEPARATOR))
                    .skip(1)
                    .takeWhile(ch -> !Objects.equals(ch.charAt(0), MIDDLE_SEPARATOR))
                    .reduce("", (acc, ch) -> acc + ch).strip();
            var right = Arrays.stream(Arrays.stream(content).skip(1).findFirst().orElseThrow().split(""))
                    .dropWhile(ch -> !Objects.equals(ch.charAt(0), MIDDLE_SEPARATOR))
                    .skip(1)
                    .takeWhile(ch -> !Objects.equals(ch.charAt(0), RIGHT_SEPARATOR))
                    .reduce("", (acc, ch) -> acc + ch).strip();
            result.put(key, List.of(left, right));
        });
        return result;

    }

    public static List<Direction> extractDirections(List<String> lines) {
        List<String> linesToParse = lines.stream().takeWhile(line -> !line.isBlank()).toList();
        String pattern = linesToParse.stream().reduce("", String::concat);
        return pattern.chars().mapToObj(ch -> {
            return switch (ch) {
                case 'R' -> Direction.RIGHT;
                case 'L' -> Direction.LEFT;
                default -> null;
            };
        }).filter(Objects::nonNull).toList();
    }

}