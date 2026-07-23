class Twitter {

    Map<Integer, Set<Integer>> followersPerUser;
    Map<Integer, List<int[]>> tweetsPerUser;
    int count;

    public Twitter() {
        followersPerUser = new HashMap<>();
        tweetsPerUser = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetsPerUser.putIfAbsent(userId, new ArrayList<>());
        Set<Integer> defaultSet = new HashSet<>();
        defaultSet.add(userId);
        followersPerUser.putIfAbsent(userId, defaultSet);
        tweetsPerUser.get(userId).add(new int[]{count, tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (followersPerUser.get(userId) == null) {
            return new ArrayList<>();
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });

        for (int followee : followersPerUser.get(userId)) {
            if (tweetsPerUser.get(followee) != null) {
                List<int[]> tweetList = tweetsPerUser.get(followee);
                int[] mostRecentTweet = tweetList.get(tweetList.size() - 1);
                int nextIndex = tweetList.size() - 2;
                maxHeap.add(new int[]{mostRecentTweet[0], mostRecentTweet[1], nextIndex, followee});    
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] maxTweet = maxHeap.poll();
            result.add(maxTweet[1]);
            if (maxTweet[2] >= 0) {
                List<int[]> tweetList = tweetsPerUser.get(maxTweet[3]);
                int[] mostRecentTweet = tweetList.get(maxTweet[2]);
                int nextIndex = maxTweet[2] - 1;
                maxHeap.add(new int[]{mostRecentTweet[0], mostRecentTweet[1], nextIndex, maxTweet[3]});
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> defaultSet = new HashSet<>();
        defaultSet.add(followerId);
        followersPerUser.putIfAbsent(followerId, defaultSet);
        followersPerUser.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && followersPerUser.containsKey(followerId)) {
            followersPerUser.get(followerId).remove(followeeId);
        }    
    }
}
