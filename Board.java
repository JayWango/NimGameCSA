public class Board {
    private static int boardPieces;
    
    public static void populate() {
        boardPieces = (int) ((Math.random() * 41) + 10);
    }
    public static int getBoardPieces() {
        return boardPieces;
    }
    public static void removeBoardPieces(int pieces) {
        boardPieces -= pieces;
    }
}