package N1800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
//	int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N;
	static int[][] room;
	static int minRoom; // 최대 방문 가능한 방 중 가장 작은 수
	static int maxVisit; // 방문한 방 개수의 최대값
	static boolean isStart;
	static int visit; // 방문한 중인 방 개수
	static int startNum; // 방문 시작한 방 번호

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			// 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			minRoom = N * N;
			maxVisit = 1;

			int tmp = 0;
			// 방 돌기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					isStart = false;
					visit = 1;
					startNum = room[i][j];
					tmp++;
					CheckRoom(i, j);
//					System.out.println(tmp + " m: " + minRoom + ", s: " + startNum + ", visit: " + visit);
					if (visit == maxVisit) {
						if (minRoom > startNum)
							minRoom = startNum;
					} else if (visit > maxVisit) {
						maxVisit = visit;
						minRoom = startNum;
					}

					isStart = false;
					visit = 1;
				}
			}
			sb.append("#" + t + " " + minRoom + " " + maxVisit + "\n");
		}
		System.out.println(sb);
	}

	static void CheckRoom(int i, int j) {
		boolean isFind = false;
		int check = 0;
		for (int k = 0; k < dx.length; k++) {
			// 인덱스 범위를 넘지 않으면서
			if (i + dx[k] >= 0 && i + dx[k] < N && j + dy[k] >= 0 && j + dy[k] < N) {
				check++;
				// 근처 방이 +1인 방이 있는지 찾기
				if (room[i][j] + 1 == room[i + dx[k]][j + dy[k]]) {
					if (!isStart) {
						isStart = true;
						startNum = room[i][j];
					}
					visit++;
//					System.out.println("i : " + i + " j : " + j + " visit : " + visit);
					i += dx[k];
					j += dy[k];
					isFind = true;
					break;
				}
				// 상하좌우 다 봤는데 없으면 나가기
				else {
//					System.out.println(check);
					if (check >= dx.length)
						return;
				}
			}
		}
		if (isFind) {
			CheckRoom(i, j);
		}
		return;
	}
}