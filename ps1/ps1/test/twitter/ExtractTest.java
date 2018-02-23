/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExtractTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     */
    
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3,"cat","Do you hear the peopel sing @realtrump_whitehouse",d1);
    private static final Tweet tweet4 = new Tweet(4,"dog","@shakespear,@denmark-09haha to be,or not to be,that is a question@Shakespear@hamlet@--hehe",d2);
    private static final Tweet tweet5 = new Tweet(5,"eve","to die,to sleep,and by a sleep to say we end the heartache@mit.edu.cn,23424@qq.com",d2);
    /*one username 
    morethanone usernames
    letter
    digit
    hypen underscore*/
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGetTimespanTwoTweets() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1, tweet2));
        
        assertEquals("expected start", d1, timespan.getStart());
        assertEquals("expected end", d2, timespan.getEnd());
        
    }
    
    @Test
    public void testGetTimespanOneTweet() {
    	Timespan timespan =Extract.getTimespan(Arrays.asList(tweet1));
    	
    	assertEquals("expected start",d1,timespan.getStart());
    	assertEquals("expected end",d1,timespan.getEnd());
    }
    @Test
    public void testGetTimespanTwoSimultaneousTweets() {
    	Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1,tweet1));
    	
    	assertEquals("expectstart",d1,timespan.getStart());
    	assertEquals("expected end",d1,timespan.getEnd());
    }
    
    @Test
    public void testGetMentionedUsersNoMention() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet1));
        
        assertTrue("expected empty set", mentionedUsers.isEmpty());
    }
    @Test
    public void testGetMentionedUsersOneMention() {
    	Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet3));
    	Set<String> expectedUsers = new HashSet<>();
    	expectedUsers.add("@realtrump_whitehouse");
    	assertTrue(mentionedUsers.equals(expectedUsers));
    }
    
    @Test
    public void testGetMentionedUsersMoreMentions() {
    	Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet3,tweet4));
    	Set<String> expecteUsers= new HashSet<>();
        expecteUsers.add("@realtrump_whitehouse");
        expecteUsers.add("@shakespear");
        expecteUsers.add("@hamlet");
        expecteUsers.add("@denmark-09haha");
        assertTrue(mentionedUsers.equals(expecteUsers));
        
    	
    }
    
    @Test
    public void testGetMentionedUsersEmailDomain() {
    	Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet5));
    	assertTrue(mentionedUsers.isEmpty());
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * Extract class that follows the spec. It will be run against several staff
     * implementations of Extract, which will be done by overwriting
     * (temporarily) your version of Extract with the staff's version.
     * DO NOT strengthen the spec of Extract or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Extract, because that means you're testing a
     * stronger spec than Extract says. If you need such helper methods, define
     * them in a different class. If you only need them in this test class, then
     * keep them in this test class.
     */

}
