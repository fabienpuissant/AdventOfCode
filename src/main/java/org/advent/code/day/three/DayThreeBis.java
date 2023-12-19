package org.advent.code.day.three;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.*;

public class DayThreeBis {

    private static final Character STAR = '*';

    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        var mapOfIntegerToValidate = DayThree.getNumbersMap(lines);
        var mapsOfStars = getStarsMap(lines);
        var gears = findGears(mapsOfStars, mapOfIntegerToValidate, lines);
        return gears.stream().reduce(0, Integer::sum);
    }

    public static List<StarItem> getStarsMap(List<String> lines) {
        var starMap = new ArrayList<StarItem>();
        for (var lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            var line = lines.get(lineIndex);
            for (var characterIndex = 0; characterIndex < line.length(); characterIndex++) {
                if (line.charAt(characterIndex) == STAR) {
                    starMap.add(new StarItem(lineIndex, characterIndex));
                }
            }
        }
        return starMap;
    }

    public static List<Integer> findGears(List<StarItem> starItems, Map<LineWithValue, List<Integer>> mapOfIntegerToValidate, List<String> lines) {
        List<Integer> gears = new ArrayList<>();
        for (var starItem : starItems) {
            var starLine = starItem.getLineIndex();
            var starIndex = starItem.getStarIndex();
            var filterMapOfIntegerByLine = mapOfIntegerToValidate.entrySet().stream().filter(en ->
                    filterMapToGetAllNumbersAround(en, starLine, starIndex, lines)
            ).toList();
            if(filterMapOfIntegerByLine.size() == 2) {
                gears.add(filterMapOfIntegerByLine.get(0).getKey().getValue() * filterMapOfIntegerByLine.get(1).getKey().getValue());
            }
        }
        return gears;
    }

    private static boolean filterMapToGetAllNumbersAround(Map.Entry<LineWithValue, List<Integer>> entry, Integer starLine, Integer starIndex, List<String> lines) {
        //If on the same line check if number is on the left or on the right
        if(entry.getKey().getLineIndex().equals(starLine)) {
            if(entry.getValue().contains(starIndex - 1) || entry.getValue().contains(starIndex + 1)) return true;
        }
        var leftIndexAfter = Collections.min(entry.getValue()) - 1;
        var rightIndexAfter = Collections.max(entry.getValue()) + 1;
        //If not the last line, check line below
        if(starLine < lines.size()) {
            if(entry.getKey().getLineIndex().equals(starLine + 1)) {
                if(entry.getValue().stream().anyMatch(indexOfNumber -> Math.abs(indexOfNumber - starIndex) < 1)) return true;
                if(Math.abs(leftIndexAfter - starIndex) < 1) return true;
                return Math.abs(rightIndexAfter - starIndex) < 1;
            }
        }
        //If not the first line, check line below
        if(starLine > 0) {
            if(entry.getKey().getLineIndex().equals(starLine - 1)) {
                if(entry.getValue().stream().anyMatch(indexOfNumber -> Math.abs(indexOfNumber - starIndex) < 1)) return true;
                if(Math.abs(leftIndexAfter - starIndex) < 1) return true;
                return Math.abs(rightIndexAfter - starIndex) < 1;
            }
        }
        return false;
    }


}
