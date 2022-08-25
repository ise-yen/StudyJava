package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	static int[][] W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		visited = new boolean[N]; // 방문한 도시인지
		for (int i = 0; i < W.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W[i].length; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < W.length; i++) {
			dfs(i, i, 0, 0);
		}
		System.out.println(min);
	}

	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	static void dfs(int start, int end, int sum, int cnt) {
		if (cnt == visited.length && start == end) {
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < W.length; i++) {
			if (W[end][i] == 0)
				continue;
			if (!visited[i]) {
				visited[i] = true;
				sum += W[start][end];

				dfs(end, i, sum, cnt + 1);
			}
			visited[i] = false;
			sum -= W[start][end];
		}
	}
}
