import java.util.*;
import java.io.*;
import java.math.*;
class B {

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

		long sum = 0;

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		HashSet<Integer> set = new HashSet<>();

		int[] arr = new int[N - 1];
		int index = 0;
		for (String ele : input) {
			arr[index++] = Integer.parseInt(ele);
			set.add(Integer.parseInt(ele));
		}
		for (int i = 1; i <= N; i++)
			if (!set.contains(i)) {
				sum += i;
				break;
			}
		for (int i = 0; i < N - 1; i++)
			sum += arr[i];
		System.out.println(sum);
	}

}