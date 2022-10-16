package N17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17143_낚시왕2 {
	static int R, C, M; //
	static char[][] map;

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
		up(1), down(2), right(3), left(4);

		private final int dir;

		eDir(int dir) {
			this.dir = dir;
		}

		public int getDir() {
			return dir;
		}

	};

	static class Pos {
		int r, c;
	}

	public static void main(String[] args) throws IOException {
		int res = 0; // 정답

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
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

			eDir dir = null;
			switch (d) {
			case 1:
				dir = eDir.up;
				break;
			case 2:
				dir = eDir.down;
				break;
			case 3:
				dir = eDir.right;
				break;
			case 4:
				dir = eDir.left;
				break;
			}

			Shark shark = new Shark(num, r, c, s, dir, z);
			sharkList.add(shark);
			map[r][c] = num;
		}

		// [DEBUG]
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

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
					sharkList.get(sIdx).s = sharkList.get(sIdx).z = 0;
					break;
				}
			}

			// 3. 상어가 이동한다.
			for (int sIdx = 0; sIdx < sharkList.size(); sIdx++) {
				if (sharkList.get(sIdx).s != 0) {
					eDir dir = sharkList.get(sIdx).d;
					switch (dir) {
					case up:
						sharkList.get(sIdx).r--;
						break;
					case down:
						break;
					case right:
						break;
					case left:
						break;
					}
				}
			}
		}

		System.out.println(res);
	}
}
