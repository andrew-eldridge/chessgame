/*
    Stores information on board state
 */

import java.util.Map;
import java.util.HashMap;

public class Board {

    // Board dimensions
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    // Instanced variables
    private Map<Position, Piece> board;

    // Initialize empty board
    public Board() {
        board = new HashMap<Position, Piece>();
        initPieces();
    }

    // Initialize pieces on game board
    private void initPieces() {
        // White pieces
        board.put(Position.A1, new Rook(Color.WHITE));
        board.put(Position.B1, new Knight(Color.WHITE));
        board.put(Position.C1, new Bishop(Color.WHITE));
        board.put(Position.D1, new Queen(Color.WHITE));
        board.put(Position.E1, new King(Color.WHITE));
        board.put(Position.F1, new Bishop(Color.WHITE));
        board.put(Position.G1, new Knight(Color.WHITE));
        board.put(Position.H1, new Rook(Color.WHITE));
        board.put(Position.A2, new Pawn(Color.WHITE));
        board.put(Position.B2, new Pawn(Color.WHITE));
        board.put(Position.C2, new Pawn(Color.WHITE));
        board.put(Position.D2, new Pawn(Color.WHITE));
        board.put(Position.E2, new Pawn(Color.WHITE));
        board.put(Position.F2, new Pawn(Color.WHITE));
        board.put(Position.G2, new Pawn(Color.WHITE));
        board.put(Position.H2, new Pawn(Color.WHITE));
        // Black pieces
        board.put(Position.A8, new Rook(Color.BLACK));
        board.put(Position.B8, new Knight(Color.BLACK));
        board.put(Position.C8, new Bishop(Color.BLACK));
        board.put(Position.D8, new Queen(Color.BLACK));
        board.put(Position.E8, new King(Color.BLACK));
        board.put(Position.F8, new Bishop(Color.BLACK));
        board.put(Position.G8, new Knight(Color.BLACK));
        board.put(Position.H8, new Rook(Color.BLACK));
        board.put(Position.A7, new Pawn(Color.BLACK));
        board.put(Position.B7, new Pawn(Color.BLACK));
        board.put(Position.C7, new Pawn(Color.BLACK));
        board.put(Position.D7, new Pawn(Color.BLACK));
        board.put(Position.E7, new Pawn(Color.BLACK));
        board.put(Position.F7, new Pawn(Color.BLACK));
        board.put(Position.G7, new Pawn(Color.BLACK));
        board.put(Position.H7, new Pawn(Color.BLACK));
    }

    // Return current board state
    public Map<Position, Piece> getBoardState() {
        return this.board;
    }

}
