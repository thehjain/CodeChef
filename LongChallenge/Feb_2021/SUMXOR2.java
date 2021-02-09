import java.util.*;
import java.io.*;
import java.math.*;

class SUMXOR2 {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 998244353;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		long[] arr = new long[n];

		long allSum = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
			allSum += arr[i];
		}

		map.put(1, allSum);

		int queries = sc.nextInt();

		while (queries-- > 0) {

			int len = sc.nextInt();

			long sum = 0;

			if (len == 1) {
				sb.append(map.get(1) + "\n");
				continue;
			}

			for (int i = 1; i <= len; i++) {
				if (map.containsKey(i)) {
					sum += map.get(i);
					continue;
				}
				findXor(arr, 0, n, i, 0);
				sum += map.get(i);
				// System.out.println(sum);
			}

			sb.append(sum + "\n");

		}
		System.out.print(sb);

	}

	static void findXor(long[] arr, int pos, int n, int len, long curr) {

		if (pos == len) {
			// System.out.println(curr);
			if (!map.containsKey(len))
				map.put(len, (long)0);
			map.put(len, map.get(len) + curr % MOD);
			return;
		}

		for (int i = 0 ; i < n; i++) {
			// System.out.println(arr[i]);
			findXor(arr, pos + 1, n, len, curr ^ arr[i]);
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