package org.advent.code.day.six;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class DaySixTest {

    @Test
    void should_get_winning_possibilities_of_a_race() {
        assertThat(DaySix.getWinningPossibilitiesForRace(7d, 9d)).isEqualTo(4);
    }

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DaySix.solvePuzzle("testDaySix.txt")).isEqualTo(288);
    }

}
