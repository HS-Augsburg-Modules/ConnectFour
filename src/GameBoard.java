public class GameBoard {
    private char[][] board;
    private char gameOver = '.';

    /***
     * Constructor for GameBoard
     * @param width
     * @param height
     * initialize with '.' for whole GameBoard
     */
    public GameBoard(int width, int height) {
        board = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = '.';
            }
        }
        printGame();
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getGameOver() {
        return gameOver;
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
        char player = board[width][height];

        int wCounter = 1;
        int hCounter = 1;
        int lbTrt = 1;
        int rbTlt = 1;

        for (int i = width + 1; i < getBoard().length; i++) {
            if (getBoard()[i][height] == player) {
                wCounter++;
            } else {
                break;
            }
        }
        for (int i = width - 1; i >= 0; i--) {
            if (getBoard()[i][height] == player) {
                wCounter++;
            } else {
                break;
            }
        }
        if (wCounter >= 4) {
            return player;
        }
        for (int i = height - 1; i >= 0; i--) {
            if (getBoard()[width][i] == player) {
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

            if (currWidthP < getBoard().length) {
                if (f1 && currHeightP < getBoard()[0].length && getBoard()[currWidthP][currHeightP] == player) {
                    lbTrt++;
                } else {
                    f1 = false;
                }
                if (f2 && currHeightN >= 0 && getBoard()[currWidthP][currHeightN] == player) {
                    rbTlt++;
                } else {
                    f2 = false;
                }
            }
            if (currWidthN >= 0) {
                if (f3 && currHeightN >= 0 && getBoard()[currWidthN][currHeightN] == player) {
                    lbTrt++;
                } else {
                    f3 = false;
                }
                if (f4 && currHeightP < getBoard()[0].length && getBoard()[currWidthN][currHeightP] == player) {
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
        for (int i = 0; i < getBoard()[place].length; i++) {
            if (getBoard()[place][i] == '.') {
                getBoard()[place][i] = player;
                gameOver = checkWin(place, i);
                printGame();
                return true;
            }
        }
        return false;
    }

    private void printGame() {
        int height = getBoard()[0].length;
        int width = getBoard().length;

        for (int i = 0; i < getBoard().length; i++) {
            System.out.print(i + 1);
        }
        System.out.println();

        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[j][i]);
            }
            System.out.println();
        }
        for (int i = 0; i < getBoard().length; i++) {
            System.out.print(i + 1);
        }
        System.out.println();
        if (gameOver != '.') {
            System.out.println("The player with the sign " + gameOver + "wins. Congratulations!");
        }
    }
}