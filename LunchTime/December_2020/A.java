


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

		char[] S = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		if (S.equals(P)) {
			System.out.println("Yes");
			return;
		}

		if (S.length != P.length) {
			System.out.println("No");
			return;
		}

		int countOneS = 0;
		int countOneP = 0;

		for (char ele : S)
			if (ele == '1') countOneS++;
		for (char ele : P)
			if (ele == '1') countOneP++;

		if (countOneS != countOneP) {
			System.out.println("No");
			return;
		}

		countOneS = 0;
		countOneP = 0;

		for (int i = 0; i < S.length; i++) {

			if (S[i] == '1') countOneS++;
			if (P[i] == '1') countOneP++;

			if (countOneP > countOneS) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
		return;
	}

}