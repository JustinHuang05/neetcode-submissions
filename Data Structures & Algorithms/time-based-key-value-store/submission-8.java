class TimeMap {

    class Pair {
        public String value;
        public int time;

        public Pair(String v, int t) {
            value = v;
            time = t;
        }
    }

    Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        List<Pair> list = map.get(key);
        list.add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).time <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
