import java.util.*;
import java.io.*;
import java.math.*;

class C {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {

			int N = Integer.parseInt(br.readLine());

			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

			for (int i = 0; i <= N; i++)
				graph.add(new ArrayList<>());

			for (int i = 0; i < N - 1; i++) {
				String[] input = br.readLine().trim().split(" ");
				int u = Integer.parseInt(input[0]);
				int v = Integer.parseInt(input[1]);
				graph.get(u).add(v);
				graph.get(v).add(u);
			}

			int[] res = new int[N + 1];

			res[0] = 1;
			dfs(1, 0, res, graph);

			for (int i = 1; i <= N; i++)
				System.out.print(res[i] + " ");
			System.out.println();

		}

	}
	static void dfs(int u, int ele, int[] res, ArrayList<ArrayList<Integer>> graph) {
		res[u] = (res[ele] == 1) ? 2 : 1;
		for (int i = 0; i < graph.get(u).size(); i++) {
			int temp = graph.get(u).get(i);
			if (temp != ele)
				dfs(temp, u, res, graph);
		}
	}

}