package Arrays_3;

import java.util.*;
public class FourSum {
    public static void main(String[] args) {

        System.out.println(CalculateSum(new int[]{1,0,-1,0,-2,2},0));
    }
    public static List<List<Integer>> CalculateSum(int[] nums,int target)
    {
                int n = nums.length;
                Arrays.sort(nums);
                List<List<Integer>> result = new ArrayList<>();
                for(int i=0;i<n-3;i++)
                {
                    if(i>0 && nums[i]==nums[i-1]) continue;

                    for(int j=i+1;j<n-2;j++)
                    {

                        if(j>i+1 && nums[j]==nums[j-1]) continue;
                        int k=j+1;
                        int l=n-1;

                        while(k<l)
                        {
                            long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                            if(target==sum)
                            {
                                result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
                                k++;
                                l--;
                            }
                            else if(target>sum)
                            {
                                k++;
                            }
                            else
                            {
                                l--;
                            }
                            while(k>j+1 && k<n-2 && nums[k]==nums[k-1]) k++;
                            while(l<n-1 && l>k+1 && nums[l]==nums[l+1]) l--;

                        }
                    }
                }
                return result;
        }
    }


