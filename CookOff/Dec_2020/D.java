


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
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		String[] input = br.readLine().trim().split(" ");
		String[] spells = br.readLine().trim().split(" ");

		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[] arr = new int[M];
		int index = 0;
		for (String ele : spells)
			arr[index++] = Integer.parseInt(ele);



	}

}