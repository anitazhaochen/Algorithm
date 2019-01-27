package algorithm;

import java.util.concurrent.ForkJoinPool;

public class FindTheClosestPalindrome {

    public static String nearestPalindromic(String n) {
        long num = Long.valueOf(n);
        long raw = getRawPalindrome(n);
        long big = raw > num ? raw : getBigPalindrome(raw);
        long small = raw < num ? raw : getSmallPalindrome(raw);
        return String.valueOf(big - num >= num - small ? small : big);
    }

    private static long getRawPalindrome(String n) {
        char[] chs = n.toCharArray();
        int len = chs.length;
        for (int i = 0; i < len / 2; i++) {
            chs[len - 1 - i] = chs[i];
        }
        return Long.valueOf(String.valueOf(chs));
    }

    private static long getSmallPalindrome(long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length ];
        int size = chs.length;
        for (int i = 0; i < size; i++) {
            res[i+1] = chs[i];
        }
        for (int j = (size - 1) / 2; j >= 0 ; j--) {
            if (--res[j] < '0') {
                res[j] = '9';
            } else {
                break;
            }
        }
        if (res[0] == '0') {
            res = new char[size - 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = '9';
            }
            return size == 1 ? 0 : Long.parseLong(String.valueOf(res));
        }
        for (int i = 0; i < size / 2; i++) {
            res[size - 1 - i] = res[i];
        }
        return Long.valueOf(String.valueOf(res));
    }

    private static long getBigPalindrome(long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length + 1];
        res[0] = '0';
        for (int i = 0; i < chs.length; i++) {
            res[i+1] = chs[i];
        }
        int size = chs.length;
        for (int j = (size - 1) / 2 + 1; j >= 0 ; j--) {
            if (++res[j] > '9') {
                res[j] = '0';
            } else {
                break;
            }
        }
        int offset = res[0] == '1' ? 1 : 0;
        size = res.length;
        for (int i = size - 1; i >= (size + offset) / 2 ; i--) {
            res[i] = res[size - i - offset];
        }
        return Long.valueOf(String.valueOf(res));
    }

    public static void main(String[] args) {
        System.out.println(nearestPalindromic("199"));
        System.out.println(nearestPalindromic("12381"));
    }

}
