package N12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12869_뮤탈리스크 {
	static int[] scvHP;

	public static void main(String[] args) throws IOException {
		int mutalCnt = 1;
		int res = 0; // 정답 : 모든 SCV를 파괴하기 위해 공격해야 하는 횟수의 최솟값

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int scvCnt = N;
		scvHP = new int[N]; // scv 체력 ( 0 < hp <= 60)

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scvHP[i] = Integer.parseInt(st.nextToken());
		}
		// =============== 입력 종료

	}

	static void attack(int idx, int cnt) {
		// 한 번에 3개의 scv 공격 가능
		// 1 공격 : -9
		// 2 공격 : -3
		// 3 공격 : -1
	}
}
