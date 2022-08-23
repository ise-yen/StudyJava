package N7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
/*
 * 1 : 익음
 * 0 : 안 익음
 * -1 : 비었음
 */
public class Main_7576_토마토 {
	static int M; // 행
	static int N; // 열
	static int[][] map; // 밭
	static int minDays; // 출력할 최소일자

	// 익은 토마토 좌표 저장용 Queue
	static Queue<Integer> posI = new LinkedList<Integer>();
	static Queue<Integer> posJ = new LinkedList<Integer>();

	// deltas 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. 입력
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int tomato = 0;
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 안 익은 토마토 개수 체크
				if (map[i][j] == 0)
					tomato++;
				// Queue : 익은 토마토 좌표 넣기
				else if (map[i][j] == 1) {
					posI.offer(i);
					posJ.offer(j);
				}
			}
		} // =====> 입력 끝


		int level = 1; // 익은 토마토 Tree의 level
		int size = posI.size(); // 현재까지 익은 토마토 개수
		boolean isSuccess = true; // 잘 익혔는지 체크하는 용도

		
		// 애초에 다 익었으면 날짜 계산x
		if (tomato == 0) {
			minDays = 0;
		}
		// 안 익은 토마토가 있으면 날짜 계산o
		else {
			// 2. 탐색용으로 쓸 익은 토마토(중심)이 있으면 반복
			while (!posI.isEmpty()) {
				
				// 2-1. 현재까지 익은 토마토 개수만큼 반복문 돌린 뒤에 level 올리기
				if (size > 0) { 
					// 2-2. 토마토 익히기
					bfs(posI.peek(), posJ.peek(), level, tomato);

					// 2-3. 중심이 됐던 익은 토마토 수확
					posI.poll();
					posJ.poll();
					size--;
					
					// 2-4. 초기 세팅한 탐색용 익은 토마토(중심)을 다 수확했으면 
					if (size == 0) {
						// 업데이트된 탐색용 익은 토마토(중심)으로 재탐색
						if (!posI.isEmpty())
							size = posI.size();
						// 2-5. 더 없다 == 익힐 수 있는 애들은 다 익혔다.
						else {
							// 지금까지의 날짜 계산
							minDays = level - 1; // level이 1부터 시작했으므로 -1해줌
							break;
						}
						
						level++;
					}
				}
			}

			// 3. 밭의 토마토가 다 익었는지, 안 익은 토마토가 있는지 체크
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 0) {
						isSuccess = false;
					}
				}
			}

		} // =====> end of if(익힐 토마토가 있다면)
		
//		// [Debug] 잘 익었는지 출력
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 4. 안익은 토마토가 있으면 -1
		if (isSuccess)
			System.out.println(minDays);
		else
			System.out.println(-1);

	}
	
	
	// 2-2. 탐색용 익은 토마토(중심)로 인접 토마토 익히고 좌표 찾기
	private static void bfs(int i, int j, int level, int tomato) {
		if (tomato == 0) {
			minDays = level - 1;
			return;
		}

		for (int d = 0; d < dr.length; d++) {
			// 범위 이내일 때
			if (i + dr[d] >= 0 && i + dr[d] < map.length && j + dc[d] >= 0 && j + dc[d] < map[i].length) {
				// 익힐 인접 토마토 찾음
				if (map[i + dr[d]][j + dc[d]] == 0) {
					tomato--; // 안 익은 토마토 -> 익은 토마토 됨

					map[i + dr[d]][j + dc[d]] = level; // 익음

					// 익힌 토마토 위치를 넣음(다음에 인접 토마토를 찾기 위해)
					posI.offer(i + dr[d]);
					posJ.offer(j + dc[d]);
				}
			}
		}
	}

}
