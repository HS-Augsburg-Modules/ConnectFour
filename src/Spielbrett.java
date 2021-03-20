public class Spielbrett {
    private char[][] brett;
    private char gameOver = '.';

    public char[][] getBrett() {
        return brett;
    }

    public void setBrett(char[][] brett) {
        this.brett = brett;
    }

    /***
     * Constructor for Spielbrett
     * @param width
     * @param height
     * initialize with '.' for whole Spielbrett
     */
    public Spielbrett(int width, int height) {
        brett = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                brett[i][j] = '.';
            }
        }
    }

    /***
     * Method for checking win conditions
     *
     *
     * @param width
     * @param height
     * @return
     */
    private char checkWin(int width, int height) {
        char player = brett[width][height];

        int wCounter = 1;
        int hCounter = 1;
        int lbTrt = 1;
        int rbTlt = 1;

        for (int i = width + 1; i < getBrett().length; i++) {
            if (getBrett()[i][height] == player) {
                wCounter++;
            } else {
                break;
            }
        }
        for (int i = width - 1; i >= 0; i--) {
            if (getBrett()[i][height] == player) {
                wCounter++;
            } else {
                break;
            }
        }
        if (wCounter >= 4) {
            return player;
        }
        for (int i = height - 1; i >= 0; i--) {
            if (getBrett()[width][i] == player) {
                hCounter++;
            } else {
                break;
            }
        }
        if (hCounter >= 4) {
            return player;
        }

        for (int i = 1; i <= 3; i++) {
            int currWidthP = width + i;
            int currHeightP = height + i;
            int currWidthN = width - i;
            int currHeightN = height - i;
            boolean f1 = true;
            boolean f2 = true;
            boolean f3 = true;
            boolean f4 = true;

            if (currWidthP < getBrett().length) {
                if (f1 && currHeightP < getBrett()[0].length && getBrett()[currWidthP][currHeightP] == player) {
                    lbTrt++;
                } else {
                    f1 = false;
                }
                if (f2 && currHeightN >= 0 && getBrett()[currWidthP][currHeightN] == player) {
                    rbTlt++;
                } else {
                    f2 = false;
                }
            }
            if (currWidthN >= 0) {
                if (f3 && currHeightN >= 0 && getBrett()[currWidthN][currHeightN] == player) {
                    lbTrt++;
                } else {
                    f3 = false;
                }
                if (f4 && currHeightP < getBrett()[0].length && getBrett()[currWidthN][currHeightP] == player) {
                    rbTlt++;
                } else {
                    f4 = false;
                }
            }
        }

        if (rbTlt >= 4 || lbTrt >= 4) {
            return player;
        }
        return '.';
    }

    public boolean placeStone(int place, char player) {
        for (int i = 0; i < getBrett()[place].length; i++) {
            if (getBrett()[place][i] == '.') {
                getBrett()[place][i] = player;
                gameOver = checkWin(place, i);
                paintMe();
                return true;
            }
        }
        return false;
    }

    private void paintMe() {
        int height = getBrett()[0].length;
        int width = getBrett().length;

        for (int i = 0; i < getBrett().length; i++) {
            System.out.print(i + 1);
        }
        System.out.println();

        for (int i = height; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                System.out.print(brett[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < getBrett().length; i++) {
            System.out.print(i + 1);
        }
        if (gameOver != '.') {
            System.out.println("Player " + "has won" );
        }
    }
}