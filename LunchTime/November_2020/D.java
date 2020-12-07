


import java.util.*;
import java.io.*;
import java.math.*;
public class D {

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

		int n = Integer.parseInt(br.readLine());
		int res = 0;
		int i = 1;
		while (res < n)
			res += i++;
		if (res == n + 1) System.out.println(i);
		else System.out.println(i - 1);

	}


}