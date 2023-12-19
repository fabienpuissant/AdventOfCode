package org.advent.code.day.four;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFourTest {

    @Test
    void should_get_winning_numbers() {
        assertThat(DayFour.getWinningNumbers("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"))
                .isEqualTo(List.of(41, 48, 83, 86, 17));
    }

    @Test
    void should_get_players_numbers() {
        assertThat(DayFour.getPlayerNumbers("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"))
                .isEqualTo(List.of(83, 86, 6, 31, 17, 9, 48, 53));
    }

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DayFour.solvePuzzle("testDayFour.txt")).isEqualTo(13);
    }

}
