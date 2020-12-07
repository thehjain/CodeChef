
//Vaccine Distribution

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

		String[] input = br.readLine().trim().split(" ");

		int N = Integer.parseInt(input[0]);
		int D = Integer.parseInt(input[1]);

		int risk = 0;
		int not = 0;

		String[] s = br.readLine().trim().split(" ");

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(s[i]);
			if (temp >= 80 || temp <= 9) risk++;
			else not++;
		}

		int res = 0;
		if (risk % D == 0) res += risk / D;
		else res += risk / D + 1;
		if (not % D == 0) res += not / D;
		else res += not / D + 1;

		System.out.println(res);
	}

}