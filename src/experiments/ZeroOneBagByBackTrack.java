package experiments;

/**
 * 回溯法 解决0-1背包问题
 * Created by 36249 on 2017/5/3.
 */
public class ZeroOneBagByBackTrack {

    private int res;

    private void func(int[] weights,int[] values,int limit,int cur,int sumWeight,int sumValue){


        if(cur >= weights.length){

            res = res > sumValue ? res : sumValue;
            return;
        }

        if(sumWeight + weights[cur] <= limit){

            func(weights,values,limit,cur+1,sumWeight+weights[cur],sumValue+values[cur]);
        }

        func(weights,values,limit,cur+1,sumWeight,sumValue);


    }

    public int func(int[] weight,int[]values,int limit){


        func(weight,values,limit,0,0,0);
        return res;
    }

    public static void main(String[] args) {

        int[] weights = new int[]{2,2,6,5,4};
        int[] values = new int[]{6,3,5,4,6};
        int[][] map = new int[5][];
        int limit = 10;
        for(int i = 0; i < 5; ++i){

            map[i] = new int[limit+1];
        }

        ZeroOneBagByBackTrack third = new ZeroOneBagByBackTrack();
        System.out.println(third.func(weights,values,limit));


    }
}
