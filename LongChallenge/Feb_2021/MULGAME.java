import java.util.*;
import java.io.*;
import java.math.*;

class MULGAME {

	static class Pair {
		int first;
		int second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

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
		int q = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int[] b = new int[1000001];

		int[] ans = new int[m + 1];

		HashMap<Pair, Integer> map = new HashMap<>();

		while (q-- > 0) {
			int l = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;

			if (arr[l] > m)
				continue;

			else if (arr[l] <= m && arr[r] > m) {
				b[arr[l]]++;
				b[m + 1]--;
			}

			else if (arr[r] <= m) {
				b[arr[l]]++;
				b[m + 1]--;
				if (!map.containsKey(new Pair(arr[l], arr[r])))
					map.put(new Pair(arr[l], arr[r]), 0);
				map.put(new Pair(arr[l], arr[r]), map.get(new Pair(arr[l], arr[r])) + 1);
			}

		}

		for (Map.Entry<Pair, Integer> set : map.entrySet()) {
			int k = set.getKey().first;
			int p = set.getKey().second;
			int l = set.getValue();

			b[p + k]--;
			b[p + 2 * k]++;
			int c = p + 2 * k;

			while (c + p <= m) {
				c += p;
				b[c]--;
				b[c + k]++;
				c += k;
			}

		}

		for (int i = 1; i <= m; i++) {
			b[i] += b[i - 1];
		}

		int max = MIN;

		for (int i = 0; i <= m; i++) {
			max = Math.max(b[i], max);
		}

		System.out.println(max);

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