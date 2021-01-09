import java.util.*;
import java.io.*;
import java.math.*;

class AndOrGame {

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

	static void solve() throws IOException {

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] A = new int[n];
		int[] B = new int[m];

		for (int i = 0; i < n; i++)
			A[i] = sc.nextInt();
		for (int i = 0; i < m; i++)
			B[i] = sc.nextInt();

		Stack<Integer> stack = new Stack<>();
		HashSet<Integer> set = new HashSet<>();

		stack.push(0);

		while (!stack.isEmpty()) {

			int x = stack.pop();

			for (int i = 0; i < n; i++) {
				int y = A[i];
				if (!set.contains(x | y)) {
					set.add(x | y);
					stack.push(x | y);
				}
			}
			for (int i = 0; i < m; i++) {
				int y = B[i];
				if (!set.contains(x & y)) {
					set.add(x & y);
					stack.push(x & y);
				}
			}
		}
		System.out.println(set.size());
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