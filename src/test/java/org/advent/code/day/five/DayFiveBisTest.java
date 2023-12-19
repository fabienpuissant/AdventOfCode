package org.advent.code.day.five;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFiveBisTest {

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DayFiveBis.solvePuzzle("testDayFive.txt")).isEqualTo(46);
    }

}
