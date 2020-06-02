package com.eknv.algorithms.others;

/**
 * You have an infinite chessboard, and a knight. The knight starts at [0, 0]
 * and can move [like a knight moves, skipped for brevity].
 * <p>
 * Given a coordinates on the board, return the least amount of moves the knight has to make to get to that position"
 */
public class Chessboard {

    private Chessboard() {
    }

    public static int calculate(int x, int y) {


        if (x == 0 && y == 0) {
            return 0;
        }


        boolean finished = false;
        int jumps = 0;
        int i = 0;
        int j = 0;


        while (i != x || j != y) {

            /**
             * first handling special cases
             */

            if (
                // 3 away in one direction and 1 away in the other
                    (Math.abs(x - i) == 3 && Math.abs(y - j) == 1)
                            || (Math.abs(x - i) == 1 && Math.abs(y - j) == 3)
                            // just 2 away in 1 direction
                            || (Math.abs(x - i) == 2 && Math.abs(y - j) == 0)
                            || (Math.abs(x - i) == 0 && Math.abs(y - j) == 2)
                            // sitting diagonal, one away in both directions
                            || (Math.abs(x - i) == 1 && Math.abs(y - j) == 1)
            ) {
                jumps += 2;
                finished = true;
            }

            // 2 away in one direction and 1 away in the other
            else if ((Math.abs(x - i) == 2 && Math.abs(y - j) == 1)
                    || (Math.abs(x - i) == 1 && Math.abs(y - j) == 2)
            ) {
                jumps += 1;
                finished = true;
            }

            // sitting next to it, one away just in one direction
            else if ((Math.abs(x - i) == 1 && Math.abs(y - j) == 0)
                    || (Math.abs(x - i) == 0 && Math.abs(y - j) == 1)
            ) {
                jumps += 3;
                finished = true;
            }

            /**
             * for all other cases
             */
            else if (Math.abs(x - i) > Math.abs(y - j)) {
                i += 2;
                if (y >= j) {
                    j++;
                } else {
                    j--;
                }
                jumps++;
            } else {
                j += 2;
                if (x >= i) {
                    i++;
                } else {
                    i--;
                }
                jumps++;
            }

            if (finished) {
                break;
            }

        }


        return jumps;
    }


}
