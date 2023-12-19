package org.advent.code.day.six;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaySixBis {

    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        var aggregatedTime = Utils.getAggregatedNumbersFromString(lines.getFirst());
        var aggregatedDistance = Utils.getAggregatedNumbersFromString(lines.getLast());
        return DaySix.getWinningPossibilitiesForRace(aggregatedTime, aggregatedDistance);
    }

}
