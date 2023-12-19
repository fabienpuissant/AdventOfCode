package org.advent.code.day.four;

import java.util.Objects;

public class ScratchCard {

    private final Integer gameId;

    private final Integer winningScore;

    private Integer numberOfCardWon = 0;


    public ScratchCard(Integer gameId, Integer winningScore, Integer numberOfCardWon) {
        this.gameId = gameId;
        this.winningScore = winningScore;
        this.numberOfCardWon = numberOfCardWon;
    }

    public Integer getGameId() {
        return gameId;
    }

    public Integer getWinningScore() {
        return winningScore;
    }

    public Integer getNumberOfCardWon() {
        return numberOfCardWon;
    }

    public void setNumberOfCardWon(Integer numberOfCardWon) {
        this.numberOfCardWon = numberOfCardWon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScratchCard that = (ScratchCard) o;

        if (!Objects.equals(gameId, that.gameId)) return false;
        if (!Objects.equals(winningScore, that.winningScore)) return false;
        return Objects.equals(numberOfCardWon, that.numberOfCardWon);
    }

    @Override
    public int hashCode() {
        int result = gameId != null ? gameId.hashCode() : 0;
        result = 31 * result + (winningScore != null ? winningScore.hashCode() : 0);
        result = 31 * result + (numberOfCardWon != null ? numberOfCardWon.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ScratchCard{" +
                "gameId=" + gameId +
                ", winningScore=" + winningScore +
                ", numberOfCardWon=" + numberOfCardWon +
                '}';
    }
}
