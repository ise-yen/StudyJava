package N2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기 {
	static int[][] map = new int[4][4]; // 각각 0~9가 적혀있음
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static StringBuilder sb;
	static ArrayList<String> numbers = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 1. 격자 입력
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 2. 전부다 돌면서 범위만 안 벗어나면 numbers에 넣기
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					sb = new StringBuilder();
					sb.append(map[i][j]); // 시작점

					// 갈 수 있는 곳
					Move(i, j, 1);
				}
			}

			// 3. numbers 중 서로 다른 애들만 카운트 : 같은 애 있으면 삭제
			for (int i = 0; i < numbers.size(); i++) {
				for (int j = i + 1; j < numbers.size(); j++) {
					if (numbers.get(i).equals(numbers.get(j))) {
						System.out.println(numbers.get(i) + " == " + numbers.get(j));
						numbers.remove(j);
						j--;
						System.out.println(numbers.get(j));
					}
				}
			}
			for (int i = 0; i < numbers.size(); i++) {
				for (int j = i + 1; j < numbers.size(); j++) {
					if (numbers.get(i).equals(numbers.get(j))) {
						System.out.println(numbers.get(i) + " == " + numbers.get(j));
						numbers.remove(j);
						j--;
						System.out.println(numbers.get(j));
					}
				}
			}

			System.out.println("#" + t + " " + numbers.size());
		}

	}

	static void Move(int i, int j, int cnt) {
		if (cnt == 7) {
			numbers.add(sb.toString());
//			System.out.println(sb);
			return;
		}

		for (int d = 0; d < dr.length; d++) {
			if (i + dr[d] >= 0 && i + dr[d] < map.length && j + dc[d] >= 0 && j + dc[d] < map[i].length) {
				sb.append(map[i + dr[d]][j + dc[d]]);
				Move(i, j, cnt + 1);
				sb.deleteCharAt(cnt - 1);
			}
		}
	}

}
