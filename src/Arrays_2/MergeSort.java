package Arrays_2;

public class MergeSort {
        void mergeSort(int arr[], int l, int r) {
            // code here
            if(l>=r)
            {
                return;
            }
            int mid = (l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }

        void merge(int arr[],int l,int mid,int r) {
            int[] final_arr = new int[r - l + 1];
            int p1 = l;
            int p2 = mid + 1;
            int i = 0;
            while (p1 <= mid && p2 <= r) {
                if (arr[p1] >= arr[p2]) {
                    final_arr[i] = arr[p2];
                    p2++;
                } else {
                    final_arr[i] = arr[p1];
                    p1++;
                }
                i++;
            }
            while (p1 <= mid) {
                final_arr[i] = arr[p1];
                p1++;
                i++;
            }
            while (p2 <= r) {
                final_arr[i] = arr[p2];
                p2++;
                i++;
            }
            System.arraycopy(final_arr, 0, arr, l, final_arr.length);
        }
}
