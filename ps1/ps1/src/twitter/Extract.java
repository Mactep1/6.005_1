/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.time.Instant;
import java.util.regex.Matcher;
/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
    	Instant start=tweets.get(0).getTimestamp();
    	Instant end=tweets.get(0).getTimestamp();
    	for (Tweet tweeter: tweets) {
    		if(tweeter.getTimestamp().isAfter(end)) {
    			end=tweeter.getTimestamp();
    		}
    		if(tweeter.getTimestamp().isBefore(start)) {
    			start=tweeter.getTimestamp();
    		}
    	}
    	Timespan tweetSpan= new Timespan(start,end);
    	return tweetSpan;
        //throw new RuntimeException("not implemented");
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
    	String pattern="(@{1}\\w+[A-Za-z0-9_-]*)";
    	
    	Pattern r=Pattern.compile(pattern);
    	Pattern r_1=Pattern.compile("(@{1}\\w+)(\\.[a-zA-Z]{2,5})");
    	Set<String> usernames=new HashSet<>();
        for(Tweet tweeter: tweets) {
        	String text=tweeter.getText();
        	Matcher m=r.matcher(text);
        	Matcher m_1=r_1.matcher(text);
        	while(m.find()) {
        		String username=m.group();
        		if(!usernames.contains(username.toLowerCase())) {
        			usernames.add(username);
        		}
        
        	}
        	
        	while(m_1.find()) {
        		if(usernames.contains(m_1.group(1))) {
        			usernames.remove(m_1.group(1));
        		}
        	}
        }
        return usernames;
    	
    	//throw new RuntimeException("not implemented");
    }

}
