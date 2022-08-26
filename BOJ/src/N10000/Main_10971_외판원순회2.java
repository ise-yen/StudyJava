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
		W = new int[N + 1][N + 1];
		for (int i = 1; i < W.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < W[i].length; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < W.length; i++) {
			System.out.println("start : " + i);
			visited = new boolean[N + 1]; // 방문한 도시인지
			min = Integer.MAX_VALUE;
			dfs(i, i, 0, 1);
			System.out.println();
		}
		System.out.println(min);
	}

	static boolean[] visited;
	static int min;

	static void dfs(int start, int end, int sum, int cnt) {
		if (cnt == visited.length && start == end) {
			System.out.println("[종료]" + start + " -> " + end + " : " + sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 1; i < W.length; i++) {
			if (i == end && cnt == visited.length - 1) {
				sum += W[start][end];
				System.out.println(start + " -> " + i + " : " + sum + "(" + cnt + ")");
				dfs(i, end, sum, cnt + 1);
			}
			if (i != end && cnt < visited.length - 1 && !visited[i]) {
				if (W[start][i] == 0)
					continue;
				visited[i] = true;
				sum += W[start][i];
				System.out.println(start + " -> " + i + " : " + sum + "(" + cnt + ")");
				dfs(i, end, sum, cnt + 1);
				visited[i] = false;
				sum -= W[start][i];
			}

		}

	}
}
