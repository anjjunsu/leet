package journey_log;

import java.util.Arrays;

class reverseString344 {

    // Two pointer version
    public static void reverseString_twoPointer(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void reverseString_recursive(char[] s) {
        int left = 0;
        int right = s.length - 1;

        recursive(left, right, s);
    }

    private static void recursive(int left, int right, char[] s) {
        if (left >= right) {
            return;
        }
        
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;

        recursive(left + 1, right -1, s);
    }

    

    public static void main(String[] args) {
        char[] tp = new char[] {'h','e','l','l','o'};
        System.out.println("Input Arrary: " + Arrays.toString(tp));
        reverseString_twoPointer(tp);
        System.out.printf("Reversed array using two pointer (iteratively): ");
        System.out.println(Arrays.toString(tp));

        char[] rc = new char[] {'h','e','l','l','o'};
        reverseString_recursive(rc);
        System.out.printf("Reversed array using two pointer (recursively): ");
        System.out.println(Arrays.toString(rc));
    }
}