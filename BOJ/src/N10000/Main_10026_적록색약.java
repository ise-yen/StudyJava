package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10026_적록색약 {
	static int N;
	static char[][] map;
	static char[][] mapEyes;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		mapEyes = new char[N][N];
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
				if (str.charAt(j) == 'G') {
					mapEyes[i][j] = 'R';
				} else {
					mapEyes[i][j] = str.charAt(j);
				}
			}
		}

		// [Debug] 출력
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(mapEyes[i][j]);
//			}
//			System.out.println();
//		}

		visited = new boolean[N][N];
		stk = new Stack<>();
		dfs(0, 0, map);
		sb.append(stk.size()).append(" ");

		visited = new boolean[N][N];
		stk = new Stack<>();
		dfs(0, 0, mapEyes);
		sb.append(stk.size());
		System.out.println(sb);
	}

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int res;

	static Stack<Character> stk;

	static void dfs(int i, int j, char[][] map) {
		int cnt = 0, ncnt = 0;
		visited[i][j] = true; // 현재 위치는 방문
		if (stk.isEmpty() || map[i][j] != stk.peek())
			stk.push(map[i][j]);

		// 주변 탐색
		for (int d = 0; d < deltas.length; d++) {
			int ni = i + deltas[d][0];
			int nj = j + deltas[d][0];
			cnt++;
			// 인덱스 범위 처리
			if (ni >= 0 && ni < map.length && nj >= 0 && nj < map.length) {
				if (!visited[ni][nj] && map[ni][nj] == map[i][j]) {
					visited[ni][nj] = true;
					dfs(ni, nj, map);
				} else {
					ncnt++;
				}
			}
		}
	}

}
