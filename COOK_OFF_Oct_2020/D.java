import java.util.*;
import java.io.*;
import java.math.*;

class D {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		ArrayList<Integer> res = new ArrayList<>();

		while (T-- != 0) {

			res.clear();

			int D = Integer.parseInt(br.readLine());

			if (D == 0)
				res.add(1);

			int P = (int)Math.pow(10, 5) - 2;

			while (D > 0) {
				P = Math.min(D, P);
				res.add(P + 2);
				res.add(P + 1);
				res.add(1);
				D -= P;
			}
			System.out.println(res.size());
			for (int ele : res)
				System.out.print(ele + " ");
			System.out.println();
		}
	}

}