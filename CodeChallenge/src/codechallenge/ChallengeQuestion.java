/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge;

import java.util.HashSet;


/**
 *
 * @author mathew.levasseur
 */
public class ChallengeQuestion {

    private static final int K = 127;
    private static final int W = -1;
    private static int rowLength;
    private static int[] direction;

    /**
     * A Chess King stands on his board and wants to know how long it will
     * take him to walk to each square from his starting position.  Walls have
     * started to appear in his kingdom and can potentially make it impossible
     * for the king to reach a square.
     *
     * Given a SQUARE, one-dimensional array representing the King's board,
     * calculate the minimum steps it will take for the king to reach each
     * square from his STARTING position.  Like in the game of chess, the King
     * may move in any direction (forwards, backwards, diagonally,
     * orthogonally).  The king may only move one square at a time.
     *
     * preset values:
     *   127 = King start position
     *    -1 = A wall, the king cannot move through these
     *     0 = Unvisited location
     *
     * Example:
     *   input: {0, 0, W, 0,
     *           K, 0, W, W,
     *           0, W, 0, 0,
     *           0, W, 0, 0}
     *   output: {1, 1, W, 0,
     *            K, 1, W, W,
     *            1, W, 2, 3,
     *            2, W, 3, 3}
     *
     * @param input
     * @return
     */
    public int[] answer(int[] input) {
        // For easier array navigation
        rowLength = (int) Math.sqrt(input.length);
        direction = new int[]{1, -1, rowLength, -rowLength, 1 - rowLength, 1 + rowLength, rowLength - 1, -rowLength - 1};

        // Maintain a list of visited and unvisited nodes
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> notVisited = new HashSet<>();
        int visitedSize;
        int notVisitedSize;

        // Repeatedly iterate over the map until we haven't made an update to
        // our visited and notVisited caches.
        do {
            visitedSize = visited.size();
            notVisitedSize = notVisited.size();

            // Iterate through the map, checking each neighbour of the current node.
            // If our current position is a 0 and we see a non-zero neighbour,
            // update the current node's value to MIN(each neighbour's value) + 1.
            for (int i = 0; i < input.length; i++) {
                if (visited.contains( i )) {
                    continue;
                }
                switch (input[i]) {
                    case W:
                        visited.add(i);
                    case K:
                        break;
                    default:
                        if(this.checkNeighbours(i, input)) {
                            visited.add(i);
                            notVisited.remove(i);
                        } else {
                            notVisited.add(i);
                        }
                }
            }
        } while (visitedSize != visited.size() && notVisitedSize != notVisited.size());

        return input;
    }

    /**
     * Returns true if we made an update to the board, false otherwise.
     * Because of the way we call this, board[index] is always a valid square.
     *
     * Check in each valid direction for a value > board[index].  Take the
     * minimum and set board[index] to that minimum + 1 (127 being an
     * exception, as this is the King's square meaning we should set our
     * current square to a 1.
     */
    private boolean checkNeighbours(int index, int[] board) {
        int minValue = board[index] == 0 ? 255 : board[index];

        for (int i = 0; i < direction.length; i++) {
            if (validMove(i, index, board.length)) {
                int neighbourIndex = index + direction[i];
                if (board[neighbourIndex] > 0) {
                    if (board[neighbourIndex] == K) {
                        minValue = 0;
                    } else {
                        minValue = minValue < board[neighbourIndex]
                                   ? minValue
                                   : board[neighbourIndex];
                    }
                }
            }
        }

        if (minValue != 255) {
            if (board[index] == 0) {
                board[index] = minValue + 1;
                return true;
            } else if (board[index] - minValue > 1) {
                board[index] = minValue + 1;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean validMove(int step, int currentLocation, int boardLength) {
        int nextStep = currentLocation + direction[step];
        switch (step) {
            case 0: // Right.
                return nextStep % rowLength != 0;
            case 1: // Left.
                return nextStep >= 0 && nextStep % rowLength != (rowLength - 1);
            case 2: // Down.
                return nextStep < boardLength;
            case 3: // Up.
                return nextStep >= 0;
            case 4: // Up-right.
                return nextStep >= 0 && nextStep % rowLength != 0;
            case 5: // Down-right.
                return nextStep < boardLength && nextStep % rowLength != 0;
            case 6: // Down-left.
                return nextStep < boardLength && nextStep % rowLength != (rowLength - 1);
            case 7: // Up-left.
                return nextStep >= 0 && nextStep % rowLength != (rowLength - 1);
            default:
                return false;
        }
    }

}
