package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  final private int BOARD_LENGTH = 3;
  final private int BOARD_HEIGHT = 3;
  final private int BOARD_SIZE = BOARD_HEIGHT * BOARD_LENGTH;

  private String boardString;

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
    if (board == null) {
      throw new IllegalArgumentException();
    }
    if (board.length() != BOARD_SIZE) {
      throw new IllegalArgumentException();
    }

    boardString = board.toLowerCase();
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {

    // Unreachable state testing
    int xCount = 0;
    int oCount = 0;
    for (int i = 0; i < BOARD_SIZE; i++) {
      if (boardString.charAt(i) == 'x') {
        xCount++;
      }
      if (boardString.charAt(i) == 'o') {
        oCount++;
      }
    }
    if (xCount > oCount + 1 || oCount > xCount) {
      return Evaluation.UnreachableState;
    }

    // determines winner, if one is above 0, they win, unless both then unreachable state.
    int xWins = 0;
    int oWins = 0;

    // Horizontal testing
    for (int i = 0; i < BOARD_HEIGHT; i++) {
      if (boardString.substring(BOARD_LENGTH * i, BOARD_LENGTH * (i + 1)).contains("xxx")) {
        xWins++;
      } else if (boardString.substring(BOARD_LENGTH * i, BOARD_LENGTH * (i + 1)).contains("ooo")) {
        oWins++;
      }
    }

    // Vertical testing
    for (int i = 0; i < BOARD_LENGTH; i++) {
      String vertical = "";
      for (int j = i; j < BOARD_SIZE; j += BOARD_LENGTH) {
        vertical += boardString.charAt(j);
      }
      if (vertical.contains("xxx")) {
        xWins++;
      } else if (vertical.contains("ooo")) {
        oWins++;
      }
    }

    // Left to Right Diagonal testing (this is mostly applicable for boards with m = n = k)
    String diagonalLeftToRight = "";
    for (int i = 0; i < BOARD_LENGTH; i++) {
      diagonalLeftToRight += boardString.charAt(i * (BOARD_LENGTH + 1));
    }
    if (diagonalLeftToRight.contains("xxx")) {
      xWins++;
    } else if (diagonalLeftToRight.contains("ooo")) {
      oWins++;
    }

    // Right to Left Diagonal testing
    String diagonalRightToLeft = "";
    for (int i = 1; i < BOARD_LENGTH + 1; i++) {
      diagonalRightToLeft += boardString.charAt(i * (BOARD_LENGTH - 1));
    } if (diagonalRightToLeft.contains("xxx")) {
      xWins++;
    } else if (diagonalRightToLeft.contains("ooo")) {
      oWins++;
    }

    // winner decided
    if (xWins > 0 && oWins > 0) {
      return Evaluation.UnreachableState;
    } else if (xWins > 0) {
      return Evaluation.Xwins;
    } else if (oWins > 0) {
      return Evaluation.Owins;
    }
    return Evaluation.NoWinner;
  }
}
