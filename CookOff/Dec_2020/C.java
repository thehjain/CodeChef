


import java.util.*;
import java.io.*;
import java.math.*;

public class C {

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

		String s = br.readLine();

		if (s.length() % 2 != 0) {
			System.out.println(-1);
			return;
		}

		int countOne = 0;
		int countZero = 0;

		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '1') countOne++;
			else countZero++;

		if (countZero == 0 || countOne == 0) {
			System.out.println(-1);
			return;
		}
		if (countOne == countZero) {
			System.out.println(0);
			return;
		}

		int res = s.length() / 2 - Math.min(countOne, countZero);

		System.out.println(res);

	}

}