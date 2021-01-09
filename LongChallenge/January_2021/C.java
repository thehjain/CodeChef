import java.util.*;
import java.io.*;
import java.math.*;

class C {

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

		HashSet<Integer> set = new HashSet<>();
		long countNeg = 0;
		long countPos = 0;

		long res = 0;

		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			set.clear();
			for (int j = 0; j < m; j++) {
				int temp = sc.nextInt();
				if (!set.contains(temp)) {
					set.add(temp);
					if (temp < 0) countNeg++;
					else if (temp > 0) countPos++;
				}
			}
			res += countPos * countNeg;
		}

		// System.out.println(countPos + " " + countNeg);
		// if (n == 1)
		// 	res = countNeg * countPos;

		System.out.println(res);
	}

	static long countOne(int n) {

		if (n == 1) return 1;

		else
			return (n / 2) * (2 * 1 + (n - 1) * 1);

	}

	static long count(int n) {

		if (n == 1) return 1;

		else
			return (n / 2) * (2 * 1 + (n - 1) * 2);

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