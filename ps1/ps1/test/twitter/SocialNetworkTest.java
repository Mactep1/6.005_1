/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SocialNetworkTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     */
	private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alpha", "is it reasonable to talk about rivest so@beta much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "beta", "rivest talk in 30 minutes #hype@alpha", d2);
    private static final Tweet tweet3 = new Tweet(3, "alpha", "is it reasonable to talk about rivest so@beta @gamma much?", d1);
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    @Test
    public void testGuessFollowsGraphEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
        
        assertTrue("expected empty graph", followsGraph.isEmpty());
    }
    
    @Test
    public void testGuessFollowsGraphNoEmpty() {
    	Map<String,Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1,tweet2,tweet3));
    	Map<String,Set<String>> expectedGraph = new HashMap<>();
    	Set<String> followedUserByAlpha = new HashSet<>();
    	followedUserByAlpha.add("@beta");
    	followedUserByAlpha.add("@gamma");
    	
    	Set<String> followedUserByBeta = new HashSet<>();
    	followedUserByBeta.add("@alpha");    	
    	expectedGraph.put("alpha",followedUserByAlpha);
    	expectedGraph.put("beta", followedUserByBeta);
    	assertTrue(followsGraph.equals(expectedGraph));
    }
    @Test
    public void testInfluencersEmpty() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        
        assertTrue("expected empty list", influencers.isEmpty());
    }
    
    @Test
    public void testInfluencersNoEmpty() {
    	Map<String,Set<String>> followGraph = new HashMap<>();
    	Set<String> followersOfA = new HashSet<>();
    	Set<String> followersOfB = new HashSet<>();
    	Set<String> followersOfC = new HashSet<>();
    	List<String> expectedList = new ArrayList<>();
    	
    	followersOfA.add("a1");
    	followersOfA.add("a2");
    	followersOfA.add("a3");
    	
    	followersOfB.add("b1");
    	followersOfB.add("b2");
    	//followersOfB.add("b3");
    	
    	followGraph.put("A", followersOfA);
    	followGraph.put("B", followersOfB);
    	followGraph.put("C", followersOfC);
    	
    	expectedList.add("A");
    	expectedList.add("B");
    	expectedList.add("C");
    	
    	assertTrue(expectedList.equals(SocialNetwork.influencers(followGraph)));
    	
    	
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */

}
