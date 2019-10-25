/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge;

/**
 *
 * @author mathew.levasseur
 */
public class ChallengeQuestion {

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

        return input;
    }

}
