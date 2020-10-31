import java.util.*;
import java.io.*;
import java.math.*;

class A {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {

			int n = Integer.parseInt(br.readLine());

			String s = br.readLine();

			boolean ff = false;

			for (int i = 0; i < n - 1; i++) {
				if (s.charAt(i) == s.charAt(n - 1)) {
					System.out.println("YES");
					ff = true;
					break;
				}
			}
			if (!ff)
				System.out.println("NO");
		}

	}

}