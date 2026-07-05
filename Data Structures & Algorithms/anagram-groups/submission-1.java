class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (map.containsKey(sortedString)) {
                ArrayList<String> newList = map.get(sortedString);
                newList.add(s);
                map.put(sortedString, newList);
            } else {
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(s);
                map.put(sortedString, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
