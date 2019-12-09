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

    private static final Integer a1 = null;

    public static void main( String[] args ) throws Exception {
        ChallengeQuestion question = new ChallengeQuestion();

        long start = System.nanoTime();

        validate(question.answer(), a1);

        long end = System.nanoTime();

        System.out.println("Time for completion: " + (end - start) + "?s");
    }

    private static void validate(int guess, Integer answer) throws Exception {
        long heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("Found " + guess + " numbers.");
        System.out.println("Total heap size used: " + (heapSize) + " bytes");
    }

}
