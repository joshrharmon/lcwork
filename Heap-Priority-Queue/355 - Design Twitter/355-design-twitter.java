import java.time.*;

class Twitter {

	class tweet {
		private LocalDateTime postTime;
		private int userId, tweetId;
		
		public tweet(LocalDateTime postTime, int userId, int tweetId)) {
			this.postTime = postTime;
			this.userId = userId;
			this.tweetId = tweetId;
		}
		
		public LocalDateTime getTimestamp() {
			return postTime;
		}
		
		public int getUserId() {
			return userId;
		}
		
		public int getTweetId() {
			return tweetId;
		}
	}

    private HashMap<Integer, HashSet<Integer>> followMap;
	private PriorityQueue<LocalDateTime, 
	
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
    }
    
    public void follow(int followerId, int followeeId) {
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        
    }
	
	
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */