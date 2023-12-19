package org.advent.code.day.six;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaySix {
    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        var times = getAllRaceTimes(lines);
        var distances = getAllRaceDistances(lines);
        List<Integer> winningPossibilities = new ArrayList<>();
        for(var i = 0; i < times.size(); i++) {
            winningPossibilities.add(getWinningPossibilitiesForRace(times.get(i), distances.get(i)));
        }
        return winningPossibilities.stream().reduce(1, (a, b) -> a * b);
    }

    public static Integer getWinningPossibilitiesForRace(Double time, Double distance) {
        var possibilities = new ArrayList<Integer>();
        for(var timeToPress = 0; timeToPress < time; timeToPress++) {
            if(timeToPress * (time - timeToPress) > distance) {
                possibilities.add(timeToPress);
            }
        }
        return possibilities.size();
    }


    public static List<Double> getAllRaceTimes(List<String> lines) {
        return Utils.getAllNumbersFromString(lines.getFirst());
    }

    public static List<Double> getAllRaceDistances(List<String> lines) {
        return Utils.getAllNumbersFromString(lines.getLast());
    }

}
