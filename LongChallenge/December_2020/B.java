
//Even Pair Sum

import java.util.*;
import java.io.*;
import java.math.*;
class B {

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

		long A = Long.parseLong(input[0]);
		long B = Long.parseLong(input[1]);

		if (A % 2 == 1 && B % 2 == 1)
			System.out.println((A * B / 2) + 1);
		else
			System.out.println(A * B / 2);

	}

}