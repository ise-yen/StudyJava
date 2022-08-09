package N1200;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1220_Magnetic {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Data/SWEA_input_1220.txt"));
		Scanner sc = new Scanner(System.in);
		// (열로 따졌을 때)위-아래가 2-1쌍인 것 찾기
		for (int t = 1; t <= 10; t++) {
			int res = 0;
			sc.nextInt(); // 100
			// 입력
			int[][] map = new int[100][100];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 열 단위로 보면서
			// 2-1 쌍인지
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[j][i] == 1) {
						for (int k = j + 1; k < 100; k++) {
							if (map[k][i] == 1) {
								break;
							} else if (map[k][i] == 2) {
								res++;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + res);
		}

		sc.close();
	}

}
