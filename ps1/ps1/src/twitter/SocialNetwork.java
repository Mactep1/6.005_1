/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * SocialNetwork provides methods that operate on a social network.
 * 
 * A social network is represented by a Map<String, Set<String>> where map[A] is
 * the set of people that person A follows on Twitter, and all people are
 * represented by their Twitter usernames. Users can't follow themselves. If A
 * doesn't follow anybody, then map[A] may be the empty set, or A may not even exist
 * as a key in the map; this is true even if A is followed by other people in the network.
 * Twitter usernames are not case sensitive, so "ernie" is the same as "ERNie".
 * A username should appear at most once as a key in the map or in any given
 * map[A] set.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class SocialNetwork {

    /**
     * Guess who might follow whom, from evidence found in tweets.
     * 
     * @param tweets
     *            a list of tweets providing the evidence, not modified by this
     *            method.
     * @return a social network (as defined above) in which Ernie follows Bert
     *         if and only if there is evidence for it in the given list of
     *         tweets.
     *         One kind of evidence that Ernie follows Bert is if Ernie
     *         @-mentions Bert in a tweet. This must be implemented. Other kinds
     *         of evidence may be used at the implementor's discretion.
     *         All the Twitter usernames in the returned social network must be
     *         either authors or @-mentions in the list of tweets.
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
        Map<String,Set<String>> follows = new HashMap<>();
        Set<String> mentionedUsers = new HashSet<>();
        for (Tweet tweeter : tweets) {
        	mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweeter));
        	if(!follows.containsKey(tweeter.getAuthor().toLowerCase())){
        	follows.put(tweeter.getAuthor().toLowerCase(), mentionedUsers);
        	}else {
        		follows.get(tweeter.getAuthor().toLowerCase()).addAll(mentionedUsers);
        	}
        	
        }
    	return follows;
    	//throw new RuntimeException("not implemented");
    }
    

     
    /**
     * Find the people in a social network who have the greatest influence, in
     * the sense that they have the most followers.
     * 
     * @param followsGraph
     *            a social network (as defined above)
     * @return a list of all distinct Twitter usernames in followsGraph, in
     *         descending order of follower count.
     */
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
    	/*establish a User class which consists of two fields and one construction method.*/
    	class User{
    		public String userName_;
    		public int followers;
    		public User(String userName_,int followers) {
    			this.userName_=userName_;
    			this.followers=followers;
    		}
    	}
    	
    	
    	
    	List<User> influencialUsers = new ArrayList<>();// construct a list with objects of User Class as elements
    	for(String userName : followsGraph.keySet()) {
    		User user = new User(userName,followsGraph.get(userName).size());//construct user object from followGraph, with the key as username_ and the valueset's size as followers count
    		influencialUsers.add(user);
    	}
    	influencialUsers.sort(new Comparator<User>() {//sort the influencialUsers list wiht interface comparator
    		@Override // override the "compare" method of interface Comparator 
    		public int compare(User user1,User user2) {
    			return -user1.followers+user2.followers;//if user1's followers is less than user2's,return positive.if positive,exchange user1's position with user2's
    		}
		});

    	List<String> userNames = new ArrayList<>();//since influencialUsers is a list of objects, userNames is the wanted list made of String.
    	for(User user_1: influencialUsers) {
    		userNames.add(user_1.userName_);
    	}
    	
    	return userNames;
    	
        //throw new RuntimeException("not implemented");
    }

}
