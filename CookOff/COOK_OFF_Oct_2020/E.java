import java.util.*;
import java.io.*;
import java.math.*;

class E {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {

			int n = Integer.parseInt(br.readLine());

			String[] input = br.readLine().trim().split(" ");

			int[] arr = new int[n];
			int index = 0;

			for (String ele : input)
				arr[index++] = Integer.parseInt(ele);

			int[][] res = new int[n - 1][2];

			if (!findPairs(arr, res, n))
				System.out.println("NO");
			else {
				System.out.println("YES");

				for (int i = 0; i < n - 1; i++) {
					System.out.println(res[i][0] + " " + res[i][1]);
				}

			}

		}
	}
	static boolean findPairs(int[] arr, int[][] res , int n) {

		boolean[] visited = new boolean[n];

		int index = 0;

		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (!visited[i] || !visited[j]) {
					if (arr[i] != arr[j]) {
						visited[i] = true;
						visited[j] = true;
						res[index][0] = i + 1;
						res[index][1] = j + 1;
						index++;
						if (index == n - 1)
							return true;
					}
				}
			}
		}
		return false;
	}
}