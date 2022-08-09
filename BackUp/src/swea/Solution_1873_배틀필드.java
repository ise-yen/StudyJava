package swea;

import java.util.Scanner;

//상호의 배틀필드
public class Solution_1873_배틀필드 {
	static int T;
	static char[][] map;
	// 방향 전환용 델타 : 위, 아래, 왼쪽, 오른
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int H = 0, W = 0; // H, W (2 ≤ H, W ≤ 20) 맵 크기, 사용자의 입력 개수
			int tr = 0, tc = 0; // 전차 위치
			int nr = 0, nc = 0; // 이동 방향의 다음 위치
			char td = 0; // 전차 방향
			int d = 0; // 방향 전환용
			// 0. 변수 입력
			// 0-1. 맵 크기
			H = sc.nextInt();
			W = sc.nextInt();
			sc.nextLine();
			// 0-2. map 입력. H개의 각각의 줄 : 길이가 W인 문자열 입력
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					// 1. 전차 찾기
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						// 현재 위치, 현재 방향
						tr = i;
						tc = j;
						td = map[tr][tc];
					}
				}
			}
			// 0-3. 사용자의 문자 동작 입력
			int N = sc.nextInt();
			sc.nextLine();
			String cmd = sc.nextLine(); // 명령문자열

			// 2. 입력 받은 문자(ch)
			for (int ch = 0; ch < N; ch++) {
				// 2-1. 공격기일 때
				if (cmd.charAt(ch) == 'S') {
					switch (td) {
					case '^':
						if (tr > 0) {
							for (int cannon = tr - 1; cannon >= 0; cannon--) {
								if (map[cannon][tc] == '*') {
									map[cannon][tc] = '.';
									break;
								}
								else if(map[cannon][tc] == '#')
									break;
							}
							break;
						}
					case 'v':
						if (tr < H - 1) {
							for (int cannon = tr + 1; cannon < H; cannon++) {
								if (map[cannon][tc] == '*') {
									map[cannon][tc] = '.';
									break;
								}
								else if(map[cannon][tc] == '#')
									break;
							}
							break;
						}
					case '<':
						if (tc > 0) {
							for (int cannon = tc - 1; cannon >= 0; cannon--) {
								if (map[tr][cannon] == '*') {
									map[tr][cannon] = '.';
									break;
								}
								else if(map[tr][cannon] == '#')
									break;
							}
							break;
						}
					case '>':
						if (tc < W - 1) {
							for (int cannon = tc + 1; cannon < W; cannon++) {
								if (map[tr][cannon] == '*') {
									map[tr][cannon] = '.';
									break;
								}
								else if(map[tr][cannon] == '#')
									break;
							}
							break;
						}
					}
				}
				// 2-2. 이동기일 때
				else {
					// (이동 전)무조건 회전
					switch (cmd.charAt(ch)) {
					case 'U':
						map[tr][tc] = td = '^';
						d = 0;
						break;
					case 'D':
						map[tr][tc] = td = 'v';
						d = 1;
						break;
					case 'L':
						map[tr][tc] = td = '<';
						d = 2;
						break;
					case 'R':
						map[tr][tc] = td = '>';
						d = 3;
						break;
					}
					// (이동 전) 이동할 위치 상태 체크
					nr = tr + dr[d];
					nc = tc + dc[d];
					// 이동할 위치가 맵 범위 이내라면
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						// 평지면 이동 O
						if (map[nr][nc] == '.') {
							map[tr][tc] = '.'; // 이동 전 위치 평지화
							// 다음 위치로 전차 이동
							tr = nr;
							tc = nc;
							map[tr][tc] = td;
						} // 평지 아니면 이동 X
					}
				}
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}