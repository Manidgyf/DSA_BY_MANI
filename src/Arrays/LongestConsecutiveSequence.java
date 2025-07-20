package Arrays;
import java.util.*;
public class LongestConsecutiveSequence {
        public static void main(String args[])
        {
            int arr[] = new int[]{100,4,200,1,3,2};
            System.out.println(longestConsecutive(arr));
        }
        public static int longestConsecutive(int[] arr) {
            Arrays.sort(arr);
            int cnt=0;
            int longest=0;
            Integer last_smaller= Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]-1 == last_smaller)
                {
                    cnt++;
                }
                else if(last_smaller != arr[i])
                {
                    cnt=1;
                }
                last_smaller=arr[i];
                longest = Math.max(cnt,longest);

            }
            return longest;
        }
    }

