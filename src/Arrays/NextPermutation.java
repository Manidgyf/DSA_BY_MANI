package Arrays;

class NextPermutation {
    public static void main(String args[])
    {
        int arr[] = new int[]{1,2,3};
        nextPermutation(arr);
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length - 1;
        int ind = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverseArray(nums, 0, n);
        } else {
            for (int i = n; i > ind; i--) {
                if (nums[i] > nums[ind]) {
                    int temp = nums[ind];
                    nums[ind] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            reverseArray(nums, ind + 1, n);
        }
    }

    public static void reverseArray(int arr[], int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
