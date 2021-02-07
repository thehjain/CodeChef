import java.util.*;
import java.io.*;
import java.math.*;


class FROGS {

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

		HashMap<Integer, Integer> jumps = new HashMap<>();
		HashMap<Integer, Integer> pos = new HashMap<>();

		int[] weights = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			weights[i] = sc.nextInt();
			pos.put(weights[i], i);
		}

		for (int i = 1; i <= n; i++) {
			int temp = sc.nextInt();
			jumps.put(weights[i], temp);
		}

		int res = 0;

		// for (int i = 1; i <= n; i ++)
		// 	System.out.println(jumps.get(i));

		while (true) {
			boolean flag = true;
			for (int i = n; i > 1; i--) {
				// System.out.println(pos.get(n) + " " + pos.get(n - 1));
				if (pos.get(i) <= pos.get(i - 1)) {
					flag = false;
					while (pos.get(i) <= pos.get(i - 1)) {
						pos.put(i, pos.get(i) + jumps.get(i));
						res++;
					}
					// System.out.println("Updated" + pos.get(n) + " " + pos.get(n - 1));
				} else continue;
			}
			if (flag)
				break;
		}

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