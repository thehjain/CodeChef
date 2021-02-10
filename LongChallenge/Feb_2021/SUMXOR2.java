import java.util.*;
import java.io.*;
import java.math.*;

class SUMXOR2 {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 998244353;
	static Reader sc = new Reader();
	static StringBuilder sb = new StringBuilder();
	// static long sum = 0;
	static HashMap<Integer, Long> map = new HashMap<>();
	static HashMap<Integer, Long> res = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		long[] arr = new long[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();

		int noOfQueries = sc.nextInt();

		while (noOfQueries-- > 0) {

			int length = sc.nextInt();
			long sum = 0;

			if (res.containsKey(length)) {
				sb.append(res.get(length) + "\n");
				continue;
			}

			for (int i = 1; i <= length; i++) {
				if (map.containsKey(i)) {
					sum =  (sum % MOD + map.get(i) % MOD) % MOD;
					continue;
				}
				sum = (sum % MOD + findSum(arr, n, i, 0, 0) % MOD) % MOD;
			}

			res.put(length, sum);

			sb.append(sum + "\n");

		}

		System.out.print(sb);
	}

	static long findSum(long[] arr, int n, int length, int currLength, long tempSum) {

		// System.out.println(tempSum);2

		if (currLength == length)
			return tempSum % MOD;
		if (n == 0)
			return 0;
		if (currLength > length)
			return 0;

		long temp = (findSum(arr, n - 1, length, currLength, tempSum) % MOD +
		             findSum(arr, n - 1, length, currLength + 1, tempSum ^ arr[n - 1]) % MOD) % MOD;
		map.put(length, temp);
		return temp;

	}

	// static void findXor(long[] arr, int pos, int n, int len, long curr) {

	// 	if (pos == len) {
	// 		// System.out.println(curr);
	// 		if (!map.containsKey(len))
	// 			map.put(len, (long)0);
	// 		map.put(len, map.get(len) + curr % MOD);
	// 		return;
	// 	}

	// 	for (int i = 0 ; i < n; i++) {
	// 		// System.out.println(arr[i]);
	// 		findXor(arr, pos + 1, n, len, curr ^ arr[i]);
	// 	}

	// }

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