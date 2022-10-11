package N1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호 짝짓기
/*
* 로직 : 스택
* 열린 괄호가 들어오면 push
* 닫힌 괄호가 들어오면
* 	- top(최근에 들어온 괄호)이랑 짝꿍이면 pop
* 		- 스택이 다 지워질때까지 짝꿍이 맞았으면 res = 1;
*  - 다른 짝꿍이면 break; res = 0;
*/
public class Solution_1218_괄호짝짓기_stack {
	static Stack<Character> stack = new Stack<>();
	static char brackets[][] = { { '0', '(', '[', '{', '<' }, { '0', ')', ']', '}', '>' } };
	// '0'은 오류 체크용

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int res = 1;
			// 문자열 체크
			for (int i = 0; i < num; i++) {
				int pos = 0;
				char chBr = str.charAt(i);

				// 열린 괄호 넣기
				if (chBr == '(' || chBr == '[' || chBr == '{' || chBr == '<')
					stack.push(chBr);
				else {
					// 닫힌 괄호 종류 탐색하여 brackets 배열에서의 위치 찾기
					for (int brIdx = 1; brIdx < brackets[0].length; brIdx++) {
						if (chBr == brackets[1][brIdx]) {
							pos = brIdx;
							break;

						}
					}
					// 마지막에 넣은 열린 괄호(stack의 최상단 : peek)이랑 짝꿍이면 pop
					if (pos != 0) {
						if (stack.peek() == brackets[0][pos])
							stack.pop();
						else {
							res = 0;
							break;
						}
					} else {
						System.out.println("brackets pos 오류 발생");
					}

				}
			} // 문자열 체크 끝
			System.out.println("#" + t + " " + res);
		}
		br.read();
	}
}
