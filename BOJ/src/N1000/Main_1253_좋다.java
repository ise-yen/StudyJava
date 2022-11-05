package N1000;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.*;

class Main_1253_좋다 {

    static int N;
    static HashMap<Integer, Integer> maps = new HashMap<>();
    static int[] goods;
    static int answer = 0;
    /**
     * 2000C2*2000 = 2000*1999*1000
     **/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        goods = new int[N];

        for(int i=0; i<N; i++){
            goods[i] = Integer.parseInt(st.nextToken());

            if(maps.containsKey(goods[i])){
                maps.put(goods[i],maps.get(goods[i])+1);
            }
            else{
                maps.put(goods[i], 1);
            }
        }

        int sum;

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){

                sum = goods[i] + goods[j];
                int add;

                if(maps.containsKey(sum)){
                    add = maps.get(sum);

                    //둘다 0일때
                    if(goods[i] == 0 && goods[j] == 0){
                        if(add >= 3){
                            answer = answer + add;
                            maps.remove(sum);
                        }
                    }
                    //1개만 0일때 = 2이상
                    else if(goods[i] == 0 || goods[j] == 0){
                        if(add >= 2){
                            answer = answer + add;
                            maps.remove(sum);
                        }
                    }
                    else{
                        answer = answer + add;
                        maps.remove(sum);
                    }
                }

            }
        }
        System.out.println(answer);
    }
}