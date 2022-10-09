package N2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] map;
	static int N, M;

	static class Pos {
		int i, j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	static Queue<Pos> q = new LinkedList<>();
	static Queue<Pos> chq = new LinkedList<>();
	static int cheese;

	public static void main(String[] args) throws IOException {
		int cheese = 0; // 다 녹기 직전에 남은 치즈 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0, k = 0; j < M; j++, k += 2) {
				if (i == 0 && j == 0) {
					// 시작은 무조건 넣기(어차피 여기에는 치즈 안들어감)
					isVisited[0][0] = true;
					q.add(new Pos(0, 0));
				}
				map[i][j] = str.charAt(k);
				if (map[i][j] == '1')
					cheese++; // 현재 치즈 개수
			}
		} // =========== 입력 끝

		// 처음 공기 넣기
		bfsAir();

		int time = 0;
		while (cheese > 0) {
			time++;

			// 녹을 치즈 개수
			meltCnt = chq.size();
			// 이번 턴에서 다 녹으면 아웃
			if (cheese - meltCnt == 0) {
				System.out.println(time + "\n" + cheese);
				break;
			}
			// 아니면 녹이기
			else {
				while (chq.size() > 0) {
					Pos curCh = chq.poll();
					map[curCh.i][curCh.j] = 'a';
				}
				cheese -= meltCnt;
			}

			// 공기 넣기
			q = new LinkedList<>();
			// 공기 위치 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '0') {
						for (int d = 0; d < deltas.length; d++) {
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];
							
						}
					}
				}
				if (q.size() != 0)
					break;
			}
		}

	}

	static void debugMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int meltCnt;

	static void bfsAir() {
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			if (map[cur.i][cur.j] == '0') {
				map[cur.i][cur.j] = 'a';
			}

			for (int d = 0; d < deltas.length; d++) {
				int ni = cur.i + deltas[d][0];
				int nj = cur.j + deltas[d][1];
				if (isInMap(ni, nj)) {
					if (isVisited[ni][nj])
						continue;
					else {
						if (map[ni][nj] == '0') {
							isVisited[ni][nj] = true;
							q.add(new Pos(ni, nj));
						} else if (map[ni][nj] == '1') {
							map[ni][nj] = 'c';
							chq.add(new Pos(ni, nj));
						}
					}
				}
			}
		}
	}

	static boolean[][] isVisited;

	static boolean isInMap(int ni, int nj) {
		if (ni >= 0 && ni < N && nj >= 0 && nj < M)
			return true;
		else
			return false;
	}
}
