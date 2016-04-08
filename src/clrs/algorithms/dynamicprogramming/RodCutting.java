package clrs.algorithms.dynamicprogramming;

public class RodCutting {

	/**
	 * 
	 * @param prices
	 *            Array of prices per length. Index 0 corresponds to length of 1
	 * @param n
	 *            length of Rod to optimize cuts for
	 * @return optimal revenue
	 */
	public static int cutRodMemoized(int[] prices, int n) {
		int[] memo = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			memo[i] = Integer.MIN_VALUE;
		}

		return cutRodMemoizedAux(prices, n, memo);
	}

	/**
	 * 
	 * @param prices
	 * @param n
	 *            max cut index
	 * @param memo
	 *            memo[k] = optimal revenue of rod of length k
	 * @return
	 */
	private static int cutRodMemoizedAux(int[] prices, int n, int[] memo) {
		// validate input
		if (n > prices.length) {
			throw new IllegalArgumentException();
		}

		// check if result has been computed
		if (memo[n] >= 0) {
			return memo[n];
		}

		// Recursive base case
		if (n == 0) {
			memo[n] = 0;
			return 0;
		}

		int q = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			q = Math.max(q, prices[i - 1] + cutRodMemoizedAux(prices, n - i, memo));
		}
		memo[n] = q;

		return q;
	}

	private static int cutRodBottomUp(int[] prices, int n) {
		int[] memo = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			memo[i] = Integer.MIN_VALUE;
		}
		memo[0] = 0;

		for (int j = 1; j <= n; j++) {
			int q = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++) {
				q = Math.max(q, prices[i - 1] + memo[j - i]);
			}
			memo[j] = q;
		}

		return memo[n];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		int n = 7;

		System.out.println("Top down: " + cutRodMemoized(prices, n));// 18
		System.out.println("Bottom up: " + cutRodBottomUp(prices, n));

	}

}