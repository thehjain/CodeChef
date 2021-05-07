import java.util.*;
import java.io.*;
import java.math.*;

class KAVGMAT {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static Reader sc = new Reader();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int m = sc.nextInt();

		double k = sc.nextDouble();

		double[][] arr = new double[n + 1][m + 1];

		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++)
				if (i == 0 || j == 0)
					arr[i][j] = 0;
				else
					arr[i][j] = sc.nextDouble();

		for (int i = 0; i <= n; i++) {
			double pre = 0;
			for (int j = 0; j <= m; j++) {
				arr[i][j] += pre;
				pre = arr[i][j];
			}
		}

		for (int j = 0; j <= m; j++) {
			double pre = 0;
			for (int i = 0; i <= n; i++) {
				arr[i][j] += pre;
				pre = arr[i][j];
			}
		}


		int z = Math.min(n, m);

		long count = 0;

		for (int len = 1; len <= z; len++) {
			for (int i = len; i <= n; i++) {
				for (int j = len; j <= m; j++) {
					if ((arr[i][j] + arr[i - len][j - len] - arr[i][j - len] - arr[i - len][j]) / (len * len) >= k)
						count++;
				}
			}
		}

		sb.append(count + "\n");

	}

	// static void solve() throws IOException {

	// 	int n = sc.nextInt();
	// 	int m = sc.nextInt();
	// 	long count = 0;
	// 	long sum = sc.nextLong();

	// 	long[][] arr = new long[n][m];
	// 	long[][] brr = new long[n + 1][m + 1];

	// 	for (int i = 1; i <= n; i++) {
	// 		for (int j = 1; j <= m; j++) {

	// 			long c = sc.nextLong();

	// 			arr[i - 1][j - 1] = c;

	// 			brr[i][j] = brr[i - 1][j] + brr[i][j - 1] - brr[i - 1][j - 1] + arr[i - 1][j - 1];

	// 		}
	// 	}

	// 	// printMatrix(brr);

	// 	int k = 1;

	// 	while (k <= n && k <= m) {
	// 		for (int i = k; i <= n; i++) {
	// 			for (int j = k; j <= m; j++) {
	// 				if (i - k >= 0 && j - k >= 0) {
	// 					long temp = brr[i][j] - brr[i][j - k] - brr[i - k][j] + brr[i - k][j - k];
	// 					if ((temp / (k * k)) >= sum)
	// 						count++;
	// 				}
	// 			}
	// 		}
	// 		k++;
	// 	}

	// 	sb.append(count + "\n");

	// }

	// static void solve() throws IOException {

	// 	int n = sc.nextInt();
	// 	int m = sc.nextInt();
	// 	long sum = sc.nextLong();

	// 	long[][] arr = new long[n][m];

	// 	for (int i = 0; i < n; i++)
	// 		for (int j = 0; j < m; j++)
	// 			arr[i][j] = sc.nextLong();

	// 	long count = 0;

	// 	for (long[] row : arr)
	// 		for (long ele : row)
	// 			if (ele >= sum) count++;

	// 	// System.out.println(count);

	// 	//Row Wise Prefix Sum
	// 	for (int i = 0; i < n; i++)
	// 		for (int j = 1; j < m; j++)
	// 			arr[i][j] += arr[i][j - 1];

	// 	//Column Wise Prefix Sum
	// 	for (int i = 1; i < n; i++)
	// 		for (int j = 0; j < m; j++)
	// 			arr[i][j] += arr[i - 1][j];

	// 	//print matrix
	// 	// for (int[] row : arr) {
	// 	// 	for (int ele : row)
	// 	// 		System.out.print(ele + " ");
	// 	// 	System.out.println();
	// 	// }

	// 	//Checking for every submatrix

	// 	for (int i = 1; i < n; i++) {
	// 		for (int j = 1; j < m; j++) {

	// 			if (arr[i][j] <= sum)
	// 				continue;

	// 			if (i == 1 && j == 1) {
	// 				if (arr[i][j] / 4 >= sum)
	// 					count++;
	// 				continue;
	// 			}

	// 			for (int k = 2; (i - k) >= 0 || (j - k) >= 0; k++) {
	// 				if (i - k >= 0 && j - k >= 0) {
	// 					long temp = arr[i][j] - arr[i - k][j] - arr[i][j - k] + arr[i - k][j - k];
	// 					if (temp / (long)Math.pow(k, 2) >= sum) {
	// 						// System.out.println("hello");
	// 						// System.out.println(k);
	// 						count++;
	// 					}
	// 					continue;
	// 				}
	// 				if (i - k >= 0) {
	// 					long temp = arr[i][j] - arr[i - k][j];
	// 					if (temp / (long)Math.pow(k, 2) >= sum) {
	// 						// System.out.println("hello");
	// 						count++;
	// 					}
	// 					continue;
	// 				}
	// 				if (j - k >= 0) {
	// 					long temp = arr[i][j] - arr[i][j - k];
	// 					if (temp / (long)Math.pow(k, 2) >= sum) {
	// 						// System.out.println("hello");
	// 						count++;
	// 					}
	// 					continue;
	// 				}
	// 				// System.out.println("hello");
	// 			}

	// 			// System.out.println("hello");

	// 		}
	// 	}

	// 	if (n == m)
	// 		if (arr[n - 1][m - 1] / (n * m) >= sum)
	// 			count++;

	// 	sb.append(count + "\n");

	// }

	static void printMatrix(long[][] arr) {
		for (long[] row : arr) {
			for (long ele : row)
				System.out.print(ele + " ");
			System.out.println();
		}
	}

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(
			    new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					if (cnt != 0) {
						break;
					} else {
						continue;
					}
				}
				buf[cnt++] = (byte)c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0,
			                     BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

}