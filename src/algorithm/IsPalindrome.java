package algorithm;

public class IsPalindrome {

    /*
    *  判断一个正整数是否是回文数
    * */
    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        int help = 1;
        while (n / help >= 10) {
            help *= 10;
        }
        while (n != 0) {
            if (n / help != n % 10) {
                return false;
            }
            n = (n % help) / 10;
            help /= 100;
        }
        return true;
    }

    public static void main(String[] args) {

        for (int i = 1; i < 1000; i++) {
            if (isPalindrome(i)) {
                System.out.println("回文数: "+i);
            }
        }

    }
}
