package N1200;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	static int pn; // 원본 암호문의 길이
//	static int[] pws = new int[20]; // 원본 암호문
	static String[] pws = new String[20]; // 원본 암호문
	static int cn; // 명령어의 개수
//	static int[][] cmds; // 명령어
	static String[][] cmds; // 명령어

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		for (int t = 0; t < T; t++) {
			////////// 입력
			// 암호문 길이 입력
			st = new StringTokenizer(br.readLine());
			pn = Integer.parseInt(st.nextToken());
			// 암호문 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < pn; i++)
				pws[i] = st.nextToken();

			// 명령어 개수 입력
			st = new StringTokenizer(br.readLine());
			cn = Integer.parseInt(st.nextToken());
			cmds = new String[cn][];
			// 명령어 입력
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken(); // I
			for (int i = 0; i < cn; i++) {
				int index = Integer.parseInt(st.nextToken());
				int cmdL = Integer.parseInt(st.nextToken());
				for(int j = 1; j < cmdL; j++) {
					if(j > 10) break;
				}
				while(st.nextToken() != "I") {
				}
			}

			////////// 입력 끝


			
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(pws[i] + " ");
			}
			System.out.println();

		}
	}

}