import java.util.*;
import java.io.*;
import java.math.*;

class MEXSTR {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static HashSet<Long> set = new HashSet<>();
	static int[] next0 = new int[1000005];
	static int[] next1 = new int[1000005];
	static int[] dp = new int[1000005];
	static int[] dp1 = new int[1000005];

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			set.clear();
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		String s = sc.next();

		int last_pos = -1;
		int n = s.length();

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '0') {
				for (int j = last_pos + 1; j <= i; j++) {
					next0 [j] = i;
					last_pos = i;
				}
			}
		}

		for (int i = last_pos + 1; i < n; i++) {
			next0[i] = n;
		}
		if (next0[0] == n) {
			sb.append("0" + "\n");
			return;
		}
		last_pos = -1;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '1') {
				for (int j = last_pos + 1; j <= i; j++) {
					next1[j] = i;
					last_pos = i;
				}
			}
		}

		for (int i = last_pos + 1; i < n; i++) {
			next1[i] = n;
		}

		dp[n] = dp[n + 1] = 0;

		dp1[n] = dp1[n + 1] = 0;

		for (int i = n - 1; i >= 0; i--) {
			dp[i] = dp[i + 1];
			if (s.charAt(i) == '0' && next1[i] < n)
				dp[i] = Math.max(dp[i], dp[next1[i] + 1] + 1);
			if (s.charAt(i) == '1' && next0[i] < n)
				dp[i] = Math.max(dp[i], dp[next0[i] + 1] + 1);
			dp1[i] = dp1[i + 1];
			if (next1[i] < n)
				dp1[i] = Math.max(dp[i], dp[next1[i] + 1] + 1);
		}

		int len = dp1[0] + 1;
		int curind = next1[0] + 1;
		StringBuilder ans = new StringBuilder("1");
		for (int i = 1; i < len; i++) {
			if (curind >= n) {
				ans.append("0");
				continue;
			}
			if (next0[curind] >= n) {
				ans.append("0");
				curind = next0[curind] + 1;
				continue;
			}
			if (dp[next0[curind] + 1] < len - i - 1) {
				ans.append("0");
				curind = next0[curind] + 1;
			} else {
				ans.append("1");
				curind = next1[curind] + 1;

			}

		}

		sb.append(ans + "\n");



	}

// static void solve() throws IOException {

// 	String s = sc.next();

// 	long n = 100000000;

// 	printSubSeqRec(s, s.length(), -1, "");

// 	for (int i = 0; i < n; i++)
// 		if (!set.contains((long)i)) {
// 			sb.append(Long.toBinaryString(i) + "\n");
// 			break;
// 		}

// 	// for (int i = 0; i < n; i++) {
// 	// 	String patt = Integer.toBinaryString(i);
// 	// 	if (!isSubSequence(patt, s, patt.length(), s.length())) {
// 	// 		sb.append(patt + "\n");
// 	// 		break;
// 	// 	}
// 	// }

// }

	static void printSubSeqRec(String str, int n,
	                           int index, String curr) {
		// base case
		if (index == n) {
			return;
		}
		if (curr != null && !curr.trim().isEmpty()) {
			// System.out.println(parseLong(curr, 2));
			set.add(parseLong(curr, 2));
		}
		for (int i = index + 1; i < n; i++) {
			curr += str.charAt(i);
			printSubSeqRec(str, n, i, curr);

			// backtracking
			curr = curr.substring(0, curr.length() - 1);
		}
	}

	static long parseLong(String s, int base) {
		return new BigInteger(s, base).longValue();
	}

// static boolean isSubSequence(String str1, String str2,
//                              int m, int n) {
// 	int j = 0;
// 	for (int i = 0; i < n && j < m; i++)
// 		if (str1.charAt(j) == str2.charAt(i))
// 			j++;
// 	return (j == m);
// }

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