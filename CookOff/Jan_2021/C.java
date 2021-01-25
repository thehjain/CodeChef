import java.util.*;
import java.io.*;
import java.math.*;

class C {

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
		System.out.println(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		int[] arr = new int[n];
		int[] freq = new int[n + 2];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			freq[arr[i]]++;
		}

		int mex = 0;

		while (freq[mex] != 0) {
			mex++;
		}

		long[] dp = new long[n];
		long[] sf = new long[n + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] < mex) {
				if (map.containsKey(arr[i])) {
					set.remove(map.get(arr[i]));
					set.add(i);
					map.put(arr[i], i);
				} else {
					map.put(arr[i], i);
					set.add(i);
				}
			}
			if (map.size() == mex) {
				if (mex == 0)
					dp[i] = 1 + sf[i + 1];
				else
					dp[i] = 1 + sf[set.last() + 1];
			}
			dp[i] %= MOD;
			sf[i] = dp[i] + sf[i + 1];
			sf[i] %= MOD;
		}
		sb.append(dp[n] + "\n");
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