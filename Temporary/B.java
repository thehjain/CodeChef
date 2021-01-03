
//Watching CPL

import java.util.*;
import java.io.*;
import java.math.*;

class B {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	static int subset(int[] arr, int n, int k) {

		int sum = 0;

		Arrays.sort(arr);

		for (int i = 0; i < n / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[n - i - 1];
			arr[n - i - 1] = temp;
		}

		ArrayList<Integer> list = new ArrayList<>();

		// for (int ele : arr)
		// 	System.out.print(ele + " ");

		int res = -1;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			list.add(arr[i]);
			if (sum >= 2 * k) {
				int[] ar = new int[list.size()];
				int index = 0;
				for (int ele : list)
					ar[index++] = ele;
				int diff = findMin(ar, ar.length);

				if ((sum - diff) / 2 >= k) {
					res = list.size();
					// System.out.print("helo" + sum + " helo" + diff + " ");
					break;
				}
			}
		}
		return res;
	}

	static int findMin(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		boolean dp[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;
		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (arr[i - 1] <= j)
					dp[i][j] |= dp[i - 1][j - arr[i - 1]];
			}
		}
		int diff = MAX;
		for (int j = sum / 2; j >= 0; j--) {
			if (dp[n][j] == true) {
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;
	}

	static void solve() throws IOException {

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		if (2 * K > sum) {
			System.out.println(-1);
			return;
		}

		if (N == 1) {
			System.out.println(-1);
			return;
		}

		// long res = solveUtil(arr, N, K);

		int res = subset(arr, N, K);

		System.out.println(res);
	}

	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}