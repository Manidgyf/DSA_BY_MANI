package Arrays_3;

public class Pow_x_n {

    public static void main(String[] args)
    {
        float x = 2.100f;
        int n = 10;

        System.out.println(power(x,n));

    }
    public static double power(float x,int n)
 {
            long n1;
            if(n<0)
                n1 = -1*(long)n;
            else
                n1=(long)n;
            double result= 1;
            while(n1>0)
            {
                if(n1%2==0)
                {
                    x=x*x;
                    n1=n1/2;
                }
                else
                {
                    result = result*x;
                    n1=n1-1;
                }
            }
            if(n>=0)
                return result;
            else
                return 1/result;

        }
}
