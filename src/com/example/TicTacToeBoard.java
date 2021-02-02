package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  final private int BOARD_LENGTH = 3;
  final private int BOARD_HEIGHT = 3;
  final private int BOARD_SIZE = BOARD_HEIGHT * BOARD_LENGTH;
  final private int IN_A_ROW = 3;

  private char[] boardArray;
  private String boardString;

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param setBoard The string representing the board
   */
  public TicTacToeBoard(String setBoard) {
    if (setBoard == null) {
      throw new IllegalArgumentException();
    }
    if (setBoard.length() != BOARD_SIZE) {
      throw new IllegalArgumentException();
    }
    boardArray = setBoard.toLowerCase().toCharArray();
    boardString = setBoard.toLowerCase();
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
      if (boardArray[i] == 'x') {
        xCount++;
      }
      if (boardArray[i] == 'o') {
        oCount++;
      }
    }
    if (xCount > oCount + 1 || oCount > xCount) {
      return Evaluation.UnreachableState;
    }


    // Horizontal testing
    for (int i = 0; i < BOARD_HEIGHT; i++) {
      if (boardString.substring(BOARD_LENGTH * i, BOARD_LENGTH * (i + 1)).contains("xxx")) {
        return Evaluation.Xwins;
      } else if (boardString.substring(BOARD_LENGTH * i, BOARD_LENGTH * (i + 1)).contains("ooo")) {
        return Evaluation.Owins;
      }
    }

    // Vertical testing
    for (int i = 0; i < BOARD_LENGTH; i++) {
      String vertical = "";
      for (int j = i; j < BOARD_SIZE; j += BOARD_LENGTH) {
        vertical += boardString.charAt(j);
      }
      if (vertical.contains("xxx")) {
        return Evaluation.Xwins;
      } else if (vertical.contains("ooo")) {
        return Evaluation.Owins;
      }
    }





    return null;
  }
}
