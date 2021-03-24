/* Command line based "4-Gewinnt" game made in Java
 * Authors: Christian Fröhlich, Fabian Hammerschmidt, Felix Golatofski
 * Date: 2021-03-19
 */

import java.io.IOException;

public class ConnectFour {

    static final char player1 = 'X';
    static final char player2 = 'O';
    static boolean isPlayer1Turn = true;

    public ConnectFour() {
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Connect Four's best command line implementation!");

        GameBoard board = new GameBoard(8, 8);
        boolean nextStep = true;
        while (board.getGameOver() == '.') {
            try {
                int width = System.in.read();
                if (width < 20) {
                	nextStep = true;
                    continue;
                }
                if (!nextStep) {
                	continue;
                }
                if (width < 49 || width > 57) {
                    throw new ClassCastException();
                }
                if (board.placeStone(width - 49, isPlayer1Turn ? player1 : player2)) {
                    isPlayer1Turn = !isPlayer1Turn;
                    nextStep=false;
                } else {
                    System.out.println("Did you even play this game once?");
                }
            } catch (ClassCastException e1) {            	
                System.out.println("Only the numbers shown on the game board are allowed!");
            } catch (IOException e2) {
                System.out.println("The System threw an exception based on your input. What the heck are you doing?");
            }
        }
    }
}