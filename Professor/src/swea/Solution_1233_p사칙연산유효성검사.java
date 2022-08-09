package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* << 연산자 노드일 때  >>
 * <불가능한 경우>
 * 1. 연산자 노드에 자식이 0개
 * 2. 연산자 노드의 자식이 1개
 * => 연산 불가!

 * <가능성 있는 경우>
 * 1. 연산자 노드의 자식이 숫자 노드랑 연산자 노드일때
 * 2. 연산자 노드의 자식이 둘다 연산자 노드일 때
 * 3. 연산자 노드의 자식이 둘다 숫자 노드일 때
 * => 넘겨 주기
 * 
 * << 숫자 노드일 때  >>
 * <불가능한 경우>
 * 1. 자식이 둘 중 하나라도 숫자 노드일 때
 * 2. 자식이 둘 중 하나라도 연산자 노드일 때
 * => 연산 불가!
 * 
 * <가능성 있는 경우>
 * 1. 자식이 없는 경우
 * => 넘겨 주기
 */

public class Solution_1233_p사칙연산유효성검사 {

	static int N;
	static String[] tree;

	public static void main(String[] args) throws IOException {
		// 해당 노드에 자식 노드가 있으면, 리프 노드가 아니므로 인덱스는 전체 배열 크기의 N이 절반보다 작아야한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());

			tree = new String[N + 1];
			int res = 1;
			for (int i = 0; i < N; i++) {
				// 정점 번호와 값만 받음
				st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();
			}

			// 유효성 판단의 기준 세팅
			int nodeIdx = N / 2;
			for(int i = 1; i < N+1; i++) {
				if(tree[i].charAt(0)>= '0' && tree[i].charAt(0)<='9') {
					// 정점의 번호가 N/2보다 작거나 같은지?
					if(i <= nodeIdx) {
						 // 리프노드x, 숫자 올 ㅅ ㅜ없음
						res = 0;
						break;
					}
				}
				// 연산자일 때
				else {
					if(i > nodeIdx) {
						// 정점의 번호가 N/2보다 큰지 확인. 연산자는 올 수 없음
						res = 0;
						break;
					}
				}
			}
			
			
		}
	}

}
