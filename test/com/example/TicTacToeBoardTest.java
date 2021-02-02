package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/* What needs to be checked?

(IllegalArgumentExceptions)
1. TicTacToeBoard is passed a NonNull String. (Java Complier Checks for String Argument)
2. String must be of correct length.

(Unreachable State)
1. Assuming x goes first, check so that X does not appear more than once more than O.
2. Check to make sure O never appears more than X.

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

  // Start of IllegalArgumentsTesting
  /** Tests null argument throws exception. */
  @Test (expected = IllegalArgumentException.class)
  public void testNullArgument() {
    TicTacToeBoard board = new TicTacToeBoard(null);
  }

  /** Tests incorrect length string throw exception. */
  @Test (expected = IllegalArgumentException.class)
  public void testStringLength() {
    TicTacToeBoard board = new TicTacToeBoard("xoXoXoxo");
  }
  // End of IllegalArgumentTesting

  // Start of UnreachableStateTesting
  /** Tests that Player 1 has no more than one move more than player 2. */
  @Test
  public void testPlayerOneMoves() {
    TicTacToeBoard board = new TicTacToeBoard("XxoXOX.1.");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  /** Tests that Player 2 does not have more moves than player 1. */
  @Test
  public void testPlayerTwoMoves() {
    TicTacToeBoard board = new TicTacToeBoard("oOxOxO..z");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
  // End of UnreachableStateTesting

  // Start of HorizontalTesting
  /** Tests X horizontal works. */
  @Test
  public void testXWinnerHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard("xXxOoX..O");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  /** Tests O horizontal works */
  @Test
  public void testOWinnerHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard("xX.OoO..X");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  /** Tests different characters don't result in a win */
  @Test
  public void testFaultyWinner() {
    TicTacToeBoard board = new TicTacToeBoard("xoX.Oppp");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }
  // End of HorizontalTesting


  /*
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  } */
}
