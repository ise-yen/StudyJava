package supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1227_미로2 {
	private static int size = 100;
	private static int[][] map;
//	private static boolean[][] visited; // 방문 장소를 벽으로 만들 수도 있음

	// 상하좌우
	private static int[] dr = { -1, 1, 0, 01 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			Integer.parseInt(br.readLine()); // tc 입력 버리기

//			visited = new boolean[size][size]; // 방문 체크
			// 출발점
			int startI = 0;
			int startJ = 0;

			// 미로 맵 입력 && 출발, 도착 지점 탐색
			map = new int[size][size];
			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '2') {
						startI = i;
						startJ = j;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(dfs(startI, startJ)).append("\n");
		} // end of for testCase
		System.out.println(sb.toString());

	} // end of main

	/** '3'에 도착하면 1을 리턴, 0을 리턴 */
	public static int dfs(int r, int c) {
		// 전진하다가 막다른 곳에 돌아오면 되돌아가기
		// 이미 방문한 곳이거나 막혔으면 탈출
		if (/*visited[r][c] || */map[r][c] == '1')
			return 0;

		// 도착점이면 성공으로 리턴
		if (map[r][c] == '3')
			return 1;

		// 지나가기
//		visited[r][c] = true;
		map[r][c] = '1'; // 지나간 길을 벽으로 만들기
		int result = 0;
		for (int i = 0; i < dc.length && result == 0; i++) {
			result = dfs(r + dr[i], c + dc[i]);
		}
		return result;
	}

} // end of class
