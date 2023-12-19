package org.advent.code.day.three;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DayThreeTest {

    @ParameterizedTest
    @MethodSource("provideExampleForCurrentLine")
    void should_validate_number_on_current_line(String line, List<Integer> indexToCheck, Boolean expected) {
        assertThat(DayThree.isNumberValidOnCurrentLine(indexToCheck, line)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideExampleForCurrentLine() {
        return Stream.of(
                //Invalid cases
                Arguments.of("1....", List.of(0), false),
                Arguments.of("12.......", List.of(0, 1), false),
                Arguments.of(".1....", List.of(1), false),
                Arguments.of(".12....", List.of(1, 2), false),
                Arguments.of("....1", List.of(4), false),
                Arguments.of(".....11", List.of(5, 6), false),

                //Valid cases with 1 digit
                Arguments.of("1a.....", List.of(0), true),
                Arguments.of("a1..", List.of(1), true),
                Arguments.of("..1b..", List.of(2), true),
                Arguments.of("...b1...", List.of(4), true),
                Arguments.of("....1b", List.of(4), true),
                Arguments.of("....b1", List.of(5), true),

                //Valid cases with multiple digit
                Arguments.of("12a.....", List.of(0, 1), true),
                Arguments.of("a12..", List.of(1, 2), true),
                Arguments.of("..12b..", List.of(2, 3), true),
                Arguments.of("...b12...", List.of(4, 5), true),
                Arguments.of("....12b", List.of(4, 5), true),
                Arguments.of("....b12", List.of(5, 6), true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideExampleForOtherLine")
    void should_validate_number_on_other_line_line(String line, List<Integer> indexToCheck, Boolean expected) {
        assertThat(DayThree.isNumberValidOnOtherLine(indexToCheck, line)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideExampleForOtherLine() {
        return Stream.of(
                //Invalid cases
                Arguments.of("/....", List.of(0), true),
                Arguments.of(".*.......", List.of(0, 1), true),
                Arguments.of("..*...", List.of(1), true),
                Arguments.of("/......", List.of(1, 2), true),
                Arguments.of("......", List.of(4), false),
                Arguments.of("1.....", List.of(0), false)

        );
    }

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DayThree.solvePuzzle("testDayThree.txt")).isEqualTo(4361);
    }

}
