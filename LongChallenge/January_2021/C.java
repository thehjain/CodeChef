import java.util.*;
import java.io.*;
class C {
	public static void main(String []args) {
		FastScanner KB = new FastScanner();
		int T = KB.nextInt();
		for (int k = 1; k <= T; k++) {
			long N = KB.nextLong();
			Map<Long, Long> mp = new HashMap<>();
			ArrayList<Long>[] arrmain = new ArrayList[(int) N];

			for (int kk = 0; kk < N; kk++) {
				long M = KB.nextLong();
				ArrayList<Long> arr1 = new ArrayList<Long>();
				for (int j = 0; j < M; j++) {
					arr1.add(KB.nextLong());
				}
				// System.out.println(arr1);
				arrmain[kk] = arr1;

				for (int i = 0; i < arr1.size(); i++) {
					if (mp.containsKey(Math.abs(arr1.get(i)))) {
						mp.put(Math.abs(arr1.get(i)), mp.get(Math.abs(arr1.get(i))) + 1);
					} else {
						mp.put(Math.abs(arr1.get(i)), (long) 1);
					}
				}
			}

			long tcoun = 0;
			for (int i = 0; i < N; i++) {
				ArrayList<Long> arrv2 = arrmain[i];
				ArrayList<Long> pos = new ArrayList<Long>();
				ArrayList<Long> neg = new ArrayList<Long>();
				// System.out.println(arrv2);
				for (int j = 0; j < arrv2.size(); j++) {
					long kp = arrv2.get(j);
					if (kp < 0) {
						neg.add(- (kp));
					} else {
						pos.add(kp);
					}
				}
				Collections.sort(pos);
				Collections.sort(neg);

				// System.out.println(pos);
				// System.out.println(neg);

				for (int j = 0; j < pos.size(); j++) {
					if (mp.get(pos.get(j)) > 1) {
						tcoun += (pos.size() - j - 1);
					} else {
						tcoun += neg.size() - Math.abs(Collections.binarySearch(neg, pos.get(j))) + 1;
					}
				}

				for (int j = 0; j < neg.size(); j++) {
					if (mp.get(neg.get(j)) > 1) {
						tcoun += (neg.size() - j - 1);
					} else {
						tcoun += pos.size() - Math.abs(Collections.binarySearch(pos, neg.get(j))) + 1;
					}
				}
			}

			long orcolli = 0;
			for (Map.Entry<Long, Long> entry : mp.entrySet()) {
				if (entry.getValue() > 1) {
					orcolli++;
				}
			}
			System.out.println(orcolli + tcoun);

//          for (Map.Entry<Long,Long> entry : mp.entrySet())
//          {
//              System.out.println(entry.getKey() + " " + entry.getValue());
//          }
//          for (int i = 0; i < arrmain.length; i++)
//          {
//           	ArrayList<Long> arr2=arrmain[i];
//            	System.out.println(arr2);
//			}
		}
	}

	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}