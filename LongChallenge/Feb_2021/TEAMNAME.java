import java.util.*;
import java.io.*;
import java.math.*;

class TEAMNAME {

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

		HashMap<String, ArrayList<Character>> map = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			if (!map.containsKey(temp.substring(1))) {
				arr.add(temp.substring(1));
				map.put(temp.substring(1), new ArrayList<>());
			}
			map.get(temp.substring(1)).add(temp.charAt(0));

		}

		int res = 0;
		int size = arr.size();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) continue;
				int common = commonElements(map.get(arr.get(i)), map.get(arr.get(j)));
				res += (map.get(arr.get(i)).size() - common) * (map.get(arr.get(j)).size() - common);
			}
		}

		sb.append(res + "\n");

	}

	static int commonElements(ArrayList<Character> a, ArrayList<Character> b) {

		int count = 0;

		HashSet<Character> set = new HashSet<>(a);

		for (char ele : b) {
			if (set.contains(ele))
				count++;
		}

		return count;

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