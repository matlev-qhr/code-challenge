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
 *  output: {1, 1, W, 0,
 *           K, 1, W, W,
 *           1, W, 2, 3,
 *           2, W, 3, 3}
 *
 * @param input
 * @return
 */
function answer(input) {
	
	return new Array();
}

function main() {
	var start = window.performance.timing.navigationStart + window.performance.now();
	
	try {
		validate(answer(q1.slice()), a1);
		validate(answer(q2.slice()), a2);
		validate(answer(q3.slice()), a3);
		validate(answer(q4.slice()), a4);
		validate(answer(q5.slice()), a5);
	} catch(err) {
		console.log(err.message);
		throw err;
	}
	
	for (var i = 0; i < 100000; i++) {
		answer(q1.slice());
		answer(q2.slice());
		answer(q3.slice());
		answer(q4.slice());
		answer(q5.slice());
	}
	
	var end = window.performance.timing.navigationStart + window.performance.now();
	
	console.log("Time for completion: " + (end - start) + "μs");
}

var K = 127;
var W = -1;

var q1 = [0, 0,
		  0, K];
var a1 = [1, 1, 1, K];

var q2 = [0, 0, W,
		  0, 0, 0,
		  K, 0, W];
var a2 = [2, 2, W, 1, 1, 2, K, 1, W];

var q3 = [K, 0, W, 0,
		  0, 0, W, 0,
		  W, 0, 0, 0,
		  0, W, 0, 0];
var a3 = [K, 1, W, 4, 1, 1, W, 3, W, 2, 2, 3, 3, W, 3, 3];

var q4 = [0, 0, 0, W, 0,
		  0, 0, W, 0, 0,
		  0, 0, 0, W, 0,
		  W, W, W, 0, W,
		  0, W, K, 0, 0];
var a4 = [4, 4, 4, W, 4, 4, 3, W, 3, 3, 4, 3, 2, W, 2, W, W, W, 1, W, 0, W, K, 1, 2];

var q5 = [W, W, W, 0, 0, W, 0, 0,
		  W, 0, W, W, 0, 0, W, 0,
		  W, 0, 0, W, W, 0, W, 0,
		  W, 0, W, W, W, 0, W, W,
		  W, W, W, 0, K, W, 0, 0,
		  0, 0, W, 0, 0, W, W, 0,
		  W, 0, W, W, 0, W, 0, W,
		  0, 0, 0, 0, 0, 0, 0, 0];
var a5 = [W, W, W, 4, 4, W, 4, 5,
		  W, 0, W, W, 3, 3, W, 5,
		  W, 0, 0, W, W, 2, W, 6,
		  W, 0, W, W, W, 1, W, W,
		  W, W, W, 1, K, W, 2, 3,
		  6, 6, W, 1, 1, W, W, 3,
		  W, 5, W, W, 2, W, 4, W,
		  6, 5, 4, 3, 3, 3, 4, 5];
		  
function validate(guess, answer) {
	var length = guess.length;
	if (length == 0) {
		throw new Error("No output received from answer()");
	}
	for (i = 0; i < length; i++) {
		if (guess[i] !== answer[i]) {
			throw new Error("Incorrect value at index " + i +
						"\nExpected value: " + answer[i] +
						"\nActual value: " + guess[i]);
		}
	}
}

main();