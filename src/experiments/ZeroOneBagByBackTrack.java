package experiments;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 回溯法 解决0-1背包问题
 * Created by 36249 on 2017/5/3.
 */
public class ZeroOneBagByBackTrack {


    private class Pair{


        int index;
        double density;

    }

    private int[] weights;
    private int[] values;
    private Pair[] densities;
    private int res;
    private int limit;
    private int curWeight;
    private int curValue;
    private int length;

    private void func(int index){



        if(index >= length){


            res = res > curValue ? res : curValue;
            return;
        }

        if(curWeight + weights[index] <= limit){


            curValue += values[index];
            curWeight += weights[index];
            func(index+1);

            curValue-= values[index];
            curWeight -= weights[index];

        }

        if(isBound(index+1)){

            func(index+1);
        }



    }

    private boolean isBound(int index){



        double v = curValue;
        int w = curWeight;
        int i = index;
        for(; i < length;++i){

            if(w + weights[i] > limit){

                break;
            }

            v += values[i];
            w += weights[i];
        }


        if(i < length){

            v += densities[i].density * (limit - w)/weights[i];
        }

        if(v > res){

            return true;
        }

        return false;
    }
    public int func(int[] weights,int[]values,int limit){


        int length = weights.length;
        this.weights = new int[length];
        this.values = new int[length];
        this.densities = new Pair[length];
        for(int i = 0; i < length; ++i){

            densities[i] = new Pair();
        }

        res = 0;

        int sumWeight = 0;
        int sumValue = 0;

        for(int i = 0; i < length; ++i){

            densities[i].index = i;
            densities[i].density = (double)values[i]/weights[i];
            sumValue += values[i];
            sumWeight += weights[i];
        }

        if(sumWeight < limit){

            res = sumValue;
            return res;
        }

        Arrays.sort(densities, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {

                return o1.density < o2.density ? 1 : -1;
            }
        });


        for(int i = 0; i < length; ++i){

            this.weights[i] = weights[densities[i].index];
            this.values[i] = values[densities[i].index];

        }

        this.limit = limit;
        this.curValue = 0;
        this.curWeight = 0;
        this.length = length;


        func(0);

        return res;

    }

    public static void main(String[] args) {

        int[] weights = new int[]{2,2,6,5,4};
        int[] values = new int[]{6,3,5,4,6};
        int limit = 10;

        ZeroOneBagByBackTrack third = new ZeroOneBagByBackTrack();
        System.out.println(third.func(weights,values,limit));

    }
}
