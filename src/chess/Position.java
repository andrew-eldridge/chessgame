/*
    Object representation of 2D-graphical position
 */

package chess;

import java.util.Map;

public class Position {

    // A file
    public static final Position A1 = new Position(7, 0);
    public static final Position A2 = new Position(6, 0);
    public static final Position A3 = new Position(5, 0);
    public static final Position A4 = new Position(4, 0);
    public static final Position A5 = new Position(3, 0);
    public static final Position A6 = new Position(2, 0);
    public static final Position A7 = new Position(1, 0);
    public static final Position A8 = new Position(0, 0);

    // B file
    public static final Position B1 = new Position(7, 1);
    public static final Position B2 = new Position(6, 1);
    public static final Position B3 = new Position(5, 1);
    public static final Position B4 = new Position(4, 1);
    public static final Position B5 = new Position(3, 1);
    public static final Position B6 = new Position(2, 1);
    public static final Position B7 = new Position(1, 1);
    public static final Position B8 = new Position(0, 1);

    // C file
    public static final Position C1 = new Position(7, 2);
    public static final Position C2 = new Position(6, 2);
    public static final Position C3 = new Position(5, 2);
    public static final Position C4 = new Position(4, 2);
    public static final Position C5 = new Position(3, 2);
    public static final Position C6 = new Position(2, 2);
    public static final Position C7 = new Position(1, 2);
    public static final Position C8 = new Position(0, 2);

    // D file
    public static final Position D1 = new Position(7, 3);
    public static final Position D2 = new Position(6, 3);
    public static final Position D3 = new Position(5, 3);
    public static final Position D4 = new Position(4, 3);
    public static final Position D5 = new Position(3, 3);
    public static final Position D6 = new Position(2, 3);
    public static final Position D7 = new Position(1, 3);
    public static final Position D8 = new Position(0, 3);

    // E file
    public static final Position E1 = new Position(7, 4);
    public static final Position E2 = new Position(6, 4);
    public static final Position E3 = new Position(5, 4);
    public static final Position E4 = new Position(4, 4);
    public static final Position E5 = new Position(3, 4);
    public static final Position E6 = new Position(2, 4);
    public static final Position E7 = new Position(1, 4);
    public static final Position E8 = new Position(0, 4);

    // F file
    public static final Position F1 = new Position(7, 5);
    public static final Position F2 = new Position(6, 5);
    public static final Position F3 = new Position(5, 5);
    public static final Position F4 = new Position(4, 5);
    public static final Position F5 = new Position(3, 5);
    public static final Position F6 = new Position(2, 5);
    public static final Position F7 = new Position(1, 5);
    public static final Position F8 = new Position(0, 5);

    // G file
    public static final Position G1 = new Position(7, 6);
    public static final Position G2 = new Position(6, 6);
    public static final Position G3 = new Position(5, 6);
    public static final Position G4 = new Position(4, 6);
    public static final Position G5 = new Position(3, 6);
    public static final Position G6 = new Position(2, 6);
    public static final Position G7 = new Position(1, 6);
    public static final Position G8 = new Position(0, 6);

    // H file
    public static final Position H1 = new Position(7, 7);
    public static final Position H2 = new Position(6, 7);
    public static final Position H3 = new Position(5, 7);
    public static final Position H4 = new Position(4, 7);
    public static final Position H5 = new Position(3, 7);
    public static final Position H6 = new Position(2, 7);
    public static final Position H7 = new Position(1, 7);
    public static final Position H8 = new Position(0, 7);

    // Boundaries
    public static final int DIR_MAX = 7;
    public static final int DIR_MIN = 0;

    // Attributes
    private int x;
    private int y;

    // Constructor
    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    // Getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    // Setters
    public void setX(int x) {
        if (x < DIR_MIN) {
            this.x = DIR_MIN-1;
        } else if (x > DIR_MAX) {
            this.x = DIR_MAX+1;
        } else {
            this.x = x;
        }
    }
    public void setY(int y) {
        if (y < DIR_MIN) {
            this.y = DIR_MIN-1;
        } else if (y > DIR_MAX) {
            this.y = DIR_MAX+1;
        } else {
            this.y = y;
        }
    }

