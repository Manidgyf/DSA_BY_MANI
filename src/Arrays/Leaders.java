package Arrays;

import java.util.ArrayList;
import java.util.Collections;
class Leaders {
    public static void main(String args[])
    {
        int arr[] = new int[]{1,2,3};
        leaders(arr);
    }
    static ArrayList<Integer> leaders(int arr[])
    {
        // code here
        int n = arr.length-1;
        ArrayList<Integer> llist = new  ArrayList<>();
        llist.add(arr[n]);
        for(int i=n-1;i>=0;i--)
        {
            if(arr[i]>=arr[i+1] && llist.get(llist.size()-1)<=arr[i])
            {
                llist.add(arr[i]);
            }
        }
        Collections.reverse(llist);
        return llist;
    }
}


