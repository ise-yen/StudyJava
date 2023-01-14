package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	static int N, M, X;
	static int[][] Map;
	static int[] Time; // n번째 학생이 X까지 가는데 걸리는 시간
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		int max = Integer.MIN_VALUE; // 가장 오래 걸리는 학생의 소요 시간 (왕복)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 마을 개수
		M = Integer.parseInt(st.nextToken()); // 단방향 도로 개수
		X = Integer.parseInt(st.nextToken());
		Map = new int[N + 1][N + 1];
		isVisited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 시작점, 끝점, 소요 시간
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Map[start][end] = Integer.parseInt(st.nextToken());
		}

	}

	static void MapDebug() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void HomeToX() {

	}

	static void XToHome() {

	}

	static void dfs(int v, int cnt) {
		if(cnt == )
		isVisited[v] = true;

		for (int i = 1; i < N + 1; i++) {
			if (!isVisited[v]) {
				dfs(v);
			}
		}
	}

}
