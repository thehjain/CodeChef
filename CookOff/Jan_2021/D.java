import java.util.*;
import java.io.*;
import java.math.*;

class Pair implements Comparable<Pair> {
	int val;
	char color;
	Pair(int val, char color) {
		this.val = val;
		this.color = color;
	}
	public int compareTo(Pair temp) {
		return this.val - temp.val;
	}
}

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
		System.out.println(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int m = sc.nextInt();

		int R = sc.nextInt();
		int G = sc.nextInt();
		int B = sc.nextInt();

		char[][] arr = new char[n][m];
		Pair[] ar = new Pair[3];

		ar[0] = new Pair(R, 'R');
		ar[1] = new Pair(G, 'G');
		ar[2] = new Pair(B, 'B');

		Arrays.sort(ar);

		for (char[] row : arr)
			Arrays.fill(row, '*');

		int count1 = ar[0].val;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if ((i + j) % 2 == 0 && count1 > 0) {
					arr[i][j] = ar[0].color;
					count1--;
				}

		count1 = ar[1].val;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if ((i + j) % 2 != 0 && count1 > 0) {
					arr[i][j] = ar[1].color;
					count1--;
				}

		count1 = ar[2].val;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (arr[i][j] == '*' && count1 > 0) {
					arr[i][j] = ar[2].color;
					count1--;
				}

		for (char[] row : arr) {
			for (char ele : row)
				sb.append(ele);
			sb.append("\n");
		}
		// sb.append("\n");
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