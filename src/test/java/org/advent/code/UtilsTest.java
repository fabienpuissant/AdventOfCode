package org.advent.code;

import org.advent.code.day.Utils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    void should_read_file_get_a_list_of_string() throws IOException {
        assertThat(Utils.getLinesFromFile("testDayOne.txt")).isEqualTo(List.of(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"
        ));
    }

    @Test
    void should_concatenate_two_integers() {
        assertThat(Utils.concatenateIntegers(4,5)).isEqualTo(45);
    }

    @Test
    void should_get_all_number_from_string() {
        assertThat(Utils.getAllNumbersFromString("seeds: 79 14 55 13"))
                .isEqualTo(List.of(79d, 14d, 55d, 13d));
    }

    @Test
    void should_get_all_number_aggregated_from_string() {
        assertThat(Utils.getAggregatedNumbersFromString("seeds: 79 14 55 13"))
                .isEqualTo(79145513d);
    }

}
