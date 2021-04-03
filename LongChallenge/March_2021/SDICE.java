import java.util.*;
import java.io.*;
import java.math.*;

class SDICE {

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

		long n = sc.nextLong();

		if (n == 1) {
			sb.append("20\n");
			return;
		}
		if (n == 2) {
			sb.append("36\n");
			return;
		}
		if (n == 3) {
			sb.append("51\n");
			return;
		}
		if (n == 4) {
			sb.append("60\n");
			return;
		}

		long res = n * 11;
		n %= 4;
		if (n == 1) res += 21;
		else if (n == 2) res += 22;
		else if (n == 3) res += 22;
		else res += 16;

		sb.append(res + "\n");

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