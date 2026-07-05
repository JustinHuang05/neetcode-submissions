class Solution {

    public String encode(List<String> strs) {
        String res = "";

        for (String s : strs) {
            res += s.length() + ">" + s;
        }

        return res;
    }

    public List<String> decode(String str) {

        if (str.length() == 0) {
            return new ArrayList<String>();
        }

        ArrayList<String> res = new ArrayList<String>();

        int curIndex = 0;
        
        while (true) {

            int lastNumIndex = curIndex;
            for (int i = curIndex; str.charAt(i) != '>'; i++) {
                lastNumIndex = i;
            }

            int curWordLength = Integer.parseInt(str.substring(curIndex, lastNumIndex + 1));
            res.add(str.substring(lastNumIndex + 2, lastNumIndex + 2 + curWordLength));
            
            curIndex = lastNumIndex + 2 + curWordLength;

            if (curIndex == str.length()) {
                break;
            }
        }

        return res;
    }
}
