
import java.util.Scanner;
public class Solution_2001_황예은 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
		{
            int res = 0;
            int N, M;
			// 퍼즐 정보 입력
            N=sc.nextInt();
			M=sc.nextInt();
            int[][] arr = new int[15][15];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            // 잡은 파리 수 중 최대값 구하기
            int max = 0;
            int sum = 0;

            for(int l = 0; l < N-M+1; l++){
                for(int k = 0; k < N-M+1; k++){
                    for(int i = 0; i < M; i++){
                        for(int j = 0; j < M; j++){
                            sum += arr[i+l][j+k];
                        }
                    }
                    if(sum > max) max = sum;
                    sum = 0;
                }
            }
            res = max;
            System.out.println("#" + test_case + " " + res);
        }
	}
}