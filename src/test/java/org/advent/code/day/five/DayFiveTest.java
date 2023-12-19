package org.advent.code.day.five;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFiveTest {

    @Test
    void should_get_seed_numbers() {
        assertThat(DayFive.getSeedNumbers(List.of("   ", "seeds: 79 14 55 13", "seed-to-soil map:")))
                .isEqualTo(List.of(79, 14, 55, 13));
    }

    @Test
    void should_get_conversion_map_stop_when_map_is_over() {
        assertThat(DayFive.getMapOfConversionType(ConversionType.SEED_TO_SOIL,
                List.of("seeds: 79 14 55 13", "", "seed-to-soil map:", "50 98 2", "52 50 48", ""
                ))).isEqualTo(List.of(
                new MapItem(50, 98, 2),
                new MapItem(52, 50, 48)
        ));
    }

    @Test
    void should_get_conversion_map_stop_when_end_of_file() {
        assertThat(DayFive.getMapOfConversionType(ConversionType.SEED_TO_SOIL,
                List.of("seeds: 79 14 55 13", "", "seed-to-soil map:", "50 98 2", "52 50 48"
                ))).isEqualTo(List.of(
                new MapItem(50, 98, 2),
                new MapItem(52, 50, 48)
        ));
    }

    @Test
    void should_convert_from_map_when_number_not_in_range_return_id_to_convert() {
        assertThat(DayFive.convertIdFromConversionMap(53,
                List.of(new MapItem(50, 98, 2),
                        new MapItem(52, 50, 48))))
                .isEqualTo(53);
    }

    @Test
    void should_convert_from_map_when_number_not_in_range() {
        assertThat(DayFive.convertIdFromConversionMap(98,
                List.of(new MapItem(50, 98, 2),
                        new MapItem(52, 50, 48))))
                .isEqualTo(50);
    }

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DayFive.solvePuzzle("testDayFive.txt")).isEqualTo(35);
    }

}
