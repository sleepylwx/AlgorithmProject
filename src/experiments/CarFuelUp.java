package experiments;

/**
 * 贪心算法 汽车加油问题
 * Created by 36249 on 2017/5/3.
 */

public class CarFuelUp {



    int func(int runMax,int[] distance){


        if(distance.length < 2){

            return -1;
        }
        else if(distance[1] > runMax){

            return -1;
        }
        int res = 0;
        int rest = runMax;


        for(int i = 1; i < distance.length-1; ++i){

            rest -= distance[i];

            if(distance[i+1] > rest){

                rest = runMax;

                if(distance[i+1] > rest){

                    return -1;
                }
                ++res;

            }

        }

        return res;
    }

    public static void main(String[] args) {


        CarFuelUp test = new CarFuelUp();
        int[] distance = new int[]{1,1,1,1,1,1,1,2};
        int runMax = 7;
        System.out.println(test.func(runMax,distance));
    }
}
