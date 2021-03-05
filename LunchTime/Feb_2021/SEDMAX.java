import java.util.*;
import java.io.*;
import java.math.*;

class SEDMAX {

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

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		HashSet<Integer> set = new HashSet<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {

			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				set.add(arr[i] - stack.peek());
				stack.pop();
			}

			stack.push(arr[i]);

		}

		while (!stack.isEmpty())
			stack.pop();

		for (int i = n - 1; i >= 0; i--) {

			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				set.add(arr[i] - stack.peek());
				stack.pop();
			}

			stack.push(arr[i]);

		}

		sb.append(set.size() + "\n");

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