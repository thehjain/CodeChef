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

		int N = sc.nextInt();
		int K = sc.nextInt();

		long[] arr = new long[N];
		long sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
			sum += arr[i];
		}

		if (2 * K > sum) {
			System.out.println(-1);
			return;
		}

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for (long ele : arr)
			pq.add(ele);

		int num1 = 0, num2 = 0;
		int count = 0;

		while ((!pq.isEmpty()) || (num1 >= K && num2 >= K)) {
			if (num1 < K) {
				num1 += pq.poll();
				count++;
			}
			if (num2 < K) {
				num2 += pq.poll();
				count++;
			}
		}

		if (num1 >= K && num2 >= K)
			System.out.println(count);
		else
			System.out.println(-1);

		// Arrays.sort(arr);
		// ArrayList<Long> res = new ArrayList<>();
		// ArrayList<Long> temp = new ArrayList<>();
		// for (long ele : arr) {
		// 	res.add(ele);
		// 	temp.add(ele);
		// }

		// // sum = 0;
		// // for (int i = N - 1; i >= 0; i--) {
		// // 	if (sum + arr[i] == K)
		// // 		break;
		// // 	if (sum + arr[i] > K) {
		// // 		if (sum + arr[0] > K) {
		// // 			System.out.println(-1);
		// // 			return;
		// // 		}
		// // 	}
		// // }

		// long num1 = 0, num2 = 0;
		// int count = 0;

		// for (int i = N - 1; i >= 0; i--) {
		// 	if (num1 + res.get(i) > K) {
		// 		continue;
		// 	}
		// 	num1 += res.get(i);
		// 	// res.remove(i);
		// 	temp.remove(i);
		// 	count++;
		// }

		// N = temp.size();
		// res = temp;

		// // if (num1 != K)
		// // 	for (int i = 0; i < N; i++) {
		// // 		if (num1 + res.get(i) >= K) {
		// // 			num1 += res.get(i);
		// // 			// res.remove(i);
		// // 			temp.remove(i);
		// // 			count++;
		// // 			break;
		// // 		}
		// // 	}

		// // N = temp.size();
		// // res = temp;

		// for (int i = N - 1; i >= 0; i--) {
		// 	if (num2 + res.get(i) > K)
		// 		continue;
		// 	num2 += res.get(i);
		// 	temp.remove(i);
		// 	count++;
		// }

		// N = temp.size();
		// res = temp;

		// if (num1 == K && num2 == K) {
		// 	System.out.println(count);
		// 	return;
		// }

		// if (num1 == K) {
		// 	for (int i = N - 1; i >= 0; i--) {
		// 		if (num2 >= K)
		// 			break;
		// 		num2 += res.get(i);
		// 		count++;
		// 	}
		// 	if (num2 >= K) {
		// 		System.out.println(count);
		// 		return;
		// 	} else {
		// 		System.out.println(-1);
		// 		return;
		// 	}
		// }
		// if (num2 == K) {
		// 	for (int i = N - 1; i >= 0; i--) {
		// 		if (num1 >= K)
		// 			break;
		// 		num1 += res.get(i);
		// 		count++;
		// 	}
		// 	if (num1 >= K) {
		// 		System.out.println(count);
		// 		return;
		// 	} else {
		// 		System.out.println(-1);
		// 		return;
		// 	}
		// }

		// boolean flag = false;

		// while (true) {
		// 	N = res.size();
		// 	if (N == 0)
		// 		break;
		// 	if (num1 >= K && num2 >= K)
		// 		break;
		// 	if (num1 <= num2 || num2 >= K) {
		// 		num1 += res.get(N - 1);
		// 		count++;
		// 		res.remove(N - 1);
		// 		continue;
		// 	} else {
		// 		num2 += res.get(N - 1);
		// 		count++;
		// 		res.remove(N - 1);
		// 	}
		// }

		// if (num1 >= K && num2 >= K)
		// 	System.out.println(count);
		// else
		// 	System.out.println(-1);

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