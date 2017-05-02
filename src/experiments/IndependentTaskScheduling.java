package experiments;

/**
 * 算法实现3-1
 * Created by 36249 on 2017/4/26.
 */
public class IndependentTaskScheduling {


    //独立任务最优调度


    int func(int[] a,int [] b,int n){

        int sumA = 0;
        for(int i = 0; i < a.length ;++i){

            sumA += a[i];
        }

        int[] map = new int[sumA+1];

        for(int i = 0 ; i < n ;++i){


            for(int j = sumA ; j >= 0; --j){


                if(j >= a[i]){

                    map[j] = Math.min(map[j-a[i]],map[j]+b[i]);
                }
                else{

                    map[j] = map[j] + b[i];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0 ;i <= sumA; ++i){

            result = Math.min(result,Math.max(i,map[i]));
        }

        return result;

    }

    public static void main(String[] args) {

        IndependentTaskScheduling test = new IndependentTaskScheduling();

        int[] a = new int[]{2,5,7,10,5,2};
        int[] b = new int[]{3,8,4,11,3,4};

        System.out.println(test.func(a,b,6));
    }
}
