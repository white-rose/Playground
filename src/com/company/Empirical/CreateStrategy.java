package com.company.Empirical;

import com.company.Empirical.TicTacToe.Board;
import com.company.Empirical.TicTacToe.MarkerType;
import com.company.Empirical.polygon.Point;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CreateStrategy {

    public static Point findBestMove (MarkerType type, Board board) {

        //find all previous moves
        filterMoves(getPreviousMoves(board));
        boolean isFirst = determineFirstPlayer(type, board);

        //Returns a random play
//        return EmpiricalStrategy.randomPlay(boareee

        return new Point(0,0);
    }

    private static void filterMoves (List<int []> previousMoves) {

        List<int []> extractedMoves = new ArrayList<>();

        File file = new File("/Users/nathannguyen/Documents/Code/Test/src/com/company/Empirical/LotsOfGamesOfRandomPlayers.txt");

        int start = 4;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String st;
            while ((st = bufferedReader.readLine()) != null) {
                if (st.contains("WIN")) {

                   String[] tokens = st.split(" ");

                   for (int i = start; i <= start+previousMoves.size()-1; i++) {
                       String xy = tokens[i].replaceAll("\\D+","");
                       if (!xy.isEmpty()) {
                           String[] xyTokens = xy.split("");
                           extractedMoves.add(new int[]{
                                   Integer.valueOf(xyTokens[0]),
                                   Integer.valueOf(xyTokens[1])
                           });
                       }
                   }

                   if (areEqual(previousMoves, extractedMoves)) {
                       System.out.println("Match found");
                   }


                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static boolean areEqual(List<int[]> previousMoves, List<int[]> extractedMoves) {

        boolean areEqual = true;

        if (previousMoves.size() == 0)
            return false;

        for (int i = 0; i < previousMoves.size(); i++) {
            for (int k = 0; k < extractedMoves.size(); k++) {
                if (Arrays.equals(extractedMoves.get(i), extractedMoves.get(k))) {
                    extractedMoves.set(i, new int[]{-1});
                    extractedMoves.set(k, new int[]{-1});
                }
            }
        }

        for (int [] values: extractedMoves) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != -1) {
                    areEqual = false;
                }
            }
        }

        extractedMoves.clear();

        return areEqual;
    }


    private static Map printMoves(MarkerType type, Board board) {
        Map<MarkerType, Integer> moves = new HashMap<>();
        moves.put(MarkerType.X, 0);
        moves.put(MarkerType.O, 0);

        for (int i = 0; i < board.getCells().length; i++) {
            for (int k = 0; k < board.getCells()[i].length; k++) {
                if (board.getCells()[i][k].getType() != null) {
                    if (board.getCells()[i][k].getType().equals(MarkerType.O)) {
                        Integer addOne = moves.get(MarkerType.O);
                        addOne += 1;
                        moves.put(MarkerType.O, addOne);
                    } else if (board.getCells()[i][k].getType().equals(MarkerType.X)) {
                        Integer addOne = moves.get(MarkerType.X);
                        addOne += 1;
                        moves.put(MarkerType.X, addOne);
                    }
                }
            }
        }

        System.out.println("The number of X's is " + moves.get(MarkerType.X) + " and The number of O's is " + moves.get(MarkerType.O));
        return moves;
    }

    private static List getPreviousMoves (Board board) {

        List<int []> previousMoves = new ArrayList<>();

        for (int i = 0; i < board.getCells().length; i++) {
            for (int k = 0; k < board.getCells()[i].length; k++) {
                if (board.getCells()[i][k].getType() != null) {
                     previousMoves.add(new int[] {
                             i,k
                     });
                }
            }
        }

        return previousMoves;

    }

    private static boolean determineFirstPlayer(MarkerType type, Board board) {

        for (int i = 0; i < board.getCells().length; i++) {
            for (int k = 0; k < board.getCells()[i].length; k++) {
                if (board.getCells()[i][k].getType() != null) {
                    return false;
                }
            }
        }

        return true;
    }

    private void printBoard(Board board) {

        // Print the board
        for (int i = 0; i < board.getCells().length; i++) {
            for (int k = 0; k < board.getCells()[i].length; k++) {
                System.out.println(board.getCells()[i][k].getType());
            }
        }

    }


}

class GameHistory {

    String outcome;
    MarkerType wentFirst;
    List<Arrays> moves = new ArrayList<>();

    public GameHistory(MarkerType wentFirst, List<Arrays> moves) {
        this.outcome = outcome;
        this.wentFirst = wentFirst;
        this.moves = moves;
    }
}

