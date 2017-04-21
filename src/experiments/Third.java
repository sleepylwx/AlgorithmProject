package experiments;

/**
 * Created by 36249 on 2017/4/19.
 */
public class Third {


    public void zeroAndOneBag(int[] weights,int[] values,int[][] map,int limit){

        if(weights == null || values == null || map == null){

            return;
        }

        int thingsNum = weights.length;

        for(int i = 0; i < limit+1;++i){

            if(weights[thingsNum-1] > i){

                map[thingsNum-1][i] = 0;
            }
            else{

                map[thingsNum-1][i] = values[thingsNum-1];
            }
        }

        for(int i = thingsNum-2; i > -1; --i){


            for(int j = 0; j < limit+1;++j){

                if(weights[i] > j){


                    map[i][j] = map[i+1][j];
                }
                else{

                    map[i][j] = Math.max(map[i+1][j],map[i+1][j-weights[i]]+values[i]);
                }
            }

        }



    }

    public void trace(int[] result,int[][] map,int[] weights){

        int length = map[0].length;

        int max = map[0].length-1;

        for(int i = 0; i < map.length - 2; ++i){

            if(map[i][max] != map[i+1][max]){

                result[i] = 1;
                max = max - weights[i];
            }
            else{

                result[i] = 0;
            }

        }

        result[map.length-1] = map[map.length-1][max] != 0? 1: 0;


    }
    public static void main(String[] args) {


        int[] weights = new int[]{2,2,6,5,4};
        int[] values = new int[]{6,3,5,4,6};
        int[][] map = new int[5][];
        int limit = 10;
        for(int i = 0; i < 5; ++i){

            map[i] = new int[limit+1];
        }

        Third third = new Third();
        third.zeroAndOneBag(weights,values,map,limit);


        for(int i = 0; i < 5; ++i){

            for(int j = 1; j < limit+1; ++j){

                System.out.print(map[i][j] + " ");
            }

            System.out.println();
        }

        int[] result = new int[5];
        third.trace(result,map,weights);

        for(int i = 0; i < 5; ++i){

            System.out.print(result[i] + " ");
        }

    }

}


class Another{




}
