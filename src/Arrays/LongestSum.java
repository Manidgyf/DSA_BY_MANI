package Arrays;

// Online Java Compiler Both positive and negative
// Use this editor to write, compile and run your Java code online
import java.util.HashMap;
class LongestSum {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 5, 2, 7, 1, 9};
        int k=15;
        int long_sub_array = longestSum(arr,k);
        System.out.print(long_sub_array);
    }
    public static int longestSum(int arr[],int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix_sum =0;
        int len=0;
        for(int i=0;i<arr.length;i++)
        {
            prefix_sum+=arr[i];
            if (prefix_sum == k) {
                len  = Math.max(len,i+1);
            } else if (map.containsKey(prefix_sum - k)) {
                len = Math.max(len, i - map.get(prefix_sum - k));
            }
	If(!map.contains(prefix_sum))
	{
		Map[prefix_sum]=i;
	}
        }
        return len;
    }
}
