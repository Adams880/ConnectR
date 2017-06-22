package Objects;

import java.util.Scanner;

public class Board {
    private String[][] board;
    private int numOfColumns;
    private int numOfRows;
    private int connectNum;

    public String[][] getBoard() {
        return board;
    }

    public int getNumOfColumns() {
        return numOfColumns;
    }

    public int getNumOfRows() {
        return numOfRows;
    }



    public Board (int numOfRows, int numOfColumns, int connectNum) {
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.connectNum = connectNum;
        generate();
    }

    private void generate() {
        board = new String[numOfRows][numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                board[i][j] = ".";
            }
        }
    }

    public void placePiece(int columnIn, int player) {
        boolean changed = false;
        Scanner sc = new Scanner(System.in);
        do {
            if (player == 1) {
                for (int i = numOfRows - 1; i >= 0; i--) {
                    if (board[i][columnIn].equalsIgnoreCase(".") && !changed) {
                        board[i][columnIn] = "X";
                        changed = true;
                    }
                }
            } else if (player == 2) {
                for (int i = numOfRows - 1; i >= 0; i--) {
                    if (board[i][columnIn].equalsIgnoreCase(".") && !changed) {
                        board[i][columnIn] = "O";
                        changed = true;
                    }
                }
            }
            if (!changed) {
                System.out.print("Invalid move, please input a different column: ");
                columnIn = sc.nextInt();
            }
        } while(!changed);
    }

    public boolean checkWin(int player) {
        boolean victory = false;
        int maxConnection = 0;
        switch (player) {
            case 1:
                //TODO: code horizontal checking, check each row for connections
                int connections = 0;
                for (int i = 0; i < numOfRows; i++) {
                    for (int j = 0; j < numOfColumns; j++) {
                        if (board[i][j].equalsIgnoreCase("X")) {
                            connections++;
                        } else if (!board[i][j].equalsIgnoreCase("X")) {
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                            connections = 0;
                        }
                    }
                }
                //System.out.println("Total num of connections for Player 1 Horiz: " + maxConnection);
                if (maxConnection == connectNum) {
                    return true;
                }
                //TODO: code vertical checking, check each column for connections
                connections = 0;
                maxConnection = 0;
                for (int i = 0; i < numOfColumns; i++) {
                    for (int j = 0; j < numOfRows; j++) {
                        if (board[j][i].equalsIgnoreCase("X")) {
                            connections++;
                        } else if (!board[j][i].equalsIgnoreCase("X")) {
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                            connections = 0;
                        }
                    }
                }
                //System.out.println("Total num of connections for Player 1 Vertical: " + maxConnection);
                if (maxConnection == connectNum) {
                    return true;
                }
                //TODO: code left-right diagonals checking
                connections = 0;
                maxConnection = 0;
                for (int i = 0; i < (numOfRows - (connectNum - 1)); i++) {
                    int rowCounter, colCounter;
                    for (rowCounter = i, colCounter = 0; rowCounter < numOfRows && colCounter < numOfColumns; rowCounter++, colCounter++) {
                        //System.out.print("Checking Index " + rowCounter + ", " + colCounter);
                        if (board[rowCounter][colCounter].equalsIgnoreCase("X")) {
                            //System.out.println(": true");
                            connections++;
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                        } else if (!board[rowCounter][colCounter].equalsIgnoreCase("X")) {
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                            //System.out.print("\n");
                            connections = 0;
                        }
                    }
                }
                //System.out.println("Total num of connections for Player 1 of Some Diag: " + maxConnection);
                if (maxConnection == connectNum) {
                    return true;
                }

                connections = 0;
                maxConnection = 0;
                for (int i = 0; i < (numOfColumns - (connectNum - 1)); i++) {
                    int rowCounter, colCounter;
                    for (rowCounter = 0, colCounter = i; rowCounter < numOfRows && colCounter < numOfColumns; rowCounter++, colCounter++) {
                        //System.out.print("Checking Index " + rowCounter + ", " + colCounter);
                        if (board[rowCounter][colCounter].equalsIgnoreCase("X")) {
                            //System.out.println(": true");
                            connections++;
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                        } else if (!board[rowCounter][colCounter].equalsIgnoreCase("X")) {
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                            //System.out.print("\n");
                            connections = 0;
                        }
                    }
                }
                //System.out.println("Total num of connections for Player 1 of Some Diag: " + maxConnection);
                if (maxConnection == connectNum) {
                    return true;
                }
                //TODO: code right-left diagonals checking

            case 2:
                connections = 0;
                for (int i = 0; i < numOfRows; i++) {
                    for (int j = 0; j < numOfColumns; j++) {
                        if (board[i][j].equalsIgnoreCase("O")) {
                            connections++;
                        } else if (!board[i][j].equalsIgnoreCase("O")) {
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                            connections = 0;
                        }
                    }
                }
                //System.out.println("Total num of connections for Player 1 Horiz: " + maxConnection);
                if (maxConnection == connectNum) {
                    return true;
                }
                //TODO: code vertical checking, check each column for connections
                connections = 0;
                maxConnection = 0;
                for (int i = 0; i < numOfColumns; i++) {
                    for (int j = 0; j < numOfRows; j++) {
                        if (board[j][i].equalsIgnoreCase("O")) {
                            connections++;
                        } else if (!board[j][i].equalsIgnoreCase("O")) {
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                            connections = 0;
                        }
                    }
                }
                //System.out.println("Total num of connections for Player 1 Vertical: " + maxConnection);
                if (maxConnection == connectNum) {
                    return true;
                }
                //TODO: code left-right diagonals checking
                connections = 0;
                maxConnection = 0;
                for (int i = 0; i < (numOfRows - (connectNum - 1)); i++) {
                    int rowCounter, colCounter;
                    for (rowCounter = i, colCounter = 0; rowCounter < numOfRows && colCounter < numOfColumns; rowCounter++, colCounter++) {
                        //System.out.print("Checking Index " + rowCounter + ", " + colCounter);
                        if (board[rowCounter][colCounter].equalsIgnoreCase("O")) {
                            //System.out.println(": true");
                            connections++;
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                        } else if (!board[rowCounter][colCounter].equalsIgnoreCase("O")) {
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                            //System.out.print("\n");
                            connections = 0;
                        }
                    }
                }
                //System.out.println("Total num of connections for Player 1 of Some Diag: " + maxConnection);
                if (maxConnection == connectNum) {
                    return true;
                }

                connections = 0;
                maxConnection = 0;
                for (int i = 0; i < (numOfColumns - (connectNum - 1)); i++) {
                    int rowCounter, colCounter;
                    for (rowCounter = 0, colCounter = i; rowCounter < numOfRows && colCounter < numOfColumns; rowCounter++, colCounter++) {
                        //System.out.print("Checking Index " + rowCounter + ", " + colCounter);
                        if (board[rowCounter][colCounter].equalsIgnoreCase("O")) {
                            //System.out.println(": true");
                            connections++;
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                        } else if (!board[rowCounter][colCounter].equalsIgnoreCase("O")) {
                            if (connections > maxConnection) {
                                maxConnection = connections;
                            }
                            //System.out.print("\n");
                            connections = 0;
                        }
                    }
                }
                //System.out.println("Total num of connections for Player 1 of Some Diag: " + maxConnection);
                if (maxConnection == connectNum) {
                    return true;
                }
        }

        return victory;
    }

    public void displayBoard() {
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
