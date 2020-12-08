
//String Operations

import java.util.*;
import java.io.*;
import java.math.*;
class F {

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

		String s = br.readLine();
		int res = findCount(s);
		System.out.println(res);

	}

	// static int findCount(String s) {
	// 	HashSet<String> set = new HashSet<>();
	// 	int n = s.length();
	// 	int countOne = 0, countZero = 0;
	// 	char[] arr = s.toCharArray();
	// 	for (char ele : arr) {
	// 		if (ele == '1') countOne++;
	// 		if (ele == '0') countZero++;
	// 	}
	// 	if (countZero == 0 || countOne == 0) return s.length();
	// 	for (int i = 0; i < n; i++) {
	// 		for (int j = i + 1; j <= n; j++) {
	// 			if (!set.contains(s.substring(i, j)))
	// 				set.add(s.substring(i, j));
	// 		}
	// 	}
	// 	if (isPalindrome(s))
	// 		return set.size() - 1;
	// 	else
	// 		return set.size();
	// }

	// static boolean isPalindrome(String s) {
	// 	int i = 0, j = s.length() - 1;
	// 	while (i < j) {
	// 		if (s.charAt(i) != s.charAt(j))
	// 			return false;
	// 		i++;
	// 		j--;
	// 	}
	// 	return true;
	// }

	static int findCount(String s) {
		HashSet<String> set = new HashSet<>();
		int n = s.length();
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++) {
				StringBuilder str = new StringBuilder(s.substring(i, j));
				if (isEven(s.substring(i, j)) && set.contains(str.reverse().toString()))
					continue;
				else
					set.add(s.substring(i, j));
			}
		return set.size();
	}

	static boolean isEven(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '1') res++;
		return ((res & 1) == 1) ? false : true;
	}

}