import java.util.*;
import java.io.*;
import java.math.*;

class D {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		long k = sc.nextInt();

		long[] arr = new long[n];

		boolean flag = true;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
			if (!(arr[i] % k == 0 || (arr[i] * 2) % k == 0 || (arr[i] * 4) % k == 0 ||
			        (arr[i] * 8) % k == 0 || (arr[i] * 16) % k == 0 || (arr[i] * 32) % k == 0
			        || (arr[i] * 64) % k == 0 || (arr[i] * 128) % k == 0 || (arr[i] * 256) % k == 0
			        || (arr[i] * 512) % k == 0 || (arr[i] * 1024) % k == 0
			        || (arr[i] * 2048) % k == 0 || (arr[i] * 4096) % k == 0))
				flag = false;
		}

		if (flag)
			sb.append("YES" + "\n");
		else
			sb.append("NO" + "\n");

	}

	static boolean isPower (long x) {
		/* First x in the below expression is
		  for the case when x is 0 */
		return x != 0 && ((x & (x - 1)) == 0);

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