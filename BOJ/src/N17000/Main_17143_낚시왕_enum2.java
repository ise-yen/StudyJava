package N17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17143_낚시왕_enum2 {

	static class Shark {
		int r, c, s, z; // 상어위치, 속력, 크기
		eDir dir; // 이동 방향
		char num; // 상어 번호(지만 알파벳)

		public Shark(char num, int r, int c, int s, eDir dir, int z) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.s = s;
			this.dir = dir;
			this.z = z;
		}
	}

	static enum eDir {
		empty, up, down, right, left;
	}

	static char[][] map;
	static Shark[][] mapShark;
	static ArrayList<Shark> sharkList;

	public static void main(String[] args) throws IOException {
		int res = 0; // 정답

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = '0';
			}
		}

		sharkList = new ArrayList<Shark>();

		// 상어들 정보 넣기
		for (int m = 0; m < M; m++) {
			char num = (char) (m + 'A');

			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(num, r, c, s, eDir.values()[d], z);
			sharkList.add(shark);
			map[r][c] = num;
		}
		// 3. 상어가 이동한다.
		for (int sIdx = 0; sIdx < sharkList.size(); sIdx++) {
			if (sharkList.get(sIdx).s != -1) {
				for (int s = 1; s <= sharkList.get(sIdx).s; s++) {
					eDir dir = sharkList.get(sIdx).dir;
					switch (dir) {
					case up:
						// 구현
						break;
					case down:
						// 구현
						break;
					case right:
						// 구현
						break;
					case left:
						// 구현
						break;
					}
				}
			}
		} // ========== 이동 종료

		debugMap();

		debugSharkList();
		// 4. 도착했을 때 상어가 있으면 가장 큰 놈만 살아남음
//			for (int si = 0; si < sharkList.size(); si++) {
//				for (int sj = 0; sj < sharkList.size(); sj++) {
//					if (si != sj) {
//						if (sharkList.get(si).z != -1 && sharkList.get(sj).z != -1) {
//							if (sharkList.get(si).r == sharkList.get(sj).r
//									&& sharkList.get(si).c == sharkList.get(sj).c) {
//								if (sharkList.get(si).z >= sharkList.get(sj).z) {
//									// (remove로 없애면 번호가 밀리고 시간초과 나므로 유령상태로 만들기)
//									sharkList.get(sj).s = sharkList.get(sj).z = -1; // 스피드랑 크기를 -1로 만듦
//								} else {
//									sharkList.get(si).s = sharkList.get(si).z = -1; // 스피드랑 크기를 -1로 만듦
//								}
//							}
//						}
//					}
//				}
//			} // ========== 데스매치 종료

//			// [DEBUG] 맵 재세팅
//			map = new char[R + 1][C + 1];
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map[i].length; j++) {
//					if (i == 0)
//						map[i][j] = '0';
//					else if (j == 0) {
//						map[i][j] = '0';
//					} else {
//						for (int si = 0; si < sharkList.size(); si++) {
//							if (sharkList.get(si).z != -1)
//								map[sharkList.get(si).r][sharkList.get(si).c] = sharkList.get(si).num;
//							else
//								map[i][j] = '0';
//						}
//					}
//				}
//			} // ========= 맵 세팅 종료

	} // ============== 시간 종료

	System.out.println(res);

	}

	static void debugMap() {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void debugSharkList() {
		for (int i = 0; i < sharkList.size(); i++) {
			System.out.println(sharkList.get(i).d + ", ");
		}
	}
}
