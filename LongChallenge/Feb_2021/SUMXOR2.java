import java.util.*;
import java.io.*;
import java.math.*;

class SUMXOR2 {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 998244353;
	static Reader sc = new Reader();
	static StringBuilder sb = new StringBuilder();
	static long[] fact;
	static int[] noOfOnes;
	static int[] noOfZeros;
	static long[] prefix;
	static long[] sum;

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		long[] arr = new long[n];

		long max = Long.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
			if (arr[i] > max)
				max = arr[i];
		}

		fact = new long[n + 1];

		fillFact(n);

		int size = powerOf2(max);

		noOfOnes = new int[size + 1];
		noOfZeros = new int[size + 1];
		prefix = new long[n + 1];
		sum = new long[n + 1];

		// System.out.println(size);

		fillOnesZeros(arr, n, size);
		fillSumArray(arr, size, n);

		int noOfQueries = sc.nextInt();

		while (noOfQueries-- > 0) {

			int length = sc.nextInt();

			sb.append(prefix[length] + "\n");

		}

		System.out.print(sb);

	}

	static void fillSumArray(long[] arr, int size, int n) {

		for (int i = 1; i <= n; i++) {

			long ans = 0;

			// System.out.println(size);

			for (int k = 1; k <= i; k += 2)
				for (int j = 0; j <= size; j++) {
					// System.out.println(ans);
					ans  = (ans + (nCr(noOfOnes[j], k) * nCr(noOfZeros[j], i - k)  * (1 << (j))) % MOD);
				}

			sum[i] = ans;

			// System.out.println(ans);

			if (i == 1)
				prefix[i] = sum[i];
			else
				prefix[i] = (prefix[i - 1] + sum[i]) % MOD;

		}

	}



	static int powerOf2(long n) {
		// System.out.println(n);
		int pos = (int)(Math.log(n) / Math.log(2));
		// System.out.println(pos);
		return pos;
	}

	static int nCr(int n, int r) {
		// System.out.println(n + " " + r);
		if (n < r)
			return 0;
		if (n == r)
			return 1;
		return (int)(fact[n]  / (fact[r]  *
		                         fact[n - r]) % MOD);
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