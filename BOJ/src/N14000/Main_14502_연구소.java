package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int N, M;
	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	// 0 : 빈칸, 1 : 벽, 2 : 바이러스

	static int arr[];
	static boolean selected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ============= 입력 끝

		// 가벽을 세울 만한 위치
		ArrayList<Point> posL = new ArrayList<Point>();

		// 돌리면서 0일 때, 주변에 2가 있는지 체크. 2가 있으면 벽 세울 수 있는 좌표 후보
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					for (int d = 0; d < deltas.length; d++) {
						int di = i + deltas[d][0];
						int dj = j + deltas[d][1];
						if (map[di][dj] == 2)
							posL.add(new Point(di, dj));
					}
				}
			}
		}

		selected = new boolean[posL.size()];
		arr = new int[posL.size()];

		for (int a = 0; a < arr.length; a++) {
			// 후보군 위치에 벽을 세웠을 때
			int mi = posL.get(arr[a]).i;
			int mj = posL.get(arr[a]).j;
			map[mi][mj] = 1;

			// 바이러스 확산
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 2) {
						int r = 1;
						for (int d = 0; d < deltas.length; d++) {
							int di = i + deltas[d][0] * r;
							int dj = j + deltas[d][1] * r;
							if (map[di][dj] == 0) {
								posL.add(new Point(di, dj));
								r++;
							}
						}
					}
				}
			}
		}

		// 후보에 가벽이 있을 때 안전구역 크기 구하기
	}

	static void perm(int cnt, int size) {
		// 후보 중 3개 뽑았으면
		if (cnt == 3) {
			return;
		}

		for (int i = 0; i < size; i++) {
			if (selected[i])
				continue;
			else {
				arr[i] = 0;
			}
		}
	}
}
