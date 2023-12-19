package org.advent.code.day.one;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DayOneBisTest {

    @Test
    void should_convert_literal_digit_to_digits() {
        assertThat(DayOneBis.convertLiteralDigits("one1two2three3four4five5six6seven7eight8nine9"))
                .isEqualTo("112233445566778899");
    }

    @Test
    void should_convert_literal_digit_to_digits_bis() {
        assertThat(DayOneBis.convertLiteralDigits("eightwothree"))
                .isEqualTo("823");
    }

    @ParameterizedTest
    @MethodSource("provideExamplesToExtract")
    void should_extract_code(String input, Integer expected) {
        assertThat(DayOneBis.extractCodeFromLine(input))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> provideExamplesToExtract() {
        return Stream.of(
                Arguments.of("two1nine", 29),
                Arguments.of("eightwothree", 83),
                Arguments.of("abcone2threexyz", 13),
                Arguments.of("xtwone3four", 24),
                Arguments.of("4nineeightseven2", 42),
                Arguments.of("zoneight234", 14),
                Arguments.of("7pqrstsixteen", 76)
        );
    }

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DayOneBis.solvePuzzle("testDayOneBis.txt")).isEqualTo(281);
    }
}
