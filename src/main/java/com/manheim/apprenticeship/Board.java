package com.manheim.apprenticeship;

public class Board {
    private Target[][] gameBoard = new Target[5][5];
    public static final int MAX_NUMBER_OF_HITS = 22;
    public static final int NUMBER_OF_SHIPS = 3;

    private int numberOfHits = 0;
    private int numberOfSunkenShips = 0;


    public void buildBoard() {
        for (int row = 0; row < gameBoard.length; row++) {

            for (int col = 0; col < gameBoard[row].length; col++) {
                Target target = new Target();
                target.setDisplayIcon("--");
                target.setHit(false);
                gameBoard[row][col] = target;
            }
        }

    }

    public void printBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                Target target = gameBoard[row][col];
                if (target.getDisplayIcon().equals("O")) {
                    if (target.isHit()) {
                        System.out.print("O\t");
                    } else {
                        System.out.print("--\t");
                    }
                } else {
                    System.out.print(target.getDisplayIcon() + "\t");
                }

            }
            System.out.println();
        }
    }


    public void setComputerCoordinates() {
        int shipCounter = 0;
        while (shipCounter < NUMBER_OF_SHIPS) {
            int computerRow = (int) (Math.random() * 4);
            int computerCol = (int) (Math.random() * 4);
//            System.out.println(computerRow + " " + computerCol);
//            System.out.println(gameBoard[computerRow][computerCol].isHit());
            if (!gameBoard[computerRow][computerCol].getDisplayIcon().equals("O")) {
                gameBoard[computerRow][computerCol].setDisplayIcon("O");
                shipCounter++;
            }

        }

    }

    public void setUserCoordinates(int userRow, int userCol) {
        numberOfHits++;
        if (gameBoard[userRow][userCol].getDisplayIcon().equals("O")) {
            gameBoard[userRow][userCol].setHit(true);
            numberOfSunkenShips++;
        } else {
            gameBoard[userRow][userCol].setDisplayIcon("X");

        }
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    public void setNumberOfHits(int numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public int getNumberOfSunkenShips() {
        return numberOfSunkenShips;
    }

    public void setNumberOfSunkenShips(int numberOfSunkenShips) {
        this.numberOfSunkenShips = numberOfSunkenShips;
    }
}
