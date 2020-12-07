
//Positive Prefixes

import java.util.*;
import java.io.*;
import java.math.*;
class D {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- != 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		String[] input = br.readLine().trim().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int pos = K;
		int neg = N - K;

		StringBuilder s = new StringBuilder();

		if (N == K) {
			for (int i = 1; i <= N; i++) {
				s.append(i + " ");
				//s.append(" ");
			}
		} else {
			int val = 1;
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 1) {
					s.append(val * (-1) + " ");
					neg--;
				} else {
					s.append(val + " ");
					pos--;
				}
				val++;
				if (neg == 0 || pos == 0)
					break;
			}
			if (neg == 0) {
				while (val <= N) {
					s.append(val + " ");
					val++;
				}
			} else if (pos == 0) {
				while (val <= N) {
					s.append(val * (-1) + " ");
					val++;
				}
			}
		}

		//System.out.println();
		System.out.println(s);

	}

}