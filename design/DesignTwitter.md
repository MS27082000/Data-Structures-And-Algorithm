# Design Twitter (LC 355)

**Problem:** Design a simplified Twitter with:
- `postTweet(userId, tweetId)`
- `getNewsFeed(userId)`: the **10 most recent** tweet ids from the user **and the people they follow**, newest first
- `follow(followerId, followeeId)` / `unfollow(followerId, followeeId)`

**Data structures**
- A global **timestamp** counter (so tweets from different users can be ordered).
- `tweets: userId → list of {time, tweetId}` (appended in time order, so each list is already sorted).
- `following: userId → Set<userId>`.

**`getNewsFeed` = k-way merge:** Each relevant user's tweet list is sorted by time. Put the **latest tweet of every relevant user** in a **max-heap by time**. Pop the newest, add it to the feed, then push that user's **previous** tweet. Stop after 10 → **O(F + 10 log F)**, where F = followed users + 1.

**Intuition:** It is "merge k sorted lists, but only take the first 10 and walk backwards", so no need to look at older tweets than necessary.

**Complexity:** `postTweet`, `follow`, `unfollow` O(1). `getNewsFeed` O(F log F) at worst (O(F + 10 log F) with the approach above).

**Edge cases:** A user with no tweets, a user who follows nobody, unfollowing someone not followed, following yourself (ignore), following the same person twice (a `Set` makes it idempotent), fewer than 10 tweets.

**Interview traps**
- Include the **user's own** tweets in their feed.
- A **timestamp**, not the tweet id, decides recency (ids aren't ordered).
- Don't merge all tweets of all followees. Only the top 10 are needed, so use the heap.
- Production concerns to mention: fan-out on write vs fan-out on read, sharding, caching timelines.

**How to explain:** "I store each user's tweets with timestamps and who they follow. For the feed I do a k-way merge: a max-heap holds the newest tweet of each relevant user, and I pop ten times, each time pushing the same user's next-older tweet."
