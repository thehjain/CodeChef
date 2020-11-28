


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

		long n = Long.parseLong(br.readLine());

		ArrayList<Pair> arr = new ArrayList<>();

		for (int i = 0; i < n; i++)
			arr.add(new Pair());

		String[] fuel = br.readLine().trim().split(" ");
		String[] cost = br.readLine().trim().split(" ");

		for (int i = 0; i < n; i++)
			arr.get(i).second = Long.parseLong(fuel[i]);
		for (int i = 0; i < n; i++)
			arr.get(i).first = Long.parseLong(cost[i]);

		Collections.sort(arr, new MyComparator());

		long a = n, res = 0;

		for (Pair temp : arr) {
			if (temp.second >= a) {
				res += temp.first * a;
				a = 0;
			} else {
				res += temp.second * temp.first;
				a -= temp.second;
			}
			if (a <= 0)
				break;
		}

		System.out.println(res);

	}

}

class MyComparator implements Comparator<Pair> {
	public int compare(Pair a, Pair b) {
		return (int)a.first - (int)b.first;
	}
}

class Pair {
	long first;
	long second;
}