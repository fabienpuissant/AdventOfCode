package org.advent.code;

import org.advent.code.day.five.DayFive;
import org.advent.code.day.five.DayFiveBis;
import org.advent.code.day.four.DayFour;
import org.advent.code.day.four.DayFourBis;
import org.advent.code.day.one.DayOne;
import org.advent.code.day.one.DayOneBis;
import org.advent.code.day.three.DayThree;
import org.advent.code.day.three.DayThreeBis;
import org.advent.code.day.two.DayTwo;
import org.advent.code.day.two.DayTwoBis;

import java.io.IOException;
import java.math.BigDecimal;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("####################  Day One solution ####################");
        System.out.println(DayOne.solvePuzzle("dayOnePuzzle.txt"));

        System.out.println("####################  Day One Bis solution ####################");
        System.out.println(DayOneBis.solvePuzzle("dayOnePuzzle.txt"));

        System.out.println("####################  Day Two solution ####################");
        System.out.println(DayTwo.solvePuzzle("dayTwoPuzzle.txt"));

        System.out.println("####################  Day Two Bis solution ####################");
        System.out.println(DayTwoBis.solvePuzzle("dayTwoPuzzle.txt"));

        System.out.println("####################  Day Three solution ####################");
        System.out.println(DayThree.solvePuzzle("dayThreePuzzle.txt"));

        System.out.println("####################  Day Three Bis solution ####################");
        System.out.println(DayThreeBis.solvePuzzle("dayThreePuzzle.txt"));

        System.out.println("####################  Day Four solution ####################");
        System.out.println(DayFour.solvePuzzle("dayFourPuzzle.txt"));

        System.out.println("####################  Day Four Bis solution ####################");
        //System.out.println(DayFourBis.solvePuzzle("dayFourPuzzle.txt"));

        System.out.println("####################  Day Five solution ####################");
        System.out.println(DayFive.solvePuzzle("dayFivePuzzle.txt"));

        System.out.println("####################  Day Five Bis solution ####################");
        System.out.println(DayFiveBis.solvePuzzle("dayFivePuzzle.txt"));
    }
}