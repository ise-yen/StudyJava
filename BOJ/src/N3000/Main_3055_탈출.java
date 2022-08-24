package N3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static class pos {
		int i;
		int j;

		public pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	// 맵 정보
	static int R, C;
	static char[][] map;

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int dochiI = 0, dochiJ = 0; // 도치 위치
	static int caveI = 0, caveJ = 0; // 동굴 위치

	static Queue<pos> waterPos = new LinkedList<>();
	static int waterCnt = 48; // 물이 몇 번째에 확장됐는지 체크용
	static int emptyCnt; // 빈 공간 크기
	static int sumWaterCnt = 0; // 전체 물 체크

	static int minDochiMove = Integer.MAX_VALUE;
	static boolean[][] isVisited; // 방문 체크
	static boolean isFinish;

	static Queue<pos> dochiQ = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isVisited = new boolean[R][C];

		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					dochiI = i;
					dochiJ = j;
				} else if (map[i][j] == 'D') {
					caveI = i;
					caveJ = j;
				} else if (map[i][j] == '*') {
					waterPos.add(new pos(i, j));
					sumWaterCnt++;
					// 물 정보는 '*' 대신 숫자(waterCnt)로 표시. 몇 번째에 넓어졌는지 확인할 겸
					map[i][j] = (char) waterCnt;
				} else if (map[i][j] == '.')
					emptyCnt++;
			}
		} // =====> 입력 끝

		bfs(dochiI, dochiJ);

	}

	static void waterMove() {
		if (emptyCnt == sumWaterCnt) {
			System.out.println("KAKTUS");
			return;
		}

		int wSize = waterPos.size(); // 새로운 물 위치 업데이트되면 순식간에 홍수나므로 사이즈 별도 저장
		// 현재까지의 물 좌표 개수만큼 반복(물 확장시키기)
		for (int w = 0; w < wSize; w++) {
			// 인접 좌표들에 물 확장
			for (int d = 0; d < dr.length; d++) {
				int i = waterPos.peek().i;
				int j = waterPos.peek().j;
				if (map[i][j] == (char) waterCnt) {
					if (i + dr[d] >= 0 && i + dr[d] < map.length && j + dc[d] >= 0 && j + dc[d] < map[i].length) {
						if (map[i + dr[d]][j + dc[d]] == '.' || map[i + dr[d]][j + dc[d]] == 'S') {
							sumWaterCnt++;
							// 새로운 물 위치를 리스트와 map에 업데이트
							map[i + dr[d]][j + dc[d]] = (char) (waterCnt + 1);
							waterPos.add(new pos(i + dr[d], j + dc[d]));
						}
					}
				}
			}
			waterPos.poll();
		}
		waterCnt++; // 다음 확장될 물의 값 증가
		System.out.println("[" + (char) waterCnt + "번째]");
		Print();
	}

	private static void bfs(int i, int j) {
		isVisited[i][j] = true;
		// 1. 물 확장
		waterMove();

		// 2. 고슴도치 S -> D를 향해 이동
		int cantMove = 0;
		// 도치가 이동 가능한 좌표들을 dochiQ에 저장
		for (int d = 0; d < dr.length; d++) {
			if (i + dr[d] >= 0 && i + dr[d] < map.length && j + dc[d] >= 0 && j + dc[d] < map[i].length) {
				// 도착 지점이면 무지성 탈출
				if (map[i + dr[d]][j + dc[d]] == 'D') {
					minDochiMove = Math.min(minDochiMove, waterCnt);
					isFinish = true;
					return;
				}
				// 빈 공간으로만 이동 가능
				else if (map[i + dr[d]][j + dc[d]] == '.') {
					dochiQ.offer(new pos(i + dr[d], j + dc[d]));
				}
				// 동작 불가인지 체크
				else if (map[i + dr[d]][j + dc[d]] != 'D') {
					cantMove++;
				}
			}
		}
		// GAME OVER
		if (cantMove == dr.length) {
			return;
		}

		if (!dochiQ.isEmpty()) {
			i = dochiQ.peek().i;
			j = dochiQ.peek().j;
			dochiQ.poll();
			bfs(i, j);
			if (isFinish)
				return;
		}
	}

	static void Print() {
		// [Debug] 출력
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		} // =====> end of Debug
	}

}
