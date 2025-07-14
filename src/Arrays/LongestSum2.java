// Online Java Compiler only for positive but optimal
// Use this editor to write, compile and run your Java code online
import java.util.HashMap;
class LongestSum2 {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 5, 2, 7, 1, 9};
        int k=15;
        int long_sub_array = longestSum(arr,k);
        System.out.print(long_sub_array);
    }
    public static int longestSum(int arr[],int k)
    {
        int sub_array_sum =0;
        int len=0;
        int i=0;
        for(int j=0;j<arr.length;j++)
        {
            sub_array_sum+=arr[j];
            if(sub_array_sum==k)
            {
                len = Math.max(len,j-i+1);
            }
            while(sub_array_sum>=k)
            {    sub_array_sum= sub_array_sum-arr[i];
                i++;
            }
        }
        return len;
    }
}
