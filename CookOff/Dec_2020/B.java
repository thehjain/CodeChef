


import java.util.*;
import java.io.*;
import java.math.*;

public class B {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		String[] input = br.readLine().trim().split(" ");

		long x = Long.parseLong(input[0]);
		long y = Long.parseLong(input[1]);
		long k = Long.parseLong(input[2]);
		long N = Long.parseLong(input[3]);

		if (Math.abs(x - y) % (2 * k) == 0)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}