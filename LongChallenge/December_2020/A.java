
//Cute Chef Gift

import java.util.*;
import java.io.*;
import java.math.*;
class A {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// int T = Integer.parseInt(br.readLine());
		// while (T-- != 0) {
		solve();
		//}
	}

	static void solve() throws IOException {

		String[] input = br.readLine().split(" ");

		int D1 = Integer.parseInt(input[0]);
		int V1 = Integer.parseInt(input[1]);
		int D2 = Integer.parseInt(input[2]);
		int V2 = Integer.parseInt(input[3]);
		int P = Integer.parseInt(input[4]);

		int res = findDays(D1, V1, D2, V2, P);
		System.out.println(res);
	}

	static int findDays(int D1, int V1, int D2, int V2, int P) {

		if (P == 0) return 0;

		if (D1 > D2) return findDays(D2, V2, D1, V1, P);

		int res = D1 - 1;

		while (D1 != D2) {
			if (P <= 0) break;
			P -= V1;
			res++;
			D1++;
		}

		if (P % (V1 + V2) == 0) res += P / (V1 + V2);
		else res += P / (V1 + V2) + 1;
		return res;
	}

}