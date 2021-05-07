import java.util.*;
import java.io.*;
import java.math.*;

class CHAOSEMP {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int q = 0;
	static int d = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		q = sc.nextInt();
		d = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		long l = (-1L) * (12000L), r = 12000L, y1 = l, y2 = r;

		long curr = 1L;

		String cc = "";

		long mid = (l + r) / 2;

		while (l <= r) {
			mid = (l + r) / 2;
			if (curr == 1L)
				sb.append(curr + " " + mid + " " + y1 + "\n");
			else
				sb.append(curr + " " + mid + " " + y1 + " " + mid + " " + y2 + "\n");
			cc = sc.next();

			if (cc.charAt(0) == 'X')
				curr = 2L;
			if (cc.equals("O"))
				break;
			if (cc.charAt(0) == 'N')
				l = mid + 1L;
			if (cc.charAt(0) == 'P')
				r = mid - 1L;
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