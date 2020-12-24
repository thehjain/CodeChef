


import java.util.*;
import java.io.*;
import java.math.*;

public class A {

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

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();

		double count = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '1') count++;

		// System.out.println((((120 - n + count) / 120) * 100));

		double temp = ((120 - n + count) / 120);

		if ((temp * 100) >= 75)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}