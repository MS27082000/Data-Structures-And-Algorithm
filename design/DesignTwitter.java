import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/** Design Twitter (LC 355): postTweet, follow, unfollow and getNewsFeed (the 10 most recent tweets from the user and the people they follow) */
public class DesignTwitter {

    private int clock = 0;                                              // a global timestamp orders tweets across all users
    private final Map<Integer, List<int[]>> tweets = new HashMap<>();   // userId -> list of {time, tweetId}, oldest first
    private final Map<Integer, Set<Integer>> following = new HashMap<>();

    void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{clock++, tweetId});
    }

    // k-way merge of already time-ordered lists: put the LATEST tweet of every relevant user into a max-heap by time, pop the newest,
    // then push that user's previous tweet. Stop at 10. O(F + 10 log F) where F = the number of followed users + 1
    List<Integer> getNewsFeed(int userId) {
        Set<Integer> users = new HashSet<>(following.getOrDefault(userId, new HashSet<>()));
        users.add(userId);                                              // a user sees their own tweets too
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));   // {time, tweetId, userId, index}
        for (int u : users) {
            List<int[]> list = tweets.get(u);
            if (list != null && !list.isEmpty()) {
                int last = list.size() - 1;
                heap.offer(new int[]{list.get(last)[0], list.get(last)[1], u, last});
            }
        }
        List<Integer> feed = new ArrayList<>();
        while (!heap.isEmpty() && feed.size() < 10) {
            int[] top = heap.poll();
            feed.add(top[1]);
            int next = top[3] - 1;                                      // that user's previous (older) tweet
            if (next >= 0) {
                int[] t = tweets.get(top[2]).get(next);
                heap.offer(new int[]{t[0], t[1], top[2], next});
            }
        }
        return feed;
    }

    void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;                          // following yourself is meaningless (you already see your tweets)
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    void unfollow(int followerId, int followeeId) {
        Set<Integer> s = following.get(followerId);
        if (s != null) s.remove(followeeId);
    }

    public static void main(String[] args) {
        DesignTwitter t = new DesignTwitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));        // [5]
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1));        // [6, 5]   (newest first)
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));        // [5]
        DesignTwitter u = new DesignTwitter();
        for (int i = 1; i <= 12; i++) u.postTweet(1, 100 + i);
        System.out.println(u.getNewsFeed(1));        // [112, 111, 110, 109, 108, 107, 106, 105, 104, 103]  (only 10)
        System.out.println(u.getNewsFeed(99));       // []  (unknown user)
    }
}
