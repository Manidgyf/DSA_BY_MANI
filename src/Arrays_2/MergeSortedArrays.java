package Arrays_2;

import java.util.*;
public class MergeSortedArrays {

    private static void swapGreater(int[] nums1, int ind1, int[] nums2, int ind2)
    {
        if(nums1[ind1]>nums2[ind2])
        {
            int t = nums1[ind1];
            nums1[ind1] = nums2[ind2];
            nums2[ind2]=t;
        }
    }
    public static void main(String[] args)
    {
       int[] nums1 = {1,2,3,0,0,0};
       int m = 3;
       int[] nums2 = {2,5,6};
       int n = 3;

       mergeArrays_Better(nums1,m,nums2,n);

       System.out.println(Arrays.toString(nums1));
    }

    public static void mergeArrays(int[] nums1,int m , int[] nums2,int n )
    {
        int len = m+n;
        int gap = len/2 + len%2;

        while(gap>0)
        {
            int left =0;
            int right = left+gap;
            while(right<len)
            {
                //arr1 and arr2
                if(left<m && right>=m)
                {
                    swapGreater(nums1,left,nums2,right-m);
                }
                //arr2 and arr2
                else if(left>=m)
                {
                    swapGreater(nums2,left-m,nums2,right-m);
                }
                //arr1 and arr1
                else
                {
                    swapGreater(nums1,left,nums1,right);
                }
                left++;
                right++;
            }
            if(gap==1) break;
            else
                gap = gap/2 + gap%2;

        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }


    public static void mergeArrays_Better(int[] nums1,int m , int[] nums2,int n )
    {
        int i= m-1;
        int j=0;

        while( i>=0 && j<n && nums1[i]>=nums2[j] )
        {
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;

            i--;
            j++;
        }

        for(int k = 0;k<n;k++)
        {
            nums1[m+k] = nums2[k];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}
