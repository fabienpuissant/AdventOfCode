package org.advent.code.day.height;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class DayHeightBisTest {

    @Test
    void shouldSolvePuzzle() throws IOException {
        assertThat(DayHeightBis.solvePuzzle("testDayHeightBis.txt")).isEqualTo(6);
    }

}
