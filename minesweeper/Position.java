public class Position {
    int adjacentMines;
    boolean isBomb;
    boolean isFlagged;
    boolean isRevealed;

    public Position(int adjacentMines, boolean isBomb, boolean isFlagged, boolean isRevealed) {
        this.adjacentMines = adjacentMines;
        this.isBomb = isBomb;
        this.isFlagged = isFlagged;
        this.isRevealed = isRevealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public boolean isRevealed() {
        return isRevealed;
    }
}