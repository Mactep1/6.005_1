/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for ConcreteEdgesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteEdgesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteEdgesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteEdgesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteEdgesGraph();
    }
    
    /*
     * Testing ConcreteEdgesGraph...
     */
    @Test public void test() {
    	ConcreteEdgesGraph<String> testGraph=new ConcreteEdgesGraph<>();
    	String v1="a";
    	String v2="b";
    	String v3="c";
    	testGraph.set(v1, v2, 1);
    	testGraph.set(v2, v3, 1);
    	testGraph.set(v3, v1, 1);
    	Set<String> s=new HashSet<>();
    	s.add("a");
    	s.add("b");
    	s.add("c");
    	System.out.println(s);
    	System.out.println(testGraph.vertices());
    	assertEquals(s, testGraph.vertices());
    	
    	
    }
    // Testing strategy for ConcreteEdgesGraph.toString()
    //   TODO
    
    // TODO tests for ConcreteEdgesGraph.toString()
    
    /*
     * Testing Edge...
     */
    
    // Testing strategy for Edge
    //   TODO
    
    // TODO tests for operations of Edge
    
}
