package org.advent.code.day.three;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DayThreeBisTest {

    @Test
    void should_get_star_map_find_all_stars_in_lines() {
        var lines = List.of("*....", ".*...", "..*..", "...*.", "....*");
        assertThat(DayThreeBis.getStarsMap(lines))
                .isEqualTo(List.of(new StarItem(0, 0),
                        new StarItem(1, 1),
                        new StarItem(2, 2),
                        new StarItem(3, 3),
                        new StarItem(4, 4)));
    }

    @ParameterizedTest
    @MethodSource("provideExampleToFindGears")
    void should_find_gears(List<StarItem> starItems, Map<LineWithValue, List<Integer>> mapOfIntegerToValidate, List<String> lines, List<Integer> result) {
        assertThat(DayThreeBis.findGears(starItems, mapOfIntegerToValidate, lines)).isEqualTo(result);
    }

    private static Stream<Arguments> provideExampleToFindGears() {
        return Stream.of(
                /*
                123*2....
                */
                Arguments.of(List.of(new StarItem(0, 3)),
                        Map.of(new LineWithValue(0, 123), List.of(0, 1, 2), new LineWithValue(0, 2), List.of(4)),
                        List.of("123*2...."), List.of(246)),
                /*
                *2....
                123...
                */
                Arguments.of(List.of(new StarItem(0, 0)),
                        Map.of(new LineWithValue(0, 2), List.of(1), new LineWithValue(1, 123), List.of(0, 1, 2)),
                        List.of("*2....", "123..."), List.of(246)),
                /*
                2*....
                ..123.
                */
                Arguments.of(List.of(new StarItem(0, 1)),
                        Map.of(new LineWithValue(0, 2), List.of(0), new LineWithValue(1, 123), List.of(2, 3, 4)),
                        List.of("2*....", "..123."), List.of(246)),
                /*
                2.....
                .*123.
                */
                Arguments.of(List.of(new StarItem(1, 1)),
                        Map.of(new LineWithValue(0, 2), List.of(0), new LineWithValue(1, 123), List.of(2, 3, 4)),
                        List.of("2......", ".*123."), List.of(246)),
                /*
                2.....
                .*....
                123...
                */
                Arguments.of(List.of(new StarItem(1, 1)),
                        Map.of(new LineWithValue(0, 2), List.of(0), new LineWithValue(2, 123), List.of(0, 1, 2)),
                        List.of("2......", ".*....", "123..."), List.of(246)),
                /*
                2.....
                .*....
                ..123.
                */
                Arguments.of(List.of(new StarItem(1, 1)),
                        Map.of(new LineWithValue(0, 2), List.of(0), new LineWithValue(2, 123), List.of(2, 3, 4)),
                        List.of("2......", ".*....", "..123."), List.of(246)),
                /*
                .....2
                .....*
                ..123.
                */
                Arguments.of(List.of(new StarItem(1, 4)),
                        Map.of(new LineWithValue(0, 2), List.of(5), new LineWithValue(2, 123), List.of(2, 3, 4)),
                        List.of(".....2", ".....*", "..123."), List.of(246)),
                /*
                .....2
                ....*.
                .123.1
                */
                Arguments.of(List.of(new StarItem(1, 4)),
                        Map.of(new LineWithValue(0, 2), List.of(5),
                                new LineWithValue(2, 123), List.of(1, 2, 3),
                                new LineWithValue(2, 1), List.of(5)),
                        List.of("....2", "....*", ".123.1"), List.of())

        );
    }

    @Test
    void should_solve_puzzle() throws IOException {
        assertThat(DayThreeBis.solvePuzzle("testDayThree.txt")).isEqualTo(467835);
    }

    @Test
    void should_solve_puzzle_light() throws IOException {
        assertThat(DayThreeBis.solvePuzzle("testDayThreeLight.txt")).isEqualTo(1287526);
    }

}
