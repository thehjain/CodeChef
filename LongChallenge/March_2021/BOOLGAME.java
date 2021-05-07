import java.util.*;
import java.io.*;
import java.math.*;

class BOOLGAME {

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
		int m = sc.nextInt();
		int k = sc.nextInt();

		long[] arr = new long[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();

		int[] u = new int[m];
		int[] v = new int[m];
		int[] d = new int[m];

		for (int i = 0; i < m; i++) {
			u[i] = sc.nextInt() - 1;
			v[i] = sc.nextInt() - 1;
			d[i] = sc.nextInt();
		}

		ArrayList<Long> res = new ArrayList<>();

		// System.out.println("hello");

		for (int i = 0; i < (1 << n); i++) {

			long[] temp = new long[n];
			long cost = 0;
			// System.out.println("hello");
			try {
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) > 0) {
						temp[j] = 1;
						cost += arr[j];
					}
				}
			} catch (Exception e) {
				// System.out.println("hell");
			}
			// System.out.println("hello");
			try {
				for (int j = 0; j < m; j++) {
					boolean stat = true;
					for (int p = u[j]; p <= v[j]; p++) {
						if (temp[p] != 1) {
							stat = false;
							break;
						}
					}
					if (stat) {
						cost += d[j];
					}
				}
			} catch (Exception e) {
				// System.out.println("hell");
			}

			res.add(cost);

		}

		Collections.sort(res);

		int index = res.size() - 1;

		// System.out.println(res.size());

		while (k-- > 0) {
			sb.append(res.get(index--) + " ");
		}

		sb.append("\n");

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