    // Find horizontal movements at a given position
    public static Position[] getHorizontals(Piece p, Board b) {
        return getHorizontals(p,  b, Board.WIDTH);
    }
    public static Position[] getHorizontals(Piece p, Board b, int limit) {
        // Get piece position and board state
        Position start = p.getPosition();
        Map<Position, Piece> boardState = b.getBoardState();

        // Populate ret with horizontals
        Position[] ret = new Position[8];
        boolean continueLeft = true;
        boolean continueRight = true;
        for (int i=1; i<Board.WIDTH; i++) {
            // Initialize positions to be checked
            Position leftCheckPos = null;
            Position rightCheckPos = null;
            if (continueLeft && i<=limit) {
                leftCheckPos = new Position(start.x-i, start.y);
            }
            if (continueRight && i<=limit) {
                rightCheckPos = new Position(start.x+i, start.y);
            }
            // Leftward horizontal check
            if (leftCheckPos != null && isValid(leftCheckPos)) {
                Piece leftCheckVal = boardState.get(leftCheckPos);
                if (leftCheckVal == null) {
                    // Empty space found leftward, append to next empty slot in ret
                    appendToPositionArray(ret, leftCheckPos);
                } else if (leftCheckVal.isOpposing(p)) {
                    // Opposing piece found leftware, append to ret and indicate end of available leftward horizontals
                    appendToPositionArray(ret, leftCheckPos);
                    continueLeft = false;
                }
            }
            // Rightward horizontal check
            if (rightCheckPos != null && isValid(rightCheckPos)) {
                Piece rightCheckVal = boardState.get(rightCheckPos);
                if (rightCheckVal == null) {
                    // Empty space found leftward, append to next empty slot in ret
                    appendToPositionArray(ret, rightCheckPos);
                } else if (rightCheckVal.isOpposing(p)) {
                    // Opposing piece found rightward, append to ret and indicate end of available rightward horizontals
                    appendToPositionArray(ret, rightCheckPos);
                    continueRight = false;
                }
            }
        }
        return ret;
    }

    // Find vertical movements at a given position
    public static Position[] getVerticals(Piece p, Board b) {
        return getVerticals(p,  b, Board.HEIGHT);
    }
    public static Position[] getVerticals(Piece p, Board b, int limit) {
        // Get piece position and board state
        Position start = p.getPosition();
        Map<Position, Piece> boardState = b.getBoardState();

        // Populate ret with horizontals
        Position[] ret = new Position[8];
        boolean continueLeft = true;
        boolean continueRight = true;
        for (int i=0; i<Board.WIDTH; i++) {
            // Initialize positions to be checked
            Position leftCheckPos = null;
            Position rightCheckPos = null;
            if (continueLeft) {
                leftCheckPos = new Position(start.x-i, start.y);
            }
            if (continueRight) {
                rightCheckPos = new Position(start.x+i, start.y);
            }
            // Leftward horizontal check
            if (leftCheckPos != null && isValid(leftCheckPos)) {
                Piece leftCheckVal = boardState.get(leftCheckPos);
                if (leftCheckVal == null) {
                    // Empty space found leftward, append to next empty slot in ret
                    appendToPositionArray(ret, leftCheckPos);
                } else if (leftCheckVal.isOpposing(p)) {
                    // Opposing piece found leftware, append to ret and indicate end of available leftward horizontals
                    appendToPositionArray(ret, leftCheckPos);
                    continueLeft = false;
                }
            }
            // Rightward horizontal check
            if (rightCheckPos != null && isValid(rightCheckPos)) {
                Piece rightCheckVal = boardState.get(rightCheckPos);
                if (rightCheckVal == null) {
                    // Empty space found leftward, append to next empty slot in ret
                    appendToPositionArray(ret, rightCheckPos);
                } else if (rightCheckVal.isOpposing(p)) {
                    // Opposing piece found rightward, append to ret and indicate end of available rightward horizontals
                    appendToPositionArray(ret, rightCheckPos);
                    continueRight = false;
                }
            }
        }
        return ret;
    }

    // Append position value to next empty space in array
    private static void appendToPositionArray(Position[] arr, Position pos) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = pos;
                break;
            }
        }
    }

    // Find vertical movements at a given position

    // Combine non-null values from multiple position arrays
    public static Position[] combinePositionEnumerations(Position[] ... arrs) {
        int[] counts = new int[arrs.length];
        int size = 0;
        for (int i=0; i<arrs.length; i++) {
            for (int j=0; j<arrs[i].length; j++) {
                if (arrs[i][j] == null) {
                    counts[i] = j;
                    size += j;
                    break;
                }
            }
        }
        Position[] ret = new Position[size];
        int counter = 0;
        for (int i=0; i<counts.length; i++) {
            for (int j=0; j<counts[i]; j++) {
                ret[counter] = arrs[i][j];
                counter++;
            }
        }
        return ret;
    }

    // Determine whether a given position is valid
    private static boolean isValid (Position pos) {
        return pos.x>=DIR_MIN && pos.x<=DIR_MAX && pos.y>=DIR_MIN && pos.y<=DIR_MAX;
    }

    // Determine whether there are any more positions left/right/up/down from given position
    private static boolean isMoreLeft(Position pos) {
        return pos.x != DIR_MIN;
    }
    private static boolean isMoreRight(Position pos) {
        return pos.x != DIR_MAX;
    }
    private static boolean isMoreUp(Position pos) {
        return pos.y != DIR_MIN;
    }
    private static boolean isMoreDown(Position pos) {
        return pos.y != DIR_MAX;
    }

}
