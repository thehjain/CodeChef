import java.util.*;
import java.io.*;
import java.math.*;

class PRIGAME {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int[] prime = new int[1000003];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		sieve();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int x = sc.nextInt();
		int y = sc.nextInt();

		System.out.println(prime[1000000]);

		if (x == 1) {
			sb.append("Chef\n");
			return;
		}

		if (y < prime[x]) {
			sb.append("Divyam\n");
		} else
			sb.append("Chef\n");

	}

	static void sieve() {

		boolean[] isPrime = new boolean[1000002];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		int n = 1000001;

		int[] arr = new int[n];

		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				arr[i] = 1;
				for (long j = (long)i * i; j <= n; j += i)
					isPrime[(int)j] = false;
			}
		}

		for (int i = 2; i < n; i++)
			prime[i] = prime[i - 1] + arr[i];

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