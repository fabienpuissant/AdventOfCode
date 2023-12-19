package org.advent.code.day.five;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayFive {

    private static final String SEED_REGEX = "seeds";

    public static Double solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        var seeds = getSeeds(lines);
        var seedLocations = getSeedLocations(seeds, lines);
        return Collections.min(seedLocations);
    }

    public static List<Double> getSeedLocations(List<Seed> seeds, List<String> lines) {
        seeds.forEach(seed -> {
            fillSeedWithValues(lines, seed);
        });
        return seeds.stream().map(Seed::getLocationId).toList();
    }

    public static void fillSeedWithValues(List<String> lines, Seed seed) {
        seed.setSoilId(convertIdFromConversionMap(seed.getSeedId(), getMapOfConversionType(ConversionType.SEED_TO_SOIL, lines)));
        seed.setFertilizerId(convertIdFromConversionMap(seed.getSoilId(), getMapOfConversionType(ConversionType.SOIL_TO_FERTILIZER, lines)));
        seed.setWaterId(convertIdFromConversionMap(seed.getFertilizerId(), getMapOfConversionType(ConversionType.FERTILIZER_TO_WATER, lines)));
        seed.setLightId(convertIdFromConversionMap(seed.getWaterId(), getMapOfConversionType(ConversionType.WATER_TO_LIGHT, lines)));
        seed.setTemperatureId(convertIdFromConversionMap(seed.getLightId(), getMapOfConversionType(ConversionType.LIGHT_TO_TEMPERATURE, lines)));
        seed.setHumidityId(convertIdFromConversionMap(seed.getTemperatureId(), getMapOfConversionType(ConversionType.TEMPERATURE_TO_HUMIDITY, lines)));
        seed.setLocationId(convertIdFromConversionMap(seed.getHumidityId(), getMapOfConversionType(ConversionType.HUMIDITY_TO_LOCATION, lines)));
    }

    public static List<Seed> getSeeds(List<String> lines) {
        return getSeedNumbers(lines).stream().map(Seed::new).toList();
    }

    public static List<Double> getSeedNumbers(List<String> lines) {
        var seedLine = lines.stream().filter(line -> line.contains(SEED_REGEX)).findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find seeds in the puzzle"));
        return Utils.getAllNumbersFromString(seedLine);
    }

    public static List<MapItem> getMapOfConversionType(ConversionType conversionType, List<String> lines) {
        var mapItems = new ArrayList<MapItem>();
        var lineIndex = getConversionLineIndex(conversionType, lines);
        while (lineIndex + 1 < lines.size()) {
            var numbers = Utils.getAllNumbersFromString(lines.get(lineIndex + 1));
            if (numbers.isEmpty()) break;
            if (numbers.size() != 3)
                throw new RuntimeException(String.format("Error while getting conversion map '%s' at line '%s'; did not find 3 numbers", conversionType.label, lineIndex + 1));
            mapItems.add(new MapItem(numbers.get(0), numbers.get(1), numbers.get(2)));
            lineIndex++;
        }
        return mapItems;
    }

    private static int getConversionLineIndex(ConversionType conversionType, List<String> lines) {
        var lineIndex = -1;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(conversionType.label)) {
                lineIndex = i;
            }
        }
        if (lineIndex == -1)
            throw new RuntimeException(String.format("Cannot find conversion map '%s'", conversionType.label));
        return lineIndex;
    }

    public static double convertIdFromConversionMap(double idToConvert, List<MapItem> conversionMap) {
        var convertLine = conversionMap.stream().filter(convert -> idToConvert >= convert.getSourceRangeStart() &&
                idToConvert < convert.getSourceRangeStart() + convert.getRangeLength()).findFirst();
        if (convertLine.isEmpty()) return idToConvert;
        var idInRange = idToConvert - convertLine.get().getSourceRangeStart();
        return convertLine.get().getDestinationRangeStart() + idInRange;
    }

}
