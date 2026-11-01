class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }
    public static void mergeSort(int []arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public static void merge(int []arr, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int k = 0;
        
        int [] temp = new int[high - low + 1];

        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i];
                i++;
            }else{
                temp[k++] = arr[j];
                j++;
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= high){
            temp[k++] = arr[j++];
        }

        for(int m = 0; m < temp.length; m++){
            arr[low + m] = temp[m];
        }
    }
}