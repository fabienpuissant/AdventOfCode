package org.advent.code.day.one;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayOneTest {

    @Test
    void should_parse_digit_convert_string_into_array_of_digits() {
        var line = "1abc2";
        assertThat(DayOne.parseDigits(line)).isEqualTo(List.of(1, 2));
    }

    @Test
    void should_extract_code_from_line_throw_when_line_has_no_digit_at_all() {
        var exception = assertThrows(RuntimeException.class,
                () -> DayOne.extractCodeFromLine("abscdef"));
        assertEquals("File contains a line without any digit : 'abscdef'", exception.getMessage());
    }

    @Test
    void should_extract_code_from_line_concatenate_the_only_digit_if_only_one_digit_detected() {
        assertThat(DayOne.extractCodeFromLine("adcd2asa")).isEqualTo(22);
    }

    @Test
    void should_extract_code_from_line_concatenate_the_first_and_last_digit_detected() {
        assertThat(DayOne.extractCodeFromLine("adcd2as3a")).isEqualTo(23);
    }

    @Test
    void should_solve_the_puzzle() throws IOException {
        assertThat(DayOne.solvePuzzle("testDayOne.txt")).isEqualTo(142);
    }

}
