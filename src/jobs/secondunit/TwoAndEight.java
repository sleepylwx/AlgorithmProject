package jobs.secondunit;

/**
 * Created by 36249 on 2017/4/21.
 */
public class TwoAndEight {

    /**
     *
     * @param arr
     * @param k   0 < k < n - 1
     */
    public void swapTwoPart(int[] arr,int k){

        int length = arr.length;
        if(k <= 0 || k >= length){

            return ;
        }


        int leftLength = k;
        int rightLength = length - k;
        int start = 0;
        int cur = start + leftLength;

        while(start < cur){

            if(leftLength < rightLength){

                int count = cur;
                for(int j = start; j < start + leftLength; ++j){

                    arr[j] = arr[j]^arr[count];
                    arr[count] = arr[j]^arr[count];
                    arr[j] = arr[j]^arr[count];
                    ++count;
                }

                start = start + leftLength;
                cur = start + leftLength;
                rightLength = rightLength - leftLength;

            }
            else{


                int count = cur;
                for(int j = start; j < start + rightLength; ++j){

                    arr[j] = arr[j]^arr[count];
                    arr[count] = arr[j]^arr[count];
                    arr[j] = arr[j]^arr[count];
                    ++count;
                }

                start = start + rightLength;
                leftLength = leftLength - rightLength;
                cur = start + leftLength;

            }

        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

        TwoAndEight secondUnit = new TwoAndEight();
        secondUnit.swapTwoPart(arr,9);

        for(int i = 0; i < arr.length; ++i){

            System.out.print(arr[i] + " ");
        }
    }

}
