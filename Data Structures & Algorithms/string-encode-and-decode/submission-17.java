class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("/");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int curStartIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                int num = Integer.parseInt(str.substring(curStartIdx, i));
                String s = str.substring(i + 1, i + num + 1);
                result.add(s);
                curStartIdx = i + num + 1;
                i = curStartIdx;
            }
        }

        return result;
    }
}
