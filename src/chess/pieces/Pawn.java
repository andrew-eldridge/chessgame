/*
    Pawn piece
 */

package chess.pieces;

import chess.*;
import chess.errors.InvalidPieceColorError;
import chess.errors.InvalidPiecePositionError;

public class Pawn extends GenericPiece {

    // Constants
    public static final int VALUE = 1;

    // Attributes
    private String color;
    private Position position;

    // Constructor
    public Pawn(String color, Position pos) {
        super(color);
        initPosition(pos);
    }
    private void initPosition(Position pos) throws InvalidPiecePositionError, InvalidPieceColorError {
        if (this.color.equals(Color.WHITE)) {
            if (pos.getY() == 6) {
                setPosition(pos);
            } else {
                throw new InvalidPiecePositionError(pos);
            }
        } else if (this.color.equals(Color.BLACK)) {
            if (pos.getY() == 1) {
                setPosition(pos);
            } else {
                throw new InvalidPiecePositionError(pos);
            }
        } else {
            // There should be no way to get here...
            throw new InvalidPieceColorError(this.color);
        }
    }

    // Getters
    public String getColor() {
        return super.getColor();
    }
    public Position getPosition() {
        return super.getPosition();
    }

    // Setters
    public void setColor(String color) throws InvalidPieceColorError {
        super.setColor(color);
    }
    public void setPosition(Position pos) throws InvalidPiecePositionError {
        super.setPosition(pos);
    }

    // Move piece to a given position
    public void move(Position pos) {
        super.move(pos);
    }

    // Return an array of available positions
    @Override
    public Position[] getMoves(Board b) {
        // Pawns can move 1 forward, can take 1 diagonally (including en passant)
        Position[] moves = Position.getPawnMoves(this, b);
        return Position.combinePositionEnumerations(moves);
    }

    // Indicates whether given piece is on opposing team
    public boolean isOpposing(Piece p) {
        return super.isOpposing(p);
    }

}
