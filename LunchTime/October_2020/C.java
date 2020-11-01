
//Chef Liked Good Sequence

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class C {


	public static void main(String[] args) throws IOException {
		new C().solve();
	}

	private void solve() throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(f.readLine());
		for (int t1 = 0; t1 < t; t1++) {
			StringTokenizer tokenizer = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int q = Integer.parseInt(tokenizer.nextToken());
			int[] ar = new int[n];
			tokenizer = new StringTokenizer(f.readLine());
			for (int i = 0; i < n; i++) {
				ar[i] = Integer.parseInt(tokenizer.nextToken());
			}

			int prev = ar[0];
			int curr = 1;
			for (int i = 1; i < n; i++) {
				if (ar[i] != prev) {
					curr++;
					prev = ar[i];
				}
			}

			for (int q1 = 0; q1 < q; q1++) {
				tokenizer = new StringTokenizer(f.readLine());
				int x = Integer.parseInt(tokenizer.nextToken()) - 1;
				int y = Integer.parseInt(tokenizer.nextToken());

				if (x != 0) {
					if (ar[x - 1] == ar[x]) curr++;
				}
				if (x != n - 1) {
					if (ar[x + 1] == ar[x]) curr++;
				}

				ar[x] = y;

				if (x != 0) {
					if (ar[x - 1] == ar[x]) curr--;
				}
				if (x != n - 1) {
					if (ar[x + 1] == ar[x]) curr--;
				}

				out.println(curr);
			}
		}

		out.close();
	}
}