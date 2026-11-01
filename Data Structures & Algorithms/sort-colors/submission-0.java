class Solution {
    public void sortColors(int[] nums) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int num : nums){
            if(num == 0) cnt0++;
            else if(num == 1) cnt1++;
            else cnt2++;
        }
        int j = 0;
        while(cnt0-- > 0){
            nums[j++] = 0;
        }
        while(cnt1-- > 0){
            nums[j++] = 1;
        }
        while(cnt2-- > 0){
            nums[j++] = 2;
        }
    }
}