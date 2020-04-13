/*
    Stores information on board state
 */

package chess;

import chess.pieces.*;

import java.util.Map;
import java.util.HashMap;

public class Board {

    // Board dimensions
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    public static final int DIAGONAL = 8;

    // Instanced variables
    private Map<Position, Piece> boardState;

    // Initialize empty board
    public Board() {
        boardState = new HashMap<Position, Piece>();
        initPieces();
    }

    // Initialize pieces on game board
    private void initPieces() {
        // White pieces
        boardState.put(Position.A1, new Rook(Color.WHITE, Position.A1));
        boardState.put(Position.B1, new Knight(Color.WHITE, Position.B1));
        boardState.put(Position.C1, new Bishop(Color.WHITE, Position.C1));
        boardState.put(Position.D1, new Queen(Color.WHITE, Position.D1));
        boardState.put(Position.E1, new King(Color.WHITE, Position.E1));
        boardState.put(Position.F1, new Bishop(Color.WHITE, Position.F1));
        boardState.put(Position.G1, new Knight(Color.WHITE, Position.G1));
        boardState.put(Position.H1, new Rook(Color.WHITE, Position.H1));
        boardState.put(Position.A2, new Pawn(Color.WHITE, Position.A2));
        boardState.put(Position.B2, new Pawn(Color.WHITE, Position.B2));
        boardState.put(Position.C2, new Pawn(Color.WHITE, Position.C2));
        boardState.put(Position.D2, new Pawn(Color.WHITE, Position.D2));
        boardState.put(Position.E2, new Pawn(Color.WHITE, Position.E2));
        boardState.put(Position.F2, new Pawn(Color.WHITE, Position.F2));
        boardState.put(Position.G2, new Pawn(Color.WHITE, Position.G2));
        boardState.put(Position.H2, new Pawn(Color.WHITE, Position.H2));
        // Black pieces
        boardState.put(Position.A8, new Rook(Color.BLACK, Position.A8));
        boardState.put(Position.B8, new Knight(Color.BLACK, Position.B8));
        boardState.put(Position.C8, new Bishop(Color.BLACK, Position.C8));
        boardState.put(Position.D8, new Queen(Color.BLACK, Position.D8));
        boardState.put(Position.E8, new King(Color.BLACK, Position.E8));
        boardState.put(Position.F8, new Bishop(Color.BLACK, Position.F8));
        boardState.put(Position.G8, new Knight(Color.BLACK, Position.G8));
        boardState.put(Position.H8, new Rook(Color.BLACK, Position.H8));
        boardState.put(Position.A7, new Pawn(Color.BLACK, Position.A7));
        boardState.put(Position.B7, new Pawn(Color.BLACK, Position.B7));
        boardState.put(Position.C7, new Pawn(Color.BLACK, Position.C7));
        boardState.put(Position.D7, new Pawn(Color.BLACK, Position.D7));
        boardState.put(Position.E7, new Pawn(Color.BLACK, Position.E7));
        boardState.put(Position.F7, new Pawn(Color.BLACK, Position.F7));
        boardState.put(Position.G7, new Pawn(Color.BLACK, Position.G7));
        boardState.put(Position.H7, new Pawn(Color.BLACK, Position.H7));
    }

    // Return current board state
    public Map<Position, Piece> getBoardState() {
        return this.boardState;
    }

}
