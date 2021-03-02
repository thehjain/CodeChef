import java.util.*;
import java.io.*;
import java.math.*;

class PALPALS {

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

		char[] arr = sc.next().toCharArray();

		int[] count = new int[26];

		for (char ele : arr)
			count[ele - 'a']++;

		int count_double_pair = 0;
		int count_singles = 0;

		for (int i = 0; i < 26; i++) {
			if (count[i] == 0)
				continue;
			else if (count[i] == 1)
				count_singles++;
			else if (count[i] % 2 == 0)
				count_double_pair += count[i] / 2;
			else
				count_double_pair += (count[i] - 3) / 2;
		}

		if (count_double_pair < count_singles)
			sb.append("NO\n");
		else
			sb.append("YES\n");

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