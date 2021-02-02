package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  final private int BOARD_LENGTH = 3;
  final private int BOARD_HEIGHT = 3;
  final private int BOARD_SIZE = BOARD_HEIGHT * BOARD_LENGTH;
  final private int IN_A_ROW = 3;

  private char[] board;

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
    board = setBoard.toLowerCase().toCharArray();
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {

    System.out.println(board[0]);

    return null;
  }
}
