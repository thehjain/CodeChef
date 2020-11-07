/*
.
Restore Sequence
.
*/
import java.util.*;
import java.io.*;
import java.math.*;

class RestoreSequence {

	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;
	static int MOD = 1000000007;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int maxN = 5000001;
	static ArrayList<Integer> prime;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		generatePrimes();
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

		solveUtil(arr, N);
	}

	static void solveUtil(int[] arr, int N) {
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < N; i++)
			res.add(prime.get(arr[i]));

		for (int ele : res)
			System.out.print(ele + " ");

		System.out.println();
	}

	static void generatePrimes() {

		prime = new ArrayList<>();
		boolean[] isPrime = new boolean[maxN];

		Arrays.fill(isPrime, true);

		for (int i = 2; i * i < maxN; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < maxN; j += i)
					isPrime[j] = false;
			}
		}

		for (int i = 2; i < maxN; i++)
			if (isPrime[i])
				prime.add(i);

	}

}