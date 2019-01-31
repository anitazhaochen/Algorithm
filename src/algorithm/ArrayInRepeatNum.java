package algorithm;

import java.util.ArrayList;

public class ArrayInRepeatNum {

    public static boolean solution(int[] arr, int[] result) {

        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    result[0] = arr[i];
                    return true;
                }
                Integer tmp = arr[i];
                arr[i] =  arr[arr[i]];
                arr[arr[i]] = tmp;
                System.out.println(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        int[] result = new int[1];
        //System.out.println(solution(arr,result));

        System.out.println(duplicate(arr, 3, result));
        System.out.println(result[0]);
    }


    public static boolean duplicate(int array[],int length,int [] duplication) {
        if (array == null) return false;

        // 判断数组是否合法（每个数都在0~n-1之间）
        for (int i = 0; i < length; i++) {
            if (array[i] < 0 || array[i] > length - 1) {
                return false;
            }
        }

        // key step
        for (int i = 0; i < length; i++) {
            while (i != array[i]) {
                if (array[i] == array[array[i]]) {
                    duplication[0] = array[i];
                    return true;
                }

                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }

        return false;
    }
}
