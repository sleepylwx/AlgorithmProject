package experiments;

import java.util.Arrays;

/**
 * 二分查找 迭代实现和递归实现
 * Created by 36249 on 2017/3/29.
 */
public class BinarySearch {

    public <T extends Comparable>int binarySearch(T[] arr,T target){


        int start = 0;
        int end = arr.length;
        int result = -1;
        while(start < end){

            if(start >= end){

                return -1;
            }
            int mid = (start + end)/2;
            int state = arr[mid].compareTo(target);

            if(state == 0){


                result = mid;
                break;
            }
            else if(state > 0){


                end = mid;

            }
            else{


                start = mid + 1;
            }

        }

        return result;
    }

    public  int binarySearch(int[] arr,int target,int start ,int end){

        if(start > end){

            return -1;
        }
        int mid = start + (end - start)/2;

        if(arr[mid] == target){

            return mid;
        }
        else if(arr[mid] > target){

            return binarySearch(arr,target,start,mid - 1);
        }
        else{

            return binarySearch(arr,target,mid + 1,end);
        }

    }

    public static void main(String[] args) {

        BinarySearch first = new BinarySearch();
        int[] arr = new int[] {91,23,557,216,72,-20};
        Arrays.sort(arr);
        System.out.println(first.binarySearch(arr,216,0,5));
    }
}
