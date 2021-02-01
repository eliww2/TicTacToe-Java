package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/* What needs to be checked?

(IllegalArgumentExceptions)
1. TicTacToeBoard is passed a NonNull String.
2. String must be of correct length.
3. Assuming x goes first, check so that X does not appear more than once more than O.
4. Check to make sure O never appears more than X.

(Horizontal Wins)
1. Check X wins on the horizontal, use both x and X to ensure game detects both.
2. Check O wins on (different) horizontal, use both o and O to ensure game detects both.
3. Check that some same symbol occurring in the winning positions doesn't count as win.

(Vertical Wins)
1. Check X wins on the vertical, use both x and X to ensure game detects both.
2. Check O wins on (different) vertical, use both o and O to ensure game detects both.

(Diagonal Wins)
1. Check X wins on one Diagonal, use both x and X to ensure game detects both.
2. Check O wins on opposite Diagonal (there is only 2).

(No Winner)
1. Check that a board still in progress has no winner.
2. Check full board with no winner returns NoWinner.
 */


public class TicTacToeBoardTest {

  public static class IllegalArgumentsTest {
    @Test
    public void testValidBoardNoWinner() {
      TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
      assertEquals(Evaluation.NoWinner, board.evaluate());
    }
  }
}
