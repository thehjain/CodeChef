import java.util.*;
import java.io.*;
import java.math.*;

class B {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {

			String[] input = br.readLine().trim().split(" ");

			long L = Long.parseLong(input[0]);
			long R = Long.parseLong(input[1]);

			if (R >= 2 * L)
				System.out.println(-1);
			else
				System.out.println(R);

		}

	}

}