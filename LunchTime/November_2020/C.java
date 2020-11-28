


import java.util.*;
import java.io.*;
import java.math.*;
class C {

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

		String[] input = br.readLine().split(" ");
		long X = Long.parseLong(input[0]);
		long Y = Long.parseLong(input[1]);
		long N = Long.parseLong(input[2]);

		long res = 0;

		for (int i = 0; i <= N; i++) {
			if ((X ^ i) < (Y ^ i))
				res++;
		}
		System.out.println(res);
	}

}