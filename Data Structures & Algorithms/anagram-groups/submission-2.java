class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strAsArray = str.toCharArray();
            Arrays.sort(strAsArray);
            String sorted = new String(strAsArray);
            if (map.containsKey(sorted)) {
                List<String> anagrams = map.get(sorted);
                anagrams.add(str);
                map.put(sorted, anagrams);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                map.put(sorted, anagrams);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
