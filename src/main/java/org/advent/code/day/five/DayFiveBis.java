package org.advent.code.day.five;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.advent.code.day.five.DayFive.convertIdFromConversionMap;
import static org.advent.code.day.five.DayFive.getMapOfConversionType;

public class DayFiveBis {

    public static Double solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        return getMinSeedsLocation(lines);
    }

    public static Double getMinSeedsLocation(List<String> lines) {
        var numbersInFirstLine = DayFive.getSeeds(lines);
        List<List<Seed>> groupedSeeds = new ArrayList<>();
        for (int i = 0; i < numbersInFirstLine.size(); i += 2) {
            List<Seed> group = new ArrayList<>();
            group.add(numbersInFirstLine.get(i));
            if (i + 1 < numbersInFirstLine.size()) {
                group.add(numbersInFirstLine.get(i + 1));
            }
            groupedSeeds.add(group);
        }

        var minimumLocation = Double.MAX_VALUE;
        for (var seedGrouped: groupedSeeds) {
            var startSeed = seedGrouped.get(0);
            var rangeNumber = seedGrouped.get(1);
            System.out.println(String.format("Seed group : startSeed: %s, range: %s", startSeed, rangeNumber));
            for(var i = startSeed.getSeedId(); i < startSeed.getSeedId() + rangeNumber.getSeedId(); i++) {
                var seed = new Seed(i);
                DayFive.fillSeedWithValues(lines, seed);
                if(seed.getLocationId() < minimumLocation) minimumLocation = seed.getLocationId();
            }
        }
        return minimumLocation;
    }

}
