import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class Q355_Design_Twitter {
	private int timeStamp = 0;
    private Map<Integer, user> userMap;
    
    private class tweet{
        public int id;
        public int time;
        public tweet next;
        
        public tweet(int id){
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }
    
    private class user{
        int id;
        tweet tweetHead;
        Set<Integer> followed;
        
        public user(int id){
            this.id = id;
            tweetHead = null;
            followed = new HashSet<Integer>();
            followed.add(id);
        }
        
        public void follow(int userId){
            followed.add(userId);
        }
        
        public void unfollow(int userId){
            followed.remove(userId);
        }
        
        public void post(int id){
            tweet t = new tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }
    
    /** Initialize your data structure here. */
    public Q355_Design_Twitter() {
        userMap = new HashMap<Integer, user>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new user(userId));
        }
        
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(!userMap.containsKey(userId)) {
            return list;
        }
        
        Set<Integer> users = userMap.get(userId).followed;
        Queue<tweet> heap = new PriorityQueue<tweet>(1, new Comparator<tweet>(){
            public int compare(tweet left, tweet right){
                return right.time - left.time;
            }
        });
        
        for(int user : users){
            tweet t = userMap.get(user).tweetHead;
            
            if(t != null){
                heap.offer(t);
            }
        }
        
        int n = 0;
        
        while(!heap.isEmpty() && n < 10){
            tweet t = heap.poll();
            list.add(t.id);
            n++;
            
            if(t.next != null){
                heap.offer(t.next);
            }
        }
        
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId, new user(followerId));
        }
        
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new user(followeeId));
        }
        
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId) {
            return;
        }
        
        userMap.get(followerId).unfollow(followeeId);
    }
}
