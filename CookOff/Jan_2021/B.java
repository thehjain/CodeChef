import java.util.*;
import java.io.*;
import java.math.*;

class B {

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
		int m = sc.nextInt();

		char[][] grid = new char[n][m];

		for (int i = 0; i < n; i++)
			grid[i] = sc.next().toCharArray();

		int res1 = 0;
		int res2 = 0;

		for (int i = 0; i < n; i++) {
			boolean flag = false;
			if (i % 2 == 0) flag = true;
			for (int j = 0; j < m; j++) {
				if (flag) {
					if (j % 2 == 0 && grid[i][j] == '*')
						continue;
					else if (j % 2 != 0 && grid[i][j] == '.')
						continue;
					else
						res1++;
				} else {
					if (j % 2 == 0 && grid[i][j] == '.')
						continue;
					else if (j % 2 != 0 && grid[i][j] == '*')
						continue;
					else
						res1++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			boolean flag = false;
			if (i % 2 != 0) flag = true;
			for (int j = 0; j < m; j++) {
				if (flag) {
					if (j % 2 == 0 && grid[i][j] == '*')
						continue;
					else if (j % 2 != 0 && grid[i][j] == '.')
						continue;
					else
						res2++;
				} else {
					if (j % 2 == 0 && grid[i][j] == '.')
						continue;
					else if (j % 2 != 0 && grid[i][j] == '*')
						continue;
					else
						res2++;
				}
			}
		}
		if (grid.length % 2 != 0) {
			System.out.println(res1);
			return;
		}
		System.out.println(Math.min(res1, res2));

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