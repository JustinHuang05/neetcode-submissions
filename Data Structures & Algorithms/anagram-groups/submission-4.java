class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] countArr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                countArr[s.charAt(i) - 'a']++;
            }
            map.putIfAbsent(Arrays.toString(countArr), new ArrayList<>());
            map.get(Arrays.toString(countArr)).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
