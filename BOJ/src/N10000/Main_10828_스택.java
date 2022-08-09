package N10000;
// 실4) 스택
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				stk.push(num);
				break;
			case "pop":
				if (stk.empty())
					System.out.println(-1);
				else {
					System.out.println(stk.peek());
					stk.pop();
				}
				break;
			case "size":
				System.out.println(stk.size());
				break;
			case "empty":
				if (stk.empty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if (stk.empty())
					System.out.println(-1);
				else {
					System.out.println(stk.peek());
				}
				break;
			default:
				break;
			}
		}
		br.close();
	}
}
