package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import SWtest.Solution_2382_미생물격리.eDir;

public class Solution_5648_원자소멸시뮬레이션 {

	// x = j(열), y = i(행)
	static int N; // 원자 수
	static int[] K; // 각 원자들의 에너지
	static int[][] map;
	static eDir[] dir; // 군집당 방향

	static class Atom {
		int x, y; // 좌표(열-가로, 행-세로)
		int k; // 에너지

		Atom(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	static enum eDir {
		up, down, left, right
	};

	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int res = 0; // 정답 = M시간 후 남아있는 미생물의 수
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 가로
				int y = Integer.parseInt(st.nextToken()); // 세로
				int dir = Integer.parseInt(st.nextToken()); // 이동 방향
				K[n] = Integer.parseInt(st.nextToken()); // 에너지

			}
		}

	}
}
