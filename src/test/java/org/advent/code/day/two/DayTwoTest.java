package org.advent.code.day.two;

import org.advent.code.day.one.DayOne;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayTwoTest {

    @Test
    void is_cube_valid_for_game_return_true_if_all_cubes_numbers_are_below_maximum() {
        assertThat(DayTwo.isCubesValidForGame(List.of(1, 2, 3, 8), 9)).isTrue();
    }

    @Test
    void is_cube_valid_for_game_return_false_if_one_cube_number_is_above_maximum() {
        assertThat(DayTwo.isCubesValidForGame(List.of(1, 2, 3, 8), 7)).isFalse();
    }

    @Test
    void should_get_game_id_throw_when_game_regex_not_found() {
        var exception = assertThrows(RuntimeException.class,
                () -> DayTwo.getGameId("Gam 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        assertEquals("Cannot find Game id in : 'Gam 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green'", exception.getMessage());
    }

    @Test
    void should_get_game_id() {
        assertThat(DayTwo.getGameId("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")).isEqualTo(1);
    }

    @Test
    void should_found_cubes_by_color_return_empty_list_if_no_one_found() {
        assertThat(DayTwo.getListOfCubesByColor("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", "noOne"))
                .isEqualTo(Collections.emptyList());
    }

    @Test
    void should_found_cubes_by_color_return_list_of_number_found() {
        assertThat(DayTwo.getListOfCubesByColor("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", "red"))
                .isEqualTo(List.of(4, 1));
    }

    @Test
    void should_extract_game_item_from_string() {
        var expected = new GameItem(1, List.of(4, 1), List.of(2, 2), List.of(3, 6));
        assertThat(DayTwo.extractGameItem("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))
                .isEqualTo(expected);
    }

    @Test
    void should_parse_game_id_at_index_should_work_with_one_digit() {
        assertThat(DayTwo.parseIdFromStringAtIndex("Game 1:", 5)).isEqualTo(1);
    }

    @Test
    void should_parse_game_id_at_index_should_work_with_two_digit() {
        assertThat(DayTwo.parseIdFromStringAtIndex("Game 10:", 5)).isEqualTo(10);
    }

    @Test
    void should_parse_game_id_at_index_should_work_with_three_digit() {
        assertThat(DayTwo.parseIdFromStringAtIndex("Game 100:", 5)).isEqualTo(100);
    }

    @Test
    void should_parse_cubes_at_index_should_work_with_one_digit() {
        assertThat(DayTwo.parseIdFromStringAtIndex("Game 1: 3 blue", 8)).isEqualTo(3);
    }

    @Test
    void should_parse_cubes_at_index_should_work_with_three_digit() {
        assertThat(DayTwo.parseIdFromStringAtIndex("Game 1: 300 blue", 8)).isEqualTo(300);
    }


    @Test
    void should_solve_the_puzzle() throws IOException {
        assertThat(DayTwo.solvePuzzle("testDayTwo.txt")).isEqualTo(8);
    }

}
