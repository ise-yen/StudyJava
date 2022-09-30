package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5648_원자소멸시뮬레이션 {

	// x = j(열), y = i(행)
	static int N; // 원자 수
	static int[][] map;
	static BombAtom[] allK;
	static Atom[] allAtom;

	static class Atom {
		int n; // 몇 번째 원자인지
		int x, y; // 좌표(열-가로, 행-세로)
		int dir; // 방향
		int k; // 에너지

		Atom(int n, int x, int y, int dir, int k) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.k = k;
		}
	}

	static class BombAtom {
		int sumK;
		int cntAtom;

		BombAtom(int sumK, int cntAtom) {
			this.sumK = sumK;
			this.cntAtom = cntAtom;
		}
	}

	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int res = 0; // 정답 = 방출하는 에너지
			int N = Integer.parseInt(br.readLine()); // 원자 수
			allAtom = new Atom[N + 1]; // 1~N개 + 0번째

			StringTokenizer st = null;
			map = new int[2001][2001];
			allK = new BombAtom[N + 1];
			int maxRange = Integer.MIN_VALUE;
			// 입력
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 가로
				int y = Integer.parseInt(st.nextToken()); // 세로
				int dir = Integer.parseInt(st.nextToken()); // 이동 방향
				int k = Integer.parseInt(st.nextToken()); // 에너지

				// 원자 만들어서 allAtom(의 index = 각자의 번호)에 넣어주기
				Atom atom = new Atom(n, x, y, dir, k);
				allAtom[n] = atom;
				
				// 맵에 원자가 존재한다고 표시해주기
				map[y][x] = n;

				// 반복문 돌릴 때 원자가 이동할 리 없는 범위는 최대한 컷
				int max = Integer.max(Math.abs(x), Math.abs(y));
				maxRange = Integer.max(max, maxRange);

			} // end of input

			// 가장 멀리있는애 기준으로 반복
			while (maxRange >= -1000) {
				maxRange--;
				for (int i = 1; i < allAtom.length; i++) {
					Atom at = allAtom[i];

					// 이동 후 좌표
					int nx = at.x;
					int ny = at.y;
					switch (at.dir) {
					case 0: // 상
						ny = at.y - 1;
						break;
					case 1: // 하
						ny = at.y + 1;
						break;
					case 2: // 좌
						nx = at.x - 1;
						break;
					case 3: // 우
						ny = at.y + 1;
						break;
					}

					// 이동 장소에 에너지 배치(이미 에너지가 있는 곳이면 더해주기)
					if (map[nx][ny] != 0) {
						map[nx][ny] = at.n;
						map[at.x][at.y] = 0; // 이동 전 자리 초기화
						
						// 이동한 자리로 업데이트
						allAtom[i].x = nx;
						allAtom[i].y = ny;
						
						BombAtom ba = new BombAtom(1, at.k);
						allK[at.n] = ba;
					} else {
						
					}
				}

				for (int i = 1; i < allK.length; i++) {

				}

			}
		} // end of test case

	}
}
