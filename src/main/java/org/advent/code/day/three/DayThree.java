package org.advent.code.day.three;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.*;

public class DayThree {

    private static final Character NOT_VALID_REGEX = '.';

    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        var mapOfIntegerToValidate = getNumbersMap(lines);
        List<Integer> validNumbers = validateNumbers(mapOfIntegerToValidate, lines);
        return validNumbers.stream().reduce(0, Integer::sum);
    }

    public static List<Integer> validateNumbers(Map<LineWithValue, List<Integer>> mapOfIntegerToValidate, List<String> lines) {
        List<Integer> validNumbers = new ArrayList<>();
        for (var entry : mapOfIntegerToValidate.entrySet()) {
            var isValidForCurrentLine = isNumberValidOnCurrentLine(entry.getValue(), lines.get(entry.getKey().getLineIndex()));
            var isValidForPreviousLine = false;
            if(entry.getKey().getLineIndex() > 0) {
                isValidForPreviousLine = isNumberValidOnOtherLine(entry.getValue(), lines.get(entry.getKey().getLineIndex() - 1));
            }
            var isValidForNextLine = false;
            if(entry.getKey().getLineIndex() + 1 < lines.size()) {
                isValidForNextLine = isNumberValidOnOtherLine(entry.getValue(), lines.get(entry.getKey().getLineIndex() + 1));
            }
            if(isValidForCurrentLine || isValidForNextLine || isValidForPreviousLine) {
                validNumbers.add(entry.getKey().getValue());
            }
        }
        return validNumbers;
    }

    public static boolean isNumberValidOnCurrentLine(List<Integer> indexToCheck, String lineToValidate) {
        //One number
        if(indexToCheck.size() == 1) {
            var index = indexToCheck.getFirst();
            //Validate left side
            if(index > 0 && isCharacterValidatingNumber(lineToValidate.charAt(index - 1))) return true;
            //Validate right side
            return index + 1 < lineToValidate.length() && isCharacterValidatingNumber(lineToValidate.charAt(index + 1));
        }

        //Multiple numbers
        var leftIndex = Collections.min(indexToCheck);
        var rightIndex = Collections.max(indexToCheck);
        if(leftIndex > 0 && isCharacterValidatingNumber(lineToValidate.charAt(leftIndex - 1))) return true;
        return rightIndex + 1 < lineToValidate.length() && isCharacterValidatingNumber(lineToValidate.charAt(rightIndex + 1));
    }

    public static boolean isNumberValidOnOtherLine(List<Integer> indexToCheck, String lineToValidate) {
        var leftIndexBefore = Collections.min(indexToCheck) - 1;
        var rightIndexAfter = Collections.max(indexToCheck) + 1;
        for(var index: indexToCheck) {
            if(isCharacterValidatingNumber(lineToValidate.charAt(index))) return true;
        }
        if(leftIndexBefore >= 0 && isCharacterValidatingNumber(lineToValidate.charAt(leftIndexBefore))) return true;
        return rightIndexAfter < lineToValidate.length() && isCharacterValidatingNumber(lineToValidate.charAt(rightIndexAfter));
    }

    public static Map<LineWithValue, List<Integer>> getNumbersMap(List<String> lines) {
        //Map < Map<lineIndex, numberFound>, List<indexOfNumberFound> >
        Map<LineWithValue, List<Integer>> mapOfNumberAndIndexes = new LinkedHashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            fillMapWithLine(lines, i, mapOfNumberAndIndexes);
        }
        return mapOfNumberAndIndexes;
    }

    private static void fillMapWithLine(List<String> lines, int i, Map<LineWithValue, List<Integer>> mapOfNumberAndIndexes) {
        var line = lines.get(i);
        for(int characterIndex = 0; characterIndex < line.length(); characterIndex++) {
            if(!Character.isDigit(line.charAt(characterIndex))) {
                continue;
            } else {
                var isDigit = true;
                var indexList = new ArrayList<Integer>();
                var numberFound = new StringBuilder();
                while (isDigit && characterIndex < line.length()) {
                    if(Character.isDigit(line.charAt(characterIndex))) {
                        numberFound.append(line.charAt(characterIndex));
                        indexList.add(characterIndex);
                        characterIndex++;
                    } else {
                        isDigit = false;
                    }
                }
                mapOfNumberAndIndexes.put(new LineWithValue(i, Integer.parseInt(numberFound.toString())), indexList);
            }
        }
    }

    private static boolean isCharacterValidatingNumber(Character character) {
        if(Character.isDigit(character)) return false;
        return character != NOT_VALID_REGEX;
    }


}
