package org.advent.code.day.seven;

import java.util.*;

public class GameCards implements Comparable<GameCards> {

    private final String cards;

    public String getCards() {
        return cards;
    }

    public GameCards(String cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameCards gameCards = (GameCards) o;

        return Objects.equals(cards, gameCards.cards);
    }

    @Override
    public int hashCode() {
        return cards != null ? cards.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GameCards{" +
                "cards='" + cards + '\'' +
                '}';
    }

    @Override
    public int compareTo(GameCards o) {
        //Compare these in order to read lines, create a TreeMap, so that keys (games) are already ordered, just need to sum the bets
        var thisGameType = this.getGameType();
        var otherGameType = o.getGameType();
        if(thisGameType != otherGameType) {
            return thisGameType.compareTo(otherGameType);
        }
        return 0;
    }

    public GameStrength getGameType() {
        var groupedCard = getDistinctCards();
        //If distinct number equals to card number => HIGH_CARD
        if(groupedCard.size() == cards.length()) return GameStrength.HIGH_CARD;

        // If only one distinct character => FIVE_OF_A_KIND
        if(groupedCard.size() == 1) return GameStrength.FIVE_OF_A_KIND;

        // If two distinct characters, could be FOUR_OF_A_KING or FULL_HOUSE
        if(groupedCard.size() == 2) {
            var firstChar = groupedCard.getFirst();
            var secondChar = groupedCard.getLast();
            if(cards.chars().filter(ch -> ch == firstChar).count() == 4 ||
            cards.chars().filter(ch -> ch == secondChar).count() == 4) {
                return GameStrength.FOUR_OF_A_KIND;
            } else return GameStrength.FULL_HOUSE;
        }

        // If three distinct characters, could be TWO_PAIRS or THREE_OF_A_KIND
        if(groupedCard.size() == 3) {
            var firstChar = groupedCard.getFirst();
            var secondChar = groupedCard.get(1);
            var thirdChar = groupedCard.getLast();
            if(cards.chars().filter(ch -> ch == firstChar).count() == 3 ||
                    cards.chars().filter(ch -> ch == secondChar).count() == 3 ||
                    cards.chars().filter(ch -> ch == thirdChar).count() == 3) {
                return GameStrength.THREE_OF_A_KING;
            } else return GameStrength.TWO_PAIRS;
        }

        // If other not triggered => PAIR
        return GameStrength.PAIR;
    }

    public List<Character> getDistinctCards() {
        List<Character> distinctChar = new ArrayList<>();
        cards.chars().mapToObj(c -> (char) c).distinct().forEach(distinctChar::add);
        return distinctChar;
    }
}
