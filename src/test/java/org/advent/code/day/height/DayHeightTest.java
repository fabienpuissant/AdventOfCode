package org.advent.code.day.height;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DayHeightTest {

    @Test
    void shouldExtractDirectionOfFirstLine() {
        var firstLine = "LLR";
        assertThat(DayHeight.extractDirections(List.of(firstLine))).isEqualTo(List.of(Direction.LEFT, Direction.LEFT, Direction.RIGHT));
    }

    @Test
    void shouldExtractDirection() {
        var firstLine = "LLR";
        var secondLine = "RR";
        var thirdLine = "     ";
        var fourthLine = "EELLE";
        assertThat(DayHeight.extractDirections(List.of(firstLine, secondLine, thirdLine, fourthLine))).isEqualTo(List.of(Direction.LEFT, Direction.LEFT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT));
    }

    @Test
    void shouldExtractPath() {
        var path = List.of("RLRL", "        ", "AAA = (BBB, CCC)", "BBB = (DDD, EEE)");
        assertThat(DayHeight.extractPath(path)).isEqualTo(Map.of("AAA", List.of("BBB", "CCC"), "BBB", List.of("DDD", "EEE")));
    }

    @Test
    void shouldSolvePuzzle() throws IOException {
        assertThat(DayHeight.solvePuzzle("testDayHeight.txt")).isEqualTo(2);
    }

}
