package org.advent.code.day.four;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.List;

public class DayFour {

    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        return lines.stream().mapToInt(DayFour::getValueOfLine).sum();
    }

    public static Integer getValueOfLine(String line) {
        var numberOfMatch = getNumberOfMatch(line);
        return (int) Math.pow(2, numberOfMatch - 1);
    }

    public static Integer getNumberOfMatch(String line) {
        var winningNumbers = getWinningNumbers(line);
        var playerNumbers = getPlayerNumbers(line);
        var numberOfMatch = getNumberOfMatch(winningNumbers, playerNumbers);
        if (numberOfMatch == null) return 0;
        return numberOfMatch;
    }

    private static Integer getNumberOfMatch(List<Double> winningNumbers, List<Double> playerNumbers) {
        var numberOfMatch = 0;
        for(var winningNumber: winningNumbers) {
            if(playerNumbers.contains(winningNumber)) numberOfMatch++;
        }
        if(numberOfMatch == 0) return null;
        return numberOfMatch;
    }

    public static List<Double> getWinningNumbers(String line) {
        var numbers = line.substring(line.indexOf(":") + 1, line.indexOf("|"));
        return Utils.getAllNumbersFromString(numbers);
    }

    public static List<Double> getPlayerNumbers(String line) {
        var numbers = line.substring(line.indexOf("|"));
        return Utils.getAllNumbersFromString(numbers);
    }



}
