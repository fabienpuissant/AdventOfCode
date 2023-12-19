package org.advent.code.day.four;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFourBisTest {
    @Test
    void should_get_all_card_won() {
        assertThat(DayFourBis.getAllCardsWon(List.of("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1")))
                .isEqualTo(List.of(
                        new ScratchCard(1, 4, 1),
                        new ScratchCard(2, 2, 2),
                        new ScratchCard(3, 2, 4)
                ));
    }

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DayFourBis.solvePuzzle("testDayFour.txt")).isEqualTo(30);
    }

}
