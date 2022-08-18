package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		// (문자열형)숫자, -, +를 순서대로 받는 리스트
		ArrayList<String> expression = new ArrayList<>();
		StringBuffer sb = new StringBuffer(); // 문자형 숫자를 문자열형 숫자로 만들기 위한 버퍼

		// 0. 리스트에 식 분해해서 넣기
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != '-' && c != '+') {
				sb.append(c);
			} else {
				// 기존꺼 expression에 넣고 초기화
				expression.add(sb.toString());
				sb.delete(0, sb.length());
				sb = new StringBuffer();
				expression.add(Character.toString(c));
			}
		}

		// [DEBUG] 리스트에 잘 들어왔는지 체크
		for (int i = 0; i < expression.size(); i++) {
			System.out.println(expression.get(i));
		}

		/*
		 * 1. 리스트에 중 맨앞, -, +, 맨 끝 중에 ( ) 넣기 1-1. index=0에는 '(' 1-2. '(' 가 들어갔다면 ')' 넣기
		 */
		int resMin = Integer.MAX_VALUE;
		for (int i = 0; i < expression.size(); i++) {
			boolean isParenthesesOpen = false;
			if (i == 0 || expression.get(i - 1) == "+" || expression.get(i - 1) == "-") {
				expression.add(i, "(");
				isParenthesesOpen = true;
			}
			for (int j = 1; j < expression.size(); j++) {
				if (j == expression.size() - 1 || expression.get(j) == "+" || expression.get(j) == "-") {
					expression.add(j, ")");
				}
				// 2. 괄호를 넣은 식을 계산하기
				int sum = 0; // 식의 계산 결과
				for (int k = 0; k < expression.size(); k++) {
					
					// 식의 k번째가 숫자형 문자열이면 숫자로 만들기
					if (expression.get(i) != "+" && expression.get(i) != "-") {
						int sNum = 0; // 단위별로 숫자로 저장할 변수
						String sTmp = expression.get(i);
						for (int s = sTmp.length() - 1; s >= 0; s--) {
							sNum += (sTmp.charAt(s) * (int) Math.pow(10, 0));
						}
					}
				}

				resMin = Math.min(resMin, sum);
			}

		}

		System.out.println(resMin);
	}

}
