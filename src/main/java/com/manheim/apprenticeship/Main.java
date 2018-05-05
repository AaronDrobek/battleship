package com.manheim.apprenticeship;

import java.util.Scanner;


public class Main {

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] arg) {
        Board board = new Board();
        board.buildBoard();
        board.setComputerCoordinates();

        System.out.println("*************************************");
        System.out.println("*************************************");
        System.out.println("*****WELCOME *******");
        System.out.println("*************TO*********************");
        System.out.println("*******************BATTLESHIP*********");
        System.out.println("*************************************");
        System.out.println("*************************************");


        board.printBoard();

        while (board.getNumberOfSunkenShips() <= Board.NUMBER_OF_SHIPS || board.getNumberOfHits() == Board.MAX_NUMBER_OF_HITS) {

            int remainingShips = Board.NUMBER_OF_SHIPS - board.getNumberOfSunkenShips();
            System.out.println(String.format("Remaning ships: %d      Number of shots fired:  %d", remainingShips, board.getNumberOfHits()));
            System.out.println("Enter Row Coordinate 1-5");
            int userRow = reader.nextInt() -1;
            System.out.println("Enter Column Coordinate 1-5");
            int userCol = reader.nextInt() -1;

            board.setUserCoordinates(userRow, userCol);
            board.printBoard();
        }

        if (board.getNumberOfSunkenShips() <= Board.NUMBER_OF_SHIPS) {
            System.out.println("yay! you are a winner!!!!~~~~");
        }
        //board for user using instance of board
        // board for comp using another instance of board
        //call buildBoard function

    }
}
