package org.advent.code.day.two;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwoBisTest {

    @Test
    void should_get_power_of_set_return_multiplication_of_max_cubes_of_each_color() {
        assertThat(DayTwoBis.getPowerOfSet("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")).isEqualTo(48);
    }

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DayTwoBis.solvePuzzle("testDayTwo.txt")).isEqualTo(2286);
    }

}
