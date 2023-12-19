package org.advent.code.day.seven;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameCardsTest {

    @Test
    void should_get_all_distinct_cards_in_list() {

    }

    @Test
    void should_get_type_return_five_of_a_kind() {
        var gameCard = new GameCards("AAAAA");
        assertThat(gameCard.getGameType()).isEqualTo(GameStrength.FIVE_OF_A_KIND);
    }

    @Test
    void should_get_type_return_four_of_a_kind() {
        var gameCard = new GameCards("AAAA2");
        assertThat(gameCard.getGameType()).isEqualTo(GameStrength.FOUR_OF_A_KIND);
    }

    @Test
    void should_get_type_return_full_house() {
        var gameCard = new GameCards("AAA22");
        assertThat(gameCard.getGameType()).isEqualTo(GameStrength.FULL_HOUSE);
    }

    @Test
    void should_get_type_return_three_of_a_kind() {
        var gameCard = new GameCards("A1A2A");
        assertThat(gameCard.getGameType()).isEqualTo(GameStrength.THREE_OF_A_KING);
    }

    @Test
    void should_get_type_return_two_pairs() {
        var gameCard = new GameCards("A1A21");
        assertThat(gameCard.getGameType()).isEqualTo(GameStrength.TWO_PAIRS);
    }

    @Test
    void should_get_type_return_high_card() {
        var gameCard = new GameCards("61A23");
        assertThat(gameCard.getGameType()).isEqualTo(GameStrength.HIGH_CARD);
    }

    @Test
    void should_get_type_return_pair() {
        var gameCard = new GameCards("61A2A");
        assertThat(gameCard.getGameType()).isEqualTo(GameStrength.PAIR);
    }

    @ParameterizedTest
    @MethodSource("provideExamplesToExtract")
    void should_compare_two_cards(CompareToInput compareToInput) {
        assertThat(compareToInput.currentCard().compareTo(compareToInput.otherCard())).isEqualTo(compareToInput.expected());
    }

    private static Stream<Arguments> provideExamplesToExtract() {
        return Stream.of(
                Arguments.of(Named.of("game_type_different_and_actual_is_better",
                                new CompareToInput(new GameCards("11111"), new GameCards("1111A"), 1))),
                Arguments.of(Named.of("game_type_different_and_actual_is_fewer",
                        new CompareToInput(new GameCards("12345"), new GameCards("11654"), -1))),
                Arguments.of(Named.of("game_type_same_and_actual_is_first_card_better",
                        new CompareToInput(new GameCards("KK677"), new GameCards("KTJJT"), 1))),
                Arguments.of(Named.of("game_type_same_and_actual_is_second_card_better",
                        new CompareToInput(new GameCards("J2J23"), new GameCards("J1J23"), 1))),
                Arguments.of(Named.of("game_type_same_and_actual_is_second_card_better",
                        new CompareToInput(new GameCards("J12J3"), new GameCards("J11J3"), 1))),
                Arguments.of(Named.of("game_type_same_and_actual_is_fourth_card_better",
                        new CompareToInput(new GameCards("J123J"), new GameCards("J121J"), 1))),
                Arguments.of(Named.of("game_type_same_and_actual_is_fifth_card_better",
                        new CompareToInput(new GameCards("J123A"), new GameCards("J1212"), 1)))
        );
    }

    @Test
    void should_get_distinct_characters() {
        var gameCard = new GameCards("AA2234");
        assertThat(gameCard.getDistinctCards()).isEqualTo(List.of('A', '2', '3', '4'));
    }

}
