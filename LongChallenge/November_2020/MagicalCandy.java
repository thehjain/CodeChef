import java.util.*;
import java.io.*;
import java.math.*;

class MagicalCandy {

	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;
	static int MOD = 1000000007;
	static class FastReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastReader(String file_name) throws IOException {
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

	static FastReader br = new FastReader();


	public static void main(String[] args) throws IOException {
		int T = br.nextInt();
		while (T-- != 0) {
			solve();
		}
	}


	static void solve() throws IOException {

		int n = br.nextInt();
		//String[] input=br.readLine().trim().split(" ");

		long[] a = new long[n];
		long l = 0, t = -1;

		for (int i = 0; i < n; i++) {

			a[i] = br.nextLong();

			if (a[i] == 1) {
				if (i == 0)
					l = 1;
				else if (i != n - 1) {
					l = 2;
					t = i;
				}
			}
		}

		if (l == 1) {
			long r = br.nextLong();
			while (r-- > 0) {
				long val = br.nextLong();
				long ans;
				if (val % n == 0) {
					System.out.println((val / n) % MOD);
				} else {
					if (val % n == 1 && val > n) {
						System.out.println((val / n) % MOD);
					} else {
						System.out.println((val / n + 1) % MOD);
					}
				}
			}
		} else if (l == 2) {
			long total = 0;
			long temp[] = new long[100000];
			for (int i = 0; i < n - 1; i++) {
				if (i != t - 1) {
					if (a[i] % 2 == 0) {
						total += a[i];
						temp[i] = total;
					} else {
						total += a[i] - 1;
						temp[i] = total;
					}
				} else {
					if (a[i] % 2 == 0) {
						total += a[i] - 1;
						temp[i] = total;
					} else {
						total += a[i];
						temp[i] = total;
					}
				}
			}
			if (a[n - 1] % 2 == 0) {
				total += a[n - 1] - 1;
			} else {
				total += a[n - 1];
			}
			long r = br.nextLong();
			while (r-- > 0) {
				long val = br.nextLong();
				if (val % n == 0) {
					if (a[n - 1] % 2 == 0) {
						System.out.println(((val / n) * total + 1) % MOD);
					} else {
						System.out.println(((val / n) * total) % MOD);
					}
				} else {
					if (t == val % n - 1) {
						if (a[(int)(t - 1)] % 2 == 0) {
							System.out.println(((val / n) * total + temp[(int)(val % n - 1)] + 2) % MOD);
						} else {
							System.out.println(((val / n) * total + temp[(int)(val % n - 1)]) % MOD);
						}
					} else if (t - 1 == val % n - 1) {
						if (a[(int)(t - 1)] % 2 == 0) {
							System.out.println(((val / n) * total + temp[(int)(val % n - 1)] + 1) % MOD);
						} else {
							System.out.println(((val / n) * total + temp[(int)(val % n - 1)]) % MOD);
						}
					} else {
						if (a[(int)(val % n - 1)] % 2 == 1) {
							System.out.println(((val / n) * total + temp[(int)(val % n - 1)] + 1) % MOD);
						} else {
							System.out.println(((val / n) * total + temp[(int)(val % n - 1)]) % MOD);
						}
					}
				}
			}
		} else {
			long total = 0;
			long[] temp = new long[100000];
			for (int i = 0; i < n - 1; i++) {
				if (a[i] % 2 == 1) {
					total += a[i] - 1;
					temp[i] = total;
				} else {
					total += a[i];
					temp[i] = total;
				}
			}
			if (a[n - 1] % 2 == 0) {
				total += a[n - 1] - 1;
			} else {
				total += a[n - 1];
			}
			long r = br.nextLong();
			while (r-- > 0) {
				long val = br.nextLong();
				if (val % n == 0) {
					if ((a[n - 1] % 2) == 0) {
						System.out.println(((val / n) * total + 1) % MOD);
					} else {
						System.out.println(((val / n) * total) % MOD);
					}
				} else {
					if (a[(int)(val % n - 1)] % 2 == 1) {
						System.out.println(((val / n) * total + temp[(int)(val % n - 1)] + 1) % MOD);
					} else {
						System.out.println(((val / n) * total + temp[(int)(val % n - 1)]) % MOD);
					}
				}
			}
		}

	}

}