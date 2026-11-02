
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(String.format("%04d", s.length()));
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int len = Integer.parseInt(str.substring(i, i + 4));

            i += 4;

            list.add(str.substring(i, i + len));

            i += len;
        }

        return list;
    }
}
