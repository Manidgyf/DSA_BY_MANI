package Arrays;

class setZeroes {
    public static void main(String args[])
    {
        for(int i=0;i<300;i++)
        {
            setZeroesOptimal(new int[][]{{0}});
        }
    }
    public static void setZeroesOptimal(int[][] matrix) {
        int colz = 1;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(j==0)
                    {
                        colz=0;
                    }
                    else
                    {
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }
        }
        for(int i=1;i<matrix.length;i++)
        {  for(int j=1;j<matrix[0].length;j++)
        {
            if(matrix[i][0]==0 || matrix[0][j]==0)
            {
                matrix[i][j]=0;
            }
        }
        }
        if(matrix[0][0]==0)
        {
            for(int j=0;j<matrix[0].length;j++)
        {
            matrix[0][j]=0;
        }
        }
        if(colz==0)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0]=0;
            }
        }

    }
}