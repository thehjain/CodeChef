import java.util.*;
import java.io.*;
import java.math.*;

public class A {

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

		int N = sc.nextInt();
		int M = sc.nextInt();

		String[] n = sc.nextLine().split(" ");
		String[] m = sc.nextLine().split(" ");

		int[] n_arr = new int[N];
		int[] m_arr = new int[M];

		int index = 0;
		for (String ele : n)
			n_arr[index++] = Integer.parseInt(ele);
		index = 0;
		for (String ele : m)
			m_arr[index++] = Integer.parseInt(ele);

		int John = 0, Jack = 0;
		for (int ele : n_arr)
			John += ele;
		for (int ele : m_arr)
			Jack += ele;

		if (John > Jack) {
			System.out.println(0);
			return;
		}

		Arrays.sort(n_arr);
		Arrays.sort(m_arr);

		int count = 0;

		for (int i = 0, j = M - 1; i < Math.min(N, M); i++) {
			John += m_arr[j];
			John -= n_arr[i];
			Jack += n_arr[i];
			Jack -= m_arr[j];
			count++;
			j--;
			if (John > Jack)
				break;
		}
		if (John > Jack)
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