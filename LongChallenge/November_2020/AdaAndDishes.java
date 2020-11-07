/*
.
Ada And Dishes
.
*/

import java.util.*;
import java.io.*;
import java.math.*;

class AdaAndDishes {

	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;
	static int MOD = 1000000007;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- != 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().trim().split(" ");

		int[] arr = new int[N];
		int index = 0;

		for (String ele : input)
			arr[index++] = Integer.parseInt(ele);

		int res = findMin(arr, N);

		System.out.println(res);
	}

	static int findMin(int[] arr, int N) {
		if (N == 1)
			return arr[0];

		Arrays.sort(arr);

		int sum1 = arr[N - 1];
		int sum2 = arr[N - 2];

		for (int i = N - 3; i >= 0; i--) {
			if (sum1 <= sum2)
				sum1 += arr[i];
			else
				sum2 += arr[i];
		}

		return Math.max(sum1, sum2);
	}

}