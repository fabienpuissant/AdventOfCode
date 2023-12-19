package org.advent.code.day.two;

import org.advent.code.day.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwo {

    private static final Integer MAX_RED_CUBES = 12;
    private static final Integer MAX_GREEN_CUBES = 13;
    private static final Integer MAX_BLUE_CUBES = 14;
    private static final String GAME_REGEX = "Game";
    private static final String RED_REGEX = "red";
    private static final String GREEN_REGEX = "green";
    private static final String BLUE_REGEX = "blue";

    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        return lines.stream().mapToInt(DayTwo::getIdIfGamePossibleOrElseZero).sum();
    }

    public static Integer getIdIfGamePossibleOrElseZero(String s) {
        var gameItem = extractGameItem(s);
        if(isCubesValidForGame(gameItem.getRedCubes(), MAX_RED_CUBES)
                && isCubesValidForGame(gameItem.getGreenCubes(), MAX_GREEN_CUBES)
                && isCubesValidForGame(gameItem.getBlueCubes(), MAX_BLUE_CUBES)) {
            return gameItem.getId();
        }
        return 0;
    }

    public static boolean isCubesValidForGame(List<Integer> cubes, Integer maximumCube) {
        return cubes.stream().filter(cube -> cube > maximumCube).findAny().isEmpty();
    }

    public static GameItem extractGameItem(String input) {
        var gameItem = new GameItem();
        gameItem.setId(getGameId(input));
        gameItem.setRedCubes(getListOfCubesByColor(input, RED_REGEX));
        gameItem.setGreenCubes(getListOfCubesByColor(input, GREEN_REGEX));
        gameItem.setBlueCubes(getListOfCubesByColor(input, BLUE_REGEX));
        return gameItem;
    }

    public static List<Integer> getListOfCubesByColor(String input, String redRegex) {
        List<Integer> foundCubes = new ArrayList<>();
        Pattern pattern = Pattern.compile(redRegex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            foundCubes.add(parseCubeNumberFromStringAtIndex(input, matcher.start() - 2));
        }
        return foundCubes;
    }

    public static Integer getGameId(String input) {
        Pattern pattern = Pattern.compile(GAME_REGEX);
        Matcher matcher = pattern.matcher(input);
        var gameFound = matcher.find();
        if(gameFound) {
            return parseIdFromStringAtIndex(input, matcher.end() + 1);
        }
        throw new RuntimeException(String.format("Cannot find Game id in : '%s'", input));
    }

    public static Integer parseIdFromStringAtIndex(String input, Integer index) {
        var isDigit = true;
        var numberFound = new StringBuilder();
        while (isDigit) {
            if(Character.isDigit(input.charAt(index))) {
                numberFound.append(input.charAt(index));
                index++;
            } else {
                isDigit = false;
            }
        }
        return Integer.parseInt(numberFound.toString());
    }

    public static Integer parseCubeNumberFromStringAtIndex(String input, Integer index) {
        var isDigit = true;
        var numberFound = new StringBuilder();
        while (isDigit) {
            if(Character.isDigit(input.charAt(index))) {
                numberFound.insert(0, input.charAt(index));
                index--;
            } else {
                isDigit = false;
            }
        }
        return Integer.parseInt(numberFound.toString());
    }

}
