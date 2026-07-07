class TimeMap {

    class TimeValPair {

        public int timestamp;
        public String val;

        public TimeValPair(int timestamp, String val) {
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    private Map<String, List<TimeValPair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            List<TimeValPair> curList = map.get(key);
            curList.add(new TimeValPair(timestamp, value));
            map.put(key, curList);
        } else {
            List<TimeValPair> newList = new ArrayList<>();
            newList.add(new TimeValPair(timestamp, value));
            map.put(key, newList);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<TimeValPair> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        int resIdx = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (list.get(middle).timestamp <= timestamp) {
                resIdx = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (resIdx < 0) {
            return "";
        } else {
            return list.get(resIdx).val;
        }
    }
}
