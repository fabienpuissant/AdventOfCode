package org.advent.code.day.four;

import org.advent.code.day.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayFourBis {

    public static Integer solvePuzzle(String fileName) throws IOException {
        List<String> lines = Utils.getLinesFromFile(fileName);
        return getAllCardsWon(lines).stream().mapToInt(ScratchCard::getNumberOfCardWon).sum();
    }

    public static List<ScratchCard> getAllCardsWon(List<String> lines) {
        //Map gameId => card numbers
        List<ScratchCard> cardWonList = new ArrayList<>();
        //Initiate cards by the original cards
        lines.forEach(line -> cardWonList.add(getScratchCardFromLine(line)));
        var lineIndex = 0;
        while (lineIndex < lines.size()) {
            var line = lines.get(lineIndex);
            var gameId = getGameId(line);
            var scratchCard = cardWonList.stream().filter(card -> card.getGameId().equals(gameId)).findFirst().orElseThrow(
                    () -> new RuntimeException(String.format("Cannot find scratchCard with id : '%s'", gameId))
            );
            for (var i = 0; i < scratchCard.getNumberOfCardWon(); i++) {
                for (var lineIndexWonCopy = 0; lineIndexWonCopy < scratchCard.getWinningScore(); lineIndexWonCopy++) {
                    if (lineIndexWonCopy + lineIndex + 1 < lines.size()) {
                        int finalLineIndexWonCopy = lineIndexWonCopy;
                        var cardToAddCopy = cardWonList.stream().filter(card -> card.getGameId().equals(scratchCard.getGameId() + finalLineIndexWonCopy + 1)).findFirst()
                                .orElseThrow(() -> new RuntimeException(String.format("Cannot find scratchCard with id : '%s'", scratchCard.getGameId())));
                        cardToAddCopy.setNumberOfCardWon(cardToAddCopy.getNumberOfCardWon() + 1);
                    }
                }
            }
            lineIndex++;
        }

        return cardWonList;
    }

    public static ScratchCard getScratchCardFromLine(String line) {
        var gameId = getGameId(line);
        var gameResult = DayFour.getNumberOfMatch(line);
        return new ScratchCard(gameId, gameResult, 1);
    }

    private static Integer getGameId(String line) {
        var gameInfo = line.substring(0, line.indexOf(":"));
        var gameId = gameInfo.replaceAll("[^0-9]+", "");
        return Integer.parseInt(gameId);
    }

}
