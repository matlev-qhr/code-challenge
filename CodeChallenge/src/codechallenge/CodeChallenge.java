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
public class CodeChallenge {

    private final static int K = 127;
    private final static int W = -1;

    private static final int[] q1 = {0, 0,
                                     0, K};
    private static final int[] a1 = {1, 1, 1, K};

    private static final int[] q2 = {0, 0, W,
                                     0, 0, 0,
                                     K, 0, W};
    private static final int[] a2 = {2, 2, W, 1, 1, 2, K, 1, W};

    private static final int[] q3 = {K, 0, W, 0,
                                     0, 0, W, 0,
                                     W, 0, 0, 0,
                                     0, W, 0, 0};
    private static final int[] a3 = {K, 1, W, 4, 1, 1, W, 3, W, 2, 2, 3, 3, W, 3, 3};

    private static final int[] q4 = {0, 0, 0, W, 0,
                                     0, 0, W, 0, 0,
                                     0, 0, 0, W, 0,
                                     W, W, W, 0, W,
                                     0, W, K, 0, 0};
    private static final int[] a4 = {4, 4, 4, W, 4, 4, 3, W, 3, 3, 4, 3, 2, W, 2, W, W, W, 1, W, 0, W, K, 1, 2};

    private static final int[] q5 = {W, W, W, 0, 0, W, 0, 0,
                                     W, 0, W, W, 0, 0, W, 0,
                                     W, 0, 0, W, W, 0, W, 0,
                                     W, 0, W, W, W, 0, W, W,
                                     W, W, W, 0, K, W, 0, 0,
                                     0, 0, W, 0, 0, W, W, 0,
                                     W, 0, W, W, 0, W, 0, W,
                                     0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] a5 = {W, W, W, 4, 4, W, 4, 5,
                                     W, 0, W, W, 3, 3, W, 5,
                                     W, 0, 0, W, W, 2, W, 6,
                                     W, 0, W, W, W, 1, W, W,
                                     W, W, W, 1, K, W, 2, 3,
                                     6, 6, W, 1, 1, W, W, 3,
                                     W, 5, W, W, 2, W, 4, W,
                                     6, 5, 4, 3, 3, 3, 4, 5};

    public static void main( String[] args ) throws Exception {
        ChallengeQuestion question = new ChallengeQuestion();

        long start = System.nanoTime();

        validate(question.answer(q1.clone()), a1);
        validate(question.answer(q2.clone()), a2);
        validate(question.answer(q3.clone()), a3);
        validate(question.answer(q4.clone()), a4);
        validate(question.answer(q5.clone()), a5);

        for (int i = 0; i < 100000; i++) {
            question.answer(q1.clone());
            question.answer(q2.clone());
            question.answer(q3.clone());
            question.answer(q4.clone());
            question.answer(q5.clone());
        }

        long end = System.nanoTime();

        System.out.println("Time for completion: " + (end - start) + "μs");
    }

    private static void validate(int[] guess, int[] answer) throws Exception {
        int length = guess.length;

        for (int i = 0; i < length; i++) {
            if (guess[i] != answer[i]) {
                throw new Exception("Incorrect value at index " + i +
                                    "\nExpected value: " + answer[i] +
                                    "\nActual value: " + guess[i]);
            }
        }
    }

}
