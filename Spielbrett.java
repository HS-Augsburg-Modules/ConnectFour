public class Spielbrett {
    private char[][] brett;
    public Spielbrett(int width, int height) {
        brett = new char[width][height];
    }

    public char[][] getBrett() {
        return brett;
    }

    public void setBrett(char[][] brett) {
        this.brett = brett;
    }

    public boolean checkWin() {
        return false;
    }

    public boolean placeStone(int place, char player) {
        boolean hasSet = false;
        for (int i = 0; i < getBrett()[place].length; ++i) {
            if (getBrett()[place][i] == '.') {
                getBrett()[place][i] = player;
                hasSet = true;
            }
            return hasSet;
        }

    }
}