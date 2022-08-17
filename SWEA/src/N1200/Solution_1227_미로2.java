package N1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1227_미로2 {
	static int size = 100;
	static int[][] map;
	// 오른쪽 - 아래 - 왼쪽 - 위쪽 순으로 탐색(미로: 오른법칙)
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int res = 0;
			Integer.parseInt(br.readLine()); // tc 입력 버리기
			
			// 출발점
			int startI = 0;
			int startJ = 0;

			// 도착점
			int endI = 0;
			int endJ = 0;

			// 미로 맵 입력 && 출발, 도착 지점 탐색
			map = new int[size][size];
			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j) - '0';
					if (map[i][j] == 2) {
						startI = i;
						startJ = j;
					} else if (map[i][j] == 3) {
						endI = i;
						endJ = j;
					}
				}
			}

			int pi = startJ;
			int pj = startI;

			boolean[][] visited = new boolean[size][size]; // 방문 체크
			while (pi != endI && pj != endJ) {
				// 사방 중에 3이 있으면 탈출
				for (int k = 0; k < di.length; k++) {
					if (map[pi + di[k]][pj + di[k]] == 3) {
						res = 1;
						break;
					}
				}
				if (res == 1)
					break;

				// 오른손법칙 탐색
				int cnt = 0;
				for (int k = 0; k < di.length; k++) {
					cnt++;
					if(visited[pi + di[k]][pj + di[k]] == false) {
						if (map[pi + di[k]][pj + di[k]] == 0 || map[pi + di[k]][pj + di[k]] == 2) {
							pi += di[k];
							pj += di[k];
							break;
						}
						visited[pi + di[k]][pj + di[k]] = true;
					}
					if(cnt == 4) {
						pi = startI;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(res).append("\n");
		} // end of for testCase

	} // end of main

} // end of class
