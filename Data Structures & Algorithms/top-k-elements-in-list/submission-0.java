
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        for(int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        int[] freq = new int[max - min + 1];

        for(int num : nums) {
            freq[num - min]++;
        }
        List<Integer>[] temp = new List[n + 1];

        for(int i = 0; i <= n; i++) {
            temp[i] = new ArrayList<>();
        }

        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                temp[freq[i]].add(i + min);
            }
        }

        int[] res = new int[k];
        int m = 0;

        for(int i = n; i >= 1; i--) {
            for(int num : temp[i]) {
                if(m < k) {
                    res[m++] = num;
                } else {
                    return res;
                }
            }
        }

        return res;
    }
}