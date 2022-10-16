package N17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {

	static class Shark {
		int r, c, s, z; // 상어위치, 속력, 이동 방향, 크기
		eDir d;
		char num;

		public Shark(char num, int r, int c, int s, eDir d, int z) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static enum eDir {
		empty, up, down, right, left;
	}

	public static void main(String[] args) throws IOException {
		int res = 0; // 정답

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[R + 1][C + 1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = '0';
			}
		}

		ArrayList<Shark> sharkList = new ArrayList<Shark>();

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

//		// [DEBUG] map
//		for (int i = 1; i < map.length; i++) {
//			for (int j = 1; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

//		// [DEBUG] sharklist 확인
//		for (int i = 0; i < sharkList.size(); i++) {
//			System.out.println(sharkList.get(i).d + ", ");
//		}

		int manPos = 0;

		for (int time = 1; time < map.length; time++) {
			// 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
			manPos = time;

			// 2-1. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
			for (int j = 1; j < map[manPos].length; j++) {
				if (map[manPos][j] != '0') {
					int sIdx = map[manPos][j] - 'A';
					res += sharkList.get(sIdx).z;

					// 2-2. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
					map[manPos][j] = '0';
					// (remove로 없애면 번호가 밀리고 시간초과 나므로 유령상태로 만들기)
					sharkList.get(sIdx).s = sharkList.get(sIdx).z = -1; // 스피드랑 크기를 -1로 만듦
					break;
				}
			} // ======= 상어 낚음

			// 3. 상어가 이동한다.
			for (int sIdx = 0; sIdx < sharkList.size(); sIdx++) {
				if (sharkList.get(sIdx).s != -1) {
					// 3-1. 방향으로 이동하다가 벽을 만나면 방향 전환하고 계속 이동
					for (int s = 1; s <= sharkList.get(sIdx).s; s++) {
						eDir dir = sharkList.get(sIdx).d;
						switch (dir) {
						case up:
							sharkList.get(sIdx).r--;
							if (sharkList.get(sIdx).r == 1)
								sharkList.get(sIdx).d = eDir.down;
							break;
						case down:
							sharkList.get(sIdx).r++;
							if (sharkList.get(sIdx).r == map.length - 1)
								sharkList.get(sIdx).d = eDir.up;
							break;
						case right:
							sharkList.get(sIdx).c++;
							if (sharkList.get(sIdx).r == map[0].length - 1)
								sharkList.get(sIdx).d = eDir.left;
							break;
						case left:
							sharkList.get(sIdx).c--;
							if (sharkList.get(sIdx).c == 1)
								sharkList.get(sIdx).d = eDir.right;
							break;
						}
					}
				}
			} // ========== 이동 종료

			// 4. 도착했을 때 상어가 있으면 가장 큰 놈만 살아남음
			for (int si = 0; si < sharkList.size(); si++) {
				for (int sj = 0; sj < sharkList.size(); sj++) {
					if (si != sj) {
						if (sharkList.get(si).z != -1 && sharkList.get(sj).z != -1) {
							if (sharkList.get(si).r == sharkList.get(sj).r
									&& sharkList.get(si).c == sharkList.get(sj).c) {
								if (sharkList.get(si).z >= sharkList.get(sj).z) {
									// (remove로 없애면 번호가 밀리고 시간초과 나므로 유령상태로 만들기)
									sharkList.get(sj).s = sharkList.get(sj).z = -1; // 스피드랑 크기를 -1로 만듦
								} else {
									sharkList.get(si).s = sharkList.get(si).z = -1; // 스피드랑 크기를 -1로 만듦
								}
							}
						}
					}
				}
			} // ========== 데스매치 종료

			// [DEBUG] 맵 재세팅
			map = new char[R + 1][C + 1];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (i == 0)
						map[i][j] = '0';
					else if (j == 0) {
						map[i][j] = '0';
					} else {
						for (int si = 0; si < sharkList.size(); si++) {
							if(sharkList.get(si).z != -1)
								map[sharkList.get(si).r][sharkList.get(si).c] = sharkList.get(si).num;
							else
								map[i][j] = '0';
						}
					}
				}
			} // ========= 맵 세팅 종료

			// [DEBUG] map
			for (int i = 1; i < map.length; i++) {
				for (int j = 1; j < map[i].length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		} // ============== 시간 종료

		System.out.println(res);
	}
}
