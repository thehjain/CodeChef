


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

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		int index = 0;
		int sum = 0;
		for (String ele : input)
			arr[index++] = Integer.parseInt(ele);
		index = 0;
		int count = 0;
		if (arr[0] == 0) {
			System.out.println(0);
			return;
		}
		for (int ele : arr) {
			sum += ele;
			count += ele;
			if (count <= 0)
				break;
			count--;
		}
		System.out.println(sum);
	}

}