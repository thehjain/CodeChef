import java.util.*;
import java.io.*;
import java.math.*;

class BlackJack {

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
		int x = sc.nextInt();
		int y = sc.nextInt();

		int[] arr = new int[n];

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (!map.containsKey(arr[i]))
				map.put(arr[i], 0);
			map.put(arr[i], map.get(arr[i]) + 1);
		}

		int sum = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (map.get(arr[i]) == 1)
				map.remove(arr[i]);
			else
				map.put(arr[i], map.get(arr[i]) - 1);

			if (sum >= x && sum <= y) {
				break;
			}

			if (sum > x && sum > y) {
				sum -= arr[i];
				for (int j = i + 1; j < n; j++) {
					if (sum + arr[j] >= x && sum <= y) {
						count++;
						sum += arr[j];
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
			}

		}

		if (sum >= x && sum <= y)
			System.out.println(count);
		else
			System.out.println(-1);

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