package org.advent.code.day.two;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.advent.code.day.two.DayTwo.extractGameItem;

public class DayTwoBis {

    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        return lines.stream().mapToInt(DayTwoBis::getPowerOfSet).sum();
    }

    public static Integer getPowerOfSet(String input) {
        var gameItem = extractGameItem(input);
        return Collections.max(gameItem.getRedCubes()) * Collections.max(gameItem.getGreenCubes()) * Collections.max(gameItem.getBlueCubes());
    }

}
