package N6000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_인영이카드게임 {
	static int[] GuCard = new int[9];
	static int[] InCard = new int[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T; t++) {
			// 규영이의 카드 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				GuCard[i] = Integer.parseInt(st.nextToken());
			}
			
			
			sb.append("#" + t + " " + "\n");
		}
		System.out.println(sb);
	}
	
	static void CardMatch() {
		
	}

}
