


import java.util.*;
import java.io.*;
import java.math.*;
class E {

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

		long n = Long.parseLong(br.readLine());
		//Set<Integer> set = new HashSet<>();

		long res = 0;

		// for (int i = 1; i <= n; i++)
		// 	set.add(i);

		for (long i = 1; i <= n; i++)
			for (long j = i + 1; j <= n; j++) {

				long a = (i) * (j + 1);
				long b = (j) * (i + 1);

				long d = __gcd(a, b);
				a = a / d;
				b = b / d;

				if (a == b - 1)
					res++;
			}
		System.out.println(res);
	}

	static long __gcd(long a, long b) {
		if (b == 0)
			return a;
		return __gcd(b, a % b);

	}

}