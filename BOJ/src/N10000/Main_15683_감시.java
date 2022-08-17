package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683_감시 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] office = new int[N][M];
		int[][] tmpMap = new int[N][M];
		for (int i = 0; i < office.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < office[i].length; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				tmpMap[i][j] = office[i][j];
			}
		}
		///// <===== 입력 끝
		

		for (int i = 0; i < office.length; i++) {
			for (int j = 0; j < office[i].length; j++) {
				switch(tmpMap[i][j]){
				case 1: // 한쪽
					
					// 좌우
					for(int k = 0; k < office[i].length; k++) {
						
					}
					
					//상하
					break;
				case 2: // 180도 각으로 2방향
					break;
				case 3:
					break; // 90도 각으로 2방향
				case 4: // 세 방향
					break;
				case 5: // 전방향
					break;
				case 6: // 벽
					break;
					
					
				}
				if(tmpMap[i][j] == 1) {
					
				}
			}
		}

	}

}
