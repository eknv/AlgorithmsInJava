package com.eknv.algorithms.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChessboardTests {


    @Test
    public void test1() {
        assertEquals(2, Chessboard.calculate(1, 1));

        assertEquals(1, Chessboard.calculate(2, 1));
        assertEquals(1, Chessboard.calculate(1, 2));

        assertEquals(3, Chessboard.calculate(3, 2));

        assertEquals(4, Chessboard.calculate(2, 2));

        assertEquals(2, Chessboard.calculate(3, 3));

        assertEquals(3, Chessboard.calculate(3, 0));

        assertEquals(3, Chessboard.calculate(5, 0));

        assertEquals(4, Chessboard.calculate(2, 6));

        assertEquals(4, Chessboard.calculate(6, 6));


        assertEquals(4, Chessboard.calculate(3, 5));

    }


}