
//Hail Xor

import java.util.*;
import java.io.*;
import java.math.*;
class E {

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
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}  while ((c = read()) >= '0' && c <= '9');

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
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
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

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static Reader br = new Reader();

	public static void main(String[] args) throws IOException {
		int T = br.nextInt();
		while (T-- != 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		//String[] input = br.readLine().trim().split(" ");

		// int N = Integer.parseInt(input[0]);
		// int X = Integer.parseInt(input[1]);

		int N = br.nextInt();
		int X = br.nextInt();

		//X = Math.min(N, X);

		//String[] s = br.readLine().trim().split(" ");

		int[] arr = new int[N];
		// int index = 0;
		// for (String ele : s)
		// 	arr[index++] = ;

		for (int i = 0; i < N; i++)
			arr[i] = br.nextInt();

		hailXor(N, X, arr);

		for (int ele : arr)
			System.out.print(ele + " ");

		System.out.println();
	}

	// static void hailXor(int N, int X, int[] arr) {
	// 	if (X % 2 == 0) {
	// 		int temp = 2;
	// 		while (temp-- > 0) {
	// 			int pow = findPower(arr[0]);
	// 			arr[0] ^= pow;
	// 			arr[1] ^= pow;
	// 		}
	// 	} else {
	// 		int pow = findPower(arr[0]);
	// 		arr[0] ^= pow;
	// 		arr[1] ^= pow;
	// 	}
	// }

	static void hailXor(int N, int X, int[] arr) {
		//X = Math.min(X, N);
		for (int iterator = 0; iterator < X; iterator++) {
			int i = 0, j = 1;
			while (arr[i] == 0 && i < N - 2) i++;
			int temp = findPower(arr[i]);
			while (j < N) {
				int curr = findPower(arr[j]);
				if (temp == curr) {
					arr[i] ^= temp;
					arr[j] ^= temp;
					break;
				}
				if (j == N - 1) {
					arr[i] ^= temp;
					arr[j] ^= temp;
				}
				j++;
			}
		}
	}

	// static void hailXor(int N, int X, int[] arr) {

	// 	int temp = MAX;
	// 	// if (X % 2 == 0) X = 2;
	// 	// else X = 1;
	// 	// if (X > N) {
	// 	// 	if (X % 2 == 0) X = N + 1;
	// 	// 	else X = N;
	// 	// }
	// 	// if (X > N) {
	// 	// 	if ((X - N) % 2 == 0) X = N;
	// 	// 	else X = N + 1;
	// 	// }
	// 	while (X-- > 0) {
	// 		for (int i = 0; i < N - 1; i++) {
	// 			if (arr[i] != 0 || (i == N - 2)) {
	// 				int powTwo = findPower(arr[i]);
	// 				arr[i] ^= powTwo;
	// 				for (int j = i + 1; j < N; j++) {
	// 					if ((arr[j] ^ powTwo) < arr[j]) {
	// 						arr[j] ^= powTwo;
	// 						break;
	// 					}
	// 					if (j == N - 1)
	// 						arr[j] ^= powTwo;
	// 				}
	// 				break;
	// 			}
	// 		}
	// 		// for (int ele : arr)
	// 		// 	System.out.print(ele + " ");
	// 		// System.out.println();
	// 	}
	// }
	static int findPower(int n) {

		if (n == 0) return 1;

		int p = (int)(Math.log(n) /
		              Math.log(2));
		return (int)Math.pow(2, p);
	}
}

