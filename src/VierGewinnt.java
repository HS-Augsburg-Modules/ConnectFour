/* Command line based "4-Gewinnt" game made in Java
 * Authors: Christian Fröhlich, Fabian Hammerschmidt, Felix Golatofski
 * Date: 2021-03-19
 */

import java.io.IOException;

public class VierGewinnt {

    static final char player1 = 'X';
    static final char player2 = 'O';
    static boolean isPlayer1Turn = true;

    public static void main(String[] args) {

        System.out.println("Welcome to the best command line implementation of \"Connect Four\"!");

        Spielbrett brett = new Spielbrett(8, 8);
        while (brett.getGameOver() == '.') {
            try {
                int width = System.in.read();
                if (width == 10) {
                    continue;
                }
                if (width < 49 || width > 57) {
                    throw new ClassCastException();
                }
                if (brett.placeStone(width - 49, isPlayer1Turn ? player1 : player2)) {
                    isPlayer1Turn = !isPlayer1Turn;
                } else {
                    System.out.println("Hast du das Spiel eigentlich schon mal gespielt du Mongo?!");
                }
            } catch (ClassCastException e1) {
                System.out.println("Hey du verrückter dummer Affe gib eine Zahl ein und keinen Buchstaben!");
            } catch (IOException e2) {
                System.out.println("Was machst du für eine verrückte Scheiße?");
            }
        }
    }

    public VierGewinnt() {
    }
}