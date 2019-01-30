package algorithm;

public class UglyNumber {

    // 解法一，暴力解
    public static int getUglyNumber(int index) {
        int number = 0;
        int count = 0;
        while (count < index) {
            ++number;
            if (isUgly(number)) {
                count++;
            }
        }
        return number;
    }

    private static boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return (number == 1) ? true : false;
    }

    // 解法二：
    public static int getUglyNumber1(int index) {
        int[] help = new int [index];
        help[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int currentIndex = 1;
        while (currentIndex < index) {
            help[currentIndex] = Math.min( 2* help[i2], Math.min(3 * help[i3], 5 * help[i5]));
            if (help[currentIndex] == 2 * help[i2]) {
                i2++;
            }
            if (help[currentIndex] == 3 * help[i3]) {
                i3++;
            }
            if (help[currentIndex] == 5 * help[i5]) {
                i5++;
            }
            currentIndex++;
        }
        return help[currentIndex - 1];
    }


    public static void main(String[] args) {
        System.out.println(getUglyNumber(20));
        System.out.println(getUglyNumber1(20));
    }
}
