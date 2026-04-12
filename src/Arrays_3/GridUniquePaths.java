package Arrays_3;

import java.util.*;
public class GridUniquePaths {
    public static void main(String[] args) {
        int m=3;
        int n=2;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
//        System.out.println(countGridPathsMemo(m - 1, n - 1, dp));
//        System.out.println(countGridPathsTab(4,2));
        System.out.println(countGridPathsSpaceOpt(3,7));
    }
    public static int countGridPathsMemo(int i,int j,int[][] dp)
    {
        if (i == 0 && j == 0) {
            dp[i][j] = 1;
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        int up = countGridPathsMemo(i - 1, j, dp);

        int left = countGridPathsMemo(i, j - 1, dp);

        dp[i][j] = up + left;

        return up + left;
    }

    public static int countGridPathsTab(int m,int n)
    {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0&&j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                else
                {
                    int down=0;
                    int right=0;
                    if(i>0)
                        down=dp[i-1][j];
                    if(j>0)
                        right=dp[i][j-1];
                    dp[i][j]=right+down;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static int countGridPathsSpaceOpt(int m,int n)
    {
        int[] prev = new int[n];
        for(int i=0;i<m;i++)
        {
            int[] dp = new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0&&j==0)
                {
                    dp[j]=1;
                    continue;
                }
                else
                {
                    int down=0;
                    int right=0;
                    if(i>0)
                        down=prev[j];
                    if(j>0)
                        right=dp[j-1];
                    dp[j]=right+down;
                }

            }
            System.arraycopy(dp,0,prev,0,n);
        }
        return prev[n-1];
    }
}
