package com.crystal.Empirical;

import com.crystal.Empirical.Human.HumanPlayer;
import com.crystal.Empirical.TicTacToe.Board;
import com.crystal.Empirical.TicTacToe.MarkerType;
import com.crystal.Empirical.TicTacToe.Player;
import com.crystal.Empirical.polygon.Point;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // make players
        new HumanPlayer("Doug");
        new HumanPlayer("Prateek");
        new HumanPlayer("Lauren");
        new EmpiricalStrategy("Robot");
        ArrayList<Player> playerList = Player.getPlayers();

        System.out.println("Welcome to Tic Tac Toe");
        Board board = new Board();
        Player[] players = new Player[2];

        while(true) {
            System.out.println("New Game");
            board.reset();

            for (int i = 0; i < 2; i++) {
                while (players[i] == null) {
                    System.out.println("Select Player#" + i
                            + "[" + (i == 0 ? MarkerType.X : MarkerType.O) + "'s]");
                    for (int j = 0; j < playerList.size(); j++) {
                        if (i == 1 && playerList.get(j) == players[0]) {
                            continue;
                        }
                        System.out.println(j + "." + playerList.get(j).getName());
                    }
                    String playerChoice = scanner.nextLine();
                    int numberChoice = 0;
                    try {
                        numberChoice = Integer.parseInt(playerChoice);
                    } catch (NumberFormatException e) {
                        System.out.println("You must make a choice between 0 and " + (playerList.size() - 1));
                        continue;
                    }
                    players[i] = playerList.get(numberChoice);
                }
            }

            //play game
            int currentPlayer = 1;
            while (board.hasNextPlay()) {
                currentPlayer = (currentPlayer + 1) % 2;
                MarkerType currentType = currentPlayer == 0 ? MarkerType.X : MarkerType.O;
                boolean playOk = false;
                while (!playOk) {

                    
                    Point point = players[currentPlayer].getPlay(currentType, board);
                    System.out.println("Player #" + currentPlayer
                            + " " + players[currentPlayer].getName() + " plays at " + point);
                    playOk = board.playMarker(currentType, point.getX(), point.getY());
                    if (!playOk) {
                        System.out.println("Invalid play, try again");
                    }
                }
            }
            if (board.hasWinner()) {
               System.out.println("Player #" + currentPlayer + " won!");
            } else {
                System.out.println("Game ended in a tie.");
            }
            System.out.print("Any key to continue or Q to quit: ");
            String toContinue = scanner.nextLine();
            if (toContinue.toUpperCase().equals("Q")) {
                break;
            }
        }
        System.out.println("Bye");

    }

}
