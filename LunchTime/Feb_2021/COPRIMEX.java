import java.util.*;
import java.io.*;
import java.math.*;

class COPRIMEX {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static boolean[] isPrime = new boolean[10000001];

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		fillPrime();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int L = sc.nextInt();
		int R = sc.nextInt();

		for (int i = R + 1; i <= 10000000; i++) {
			if (isPrime[i]) {
				System.out.println(i);
				break;
			}
		}

	}

	static void fillPrime() {
		int n = 10000000;
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i)
					isPrime[j] = false;
			}
		}

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