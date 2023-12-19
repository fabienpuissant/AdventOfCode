package org.advent.code.day.six;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class DaySixBisTest {

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DaySixBis.solvePuzzle("testDaySix.txt")).isEqualTo(71503);
    }

}
