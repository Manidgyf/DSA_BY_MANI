package Arrays_2;

import java.util.*;
public class Missing_and_Repeating {

    public static void main(String[] args) {
        int[] arr =  new int[]{4, 3, 6, 2, 1, 1};
        System.out.println(findTwoElement(arr));
    }
    public static    ArrayList<Integer> findTwoElement(int arr[]) {
            // code here
            int xor = 0;
            for (int i = 0; i < arr.length; i++) {
                xor = xor ^ arr[i];
                xor = xor ^ (i + 1);
            }
            int bitpos = 0;
            while ((xor & (1 << (bitpos))) == 0) {
                bitpos++;
            }

            int ones = 0;
            int zeroes = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & (1 << (bitpos))) != 0) {
                    ones = ones ^ arr[i];
                } else {
                    zeroes = zeroes ^ arr[i];
                }
                if (((i + 1) & (1 << (bitpos))) != 0) {
                    ones = ones ^ (i + 1);
                } else {
                    zeroes = zeroes ^ (i + 1);
                }
            }
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == ones) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                return new ArrayList<>(Arrays.asList(zeroes, ones));
            } else {
                return new ArrayList<>(Arrays.asList(ones, zeroes));
            }
        }

}
