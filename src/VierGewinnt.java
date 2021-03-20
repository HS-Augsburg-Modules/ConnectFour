/* Command line based "4-Gewinnt" game made in Java
 * Authors: Christian Fröhlich, Fabian Hammerschmidt, Felix Golatofski
 * Date: 2021-03-19
 */

public class VierGewinnt {
    public static void main(String[] args) {

        System.out.println("Welcome to the best command line implementation of \"Connect Four\"!");

        Spielbrett brett = new Spielbrett(8,8);
    }
    public char[][] spielbrett;
    public VierGewinnt() {

    }
}