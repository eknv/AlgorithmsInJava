package com.eknv.algorithms.others;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NegativeBaseTests {


    @ParameterizedTest
    @MethodSource("dataProvider")
    void test1(int decNumber, String baseMinus2Number) {
        assertEquals(baseMinus2Number, NegativeBase.calculate(decNumber, -2));
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                arguments(0, "0"),
                arguments(1, "1"),
                arguments(2, "110"),
                arguments(3, "111"),
                arguments(4, "100"),
                arguments(5, "101"),
                arguments(6, "11010"),
                arguments(7, "11011"),
                arguments(8, "11000"),
                arguments(9, "11001"),
                arguments(10, "11110"),
                arguments(11, "11111"),
                arguments(12, "11100"),
                arguments(13, "11101"),
                arguments(14, "10010"),
                arguments(15, "10011"),
                arguments(16, "10000"),
                arguments(17, "10001"),
                arguments(18, "10110"),
                arguments(19, "10111"),
                arguments(20, "10100")
        );
    }

}
