


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

		char[] s = br.readLine().toCharArray();

		int[] arr = new int[26];

		for (char ele : s) {
			arr[(int)ele - 97]++;
			// System.out.print((int)ele - 97 + " ");
		}
		// for (int i = 0; i < 26; i++) {
		// 	if (arr[i] > 0)
		// 		System.out.print((char)(i + 97) + " " + arr[i]);
		// }
		int res = 0;
		for (int ele : arr)
			if (ele > 1)
				res += ele / 2;

		System.out.println(Math.min(res, s.length / 3));
	}

}