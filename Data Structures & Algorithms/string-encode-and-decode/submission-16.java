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
        int index = 0;
        while (index < str.length()) {
            StringBuilder num = new StringBuilder();
            while (str.charAt(index) != '/') {
                num.append(str.charAt(index));
                index++;
            }
            index++;
            int charCount = Integer.parseInt(num.toString());
            result.add(str.substring(index, index + charCount));
            index += charCount;
        }
        return result;
    }
}
