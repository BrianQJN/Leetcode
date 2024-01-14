import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.
 * Implement the Twitter class:
 * Twitter() Initializes your twitter object.
 * void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
 * List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
 * void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
 * void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 * @since 2024-01-14
 */
public class Design_Twitter_355 {
    private static int timestamp = 0;

    private static class Tweet {
        private final int id;
        private final int time;
        private Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            next = null;
        }
    }

    private final Map<Integer, Set<Integer>> following;
    private final Map<Integer, Tweet> tweetMap;

    public Design_Twitter_355() {
        following = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = tweetMap.getOrDefault(userId, null);
        tweetMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer> followIds = following.getOrDefault(userId, new HashSet<>());
        followIds.add(userId);

        for (int followId : followIds) {
            Tweet t = tweetMap.get(followId);
            if (t != null) {
                maxHeap.add(t);
            }
        }

        List<Integer> res = new ArrayList<>();
        int n = 0;
        while (!maxHeap.isEmpty() && n < 10) {
            Tweet t = maxHeap.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                maxHeap.add(t.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId) && followerId != followeeId) {
            following.get(followerId).remove(followeeId);
        }
    }
}
