package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS_그래프 {

	static int N, M, V;
	static int[][] graphs;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graphs = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			graphs[i][j] = 1;
			graphs[j][i] = 1;
		}

		dfs(V);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(V);
	}

	static void dfs(int v) {
		System.out.print(v + " ");
		visited[v] = true;
		for (int i = 1; i <= N; i++) {
			if (visited[i] || graphs[v][i] == 0)
				continue;
			dfs(i);
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			v = q.peek();
			System.out.print(q.peek() + " ");
			q.poll();
			for (int i = 1; i <= N; i++) {
				if (visited[i] || graphs[v][i] == 0)
					continue;
				q.offer(i);
				visited[i] = true;
			}
		}
	}
}
