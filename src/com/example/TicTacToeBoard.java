package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  // Parameters of board that are flexible to change
  private int BOARD_LENGTH = 3;
  private int BOARD_HEIGHT = 3;
  private int BOARD_SIZE = BOARD_HEIGHT * BOARD_LENGTH;
  private int IN_A_ROW = 3;

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {

  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    return Evaluation.Xwins;
  }
}
