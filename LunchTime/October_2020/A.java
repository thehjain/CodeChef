import java.util.*;
import java.io.*;
import java.math.*;
class A {

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

		long num = Long.parseLong(br.readLine());

		if (num == 1)
			System.out.println(0 + " " + 1);
		else {
			System.out.println(num - 1 + " " + 1);
		}

	}

}