class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            List<String> list = new ArrayList<>();
            int[] freq = new int[26];

            list.add(strs[i]);
            vis[i] = true;

            for (char ch : strs[i].toCharArray()) {
                freq[ch - 'a']++;
            }

            for (int j = i + 1; j < n; j++) {
                if (vis[j]) continue;

                int[] temp = freq.clone();

                for (char ch : strs[j].toCharArray()) {
                    temp[ch - 'a']--;
                }

                boolean isAna = true;

                for (int k : temp) {
                    if (k != 0) {
                        isAna = false;
                        break;
                    }
                }

                if (isAna) {
                    list.add(strs[j]);
                    vis[j] = true;
                }
            }

            ans.add(list);
        }

        return ans;
    }
}