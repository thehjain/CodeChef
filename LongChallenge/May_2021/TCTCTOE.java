import java.util.*;
import java.io.*;
import java.math.*;

class TCTCTOE {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int count_x = 0, count_o = 0, count_space = 0;

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		char[][] arr = new char[3][3];

		for (int i = 0; i < 3; i++)
			arr[i] = sc.nextLine().toCharArray();

		count(arr);

		System.out.println(helper(arr));

	}

	static int helper(char[][] arr) {
		if (count_x < count_o)
			return 3;
		if (count_x > count_o + 1)
			return 3;

		boolean x_win = check_win(arr, 'X');
		boolean o_win = check_win(arr, 'O');

		if (x_win && o_win)
			return 3;

		if (x_win && count_x == count_o)
			return 3;

		if (o_win && count_x > count_o)
			return 3;

		if (x_win || o_win)
			return 1;

		if (count_space == 0)
			return 1;

		return 2;
	}

	static void count(char[][] s) {
		count_x = count_o = 0;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (s[i][j] == 'X')
					count_x++;

				if (s[i][j] == 'O')
					count_o++;
			}

		count_space = 9 - count_x - count_o;
	}

	static boolean check_win(char[][] s, char symbol) {
		if (s[0][0] == symbol && s[0][0] == s[1][1] && s[1][1] == s[2][2])
			return true;

		if (s[0][2] == symbol && s[0][2] == s[1][1] && s[1][1] == s[2][0])
			return true;

		for (int i = 0; i < 3; i++) {
			if (s[i][0] == symbol && s[i][0] == s[i][1] && s[i][1] == s[i][2])
				return true;
			if (s[0][i] == symbol && s[0][i] == s[1][i] && s[1][i] == s[2][i])
				return true;
		}

		return false;
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