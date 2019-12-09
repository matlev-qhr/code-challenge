/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author mathew.levasseur
 */
public class ChallengeQuestion {

	public ChallengeQuestion() {}
	
	private static int[] fibMap;
	
	private static final double ROOT_FIVE = Math.sqrt(5);
	private static final double PHI = (ROOT_FIVE + 1) / 2;
	private static final double NEG_PHI = (1 - ROOT_FIVE) / 2;
	
	// OPTIMIZATION VARIABLES
	private static final int MAX_VALUE = 1000000;
	private static HashSet<Integer> sumSet;
	
	
    /**
     * The Fibonacci sequence is a well known sequence defined by the equation
     * F? = F??? + F??? where F? = 0 and F? = 1.
     * This results in a sequence that begins as 0, 1, 1, 2, 3, 5, 8, 13...
     * and continues on forever.
     *
     * It follows that every positive, natural number can be composed by adding
     * unique combinations of Fibonacci numbers.  ex:
     * 8 = 5 + 3; 5 + 2 + 1;
     * 12 = 8 + 3 + 1
     * 29 = 21 + 8; 21 + 5 + 3; 21 + 5 + 2 + 1; ...;
     *
     * The OPTIMUM composition of an integer X is one that has the fewest
     * Fibonacci numbers used.  The Optimal number (P?) represents the minimum
     * numbers required to sum to X. ex:
     * P of 8 = 2
     * P of 12 = 3
     * P of 29 = 2
     *
     * Find the count of all numbers between 1 and 1-million inclusive that have
     * a P value of 4 or more.
     *
     * This should optimize SPACE and TIME.
     * 
     * 3276 + 378 +28
     *
     * @param input
     * @return
     */
    public int answer() {
    	this.prepareFibCache();
    	sumSet = new HashSet<>();
    	int fibMapSize = fibMap.length;
    	
    	for (int a = 2; a < (fibMapSize - 2); a++) {
    		sumSet.add(fibMap[a]);
    		
    		for (int b = (a + 1); b < (fibMapSize - 1); b++) {
    			sumSet.add(fibMap[a] + fibMap[b]);
    			
    			for (int c = (b + 1); c < fibMapSize; c++) {
    				sumSet.add(fibMap[a] + fibMap[b] + fibMap[c]);
    			}
    		}
    	}
        
        return MAX_VALUE - sumSet.size();
    }
    
    // OPTIMIZATION METHODS
    private void prepareFibCache() {
    	int index = findClosestFibNumberTo(MAX_VALUE);
    	fibMap = new int[index + 1];
    	
    	for (int i = 0; i <= index; i++) {
    		getFibOfN(i);
    	}
    }
    
    /**
     * Return the index of the closest Fib number LESS THAN OR EQUAL TO the given input.
     * @param number
     * @return Fibonacci sequence index
     */
    private int findClosestFibNumberTo(int number) {
    	int fibIndex = (int) Math.round(2.078087F * (float) Math.log(number) + 1.672276F);
    	return fibIndex;
    }
    
    private int getFibOfN(int n) {
    	if (fibMap[n] == 0) {
    		fibMap[n] = computeFibOfN(n);
    	} 
    	
    	return fibMap[n];
    }
    
    private int computeFibOfN(int n) {
    	return (int) ((Math.pow(PHI, n) - Math.pow(NEG_PHI, n)) / ROOT_FIVE);
    }

}

