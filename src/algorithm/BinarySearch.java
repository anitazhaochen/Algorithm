package algorithm;


import org.junit.Test;

public class BinarySearch {

    public static void main(String[] args) {
        int[] whitelist = {1,2,3,4,5,6,7,8,9};

        int result = rank(9, whitelist);
        System.out.println(result);


        // 输出依旧是 这个数，发生了溢出
        System.out.println(Math.abs(-2147483648));

        // 算法第一章习题
        System.out.println((0+15)/2); //7
        System.out.println((2.0e-6)*100000000.1); // 200.0000002
        System.out.println((true && false || true && true)); // true
        System.out.println((1+2.236)/2); // 1.618
        System.out.println((1+2+3+4.0)); // 10.0
        System.out.println((4.1>=4)); // true
        System.out.println((1+2+"3")); //33
        System.out.println('b'); // b
        System.out.println('b'+'c'); // 197
        System.out.println((char)('a'+4)); // e

    }

    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid-1;
            } else if (key > a[mid]) {
                low = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

