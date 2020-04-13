/*
    Error to be thrown when an invalid position is used to initialize a piece
 */

package chess.errors;

import chess.Position;

public class InvalidPiecePositionError extends Error {

    public InvalidPiecePositionError() {
        super("Invalid position given for piece.");
    }
    public InvalidPiecePositionError(Position pos) {
        super(String.format("Invalid position given for piece: [%d, %d]", pos.getX(), pos.getY()));
    }

}
