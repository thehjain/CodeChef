import java.util.*;
import java.io.*;
import java.math.*;

class MAXFUN {

	private static int MAX = Integer.MAX_VALUE;
	private static long MIN = Long.MIN_VALUE;
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

		long[] arr = new long[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();

		long res = MIN;

		Arrays.sort(arr);

		for (int i = 1; i < n - 1; i++) {
			res = Math.max(res, Math.abs(arr[0] - arr[i]) + Math.abs(arr[i] - arr[n - 1]) +
			               Math.abs(arr[n - 1] - arr[0]));
		}

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