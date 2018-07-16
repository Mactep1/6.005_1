/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
    // Testing strategy
    //   TODO
    
    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testInitialVerticesEmpty() {
        // TODO you may use, change, or remove this test
        assertEquals("expected new graph to have no vertices",
                Collections.emptySet(), emptyInstance().vertices());
    }
    
    @Test
    public void testAdd() {
    	String vertice="v";
    	String vertice1="v";
    	assertTrue(emptyInstance().add(vertice));
    	assertFalse(emptyInstance().add(vertice));
    	assertTrue(emptyInstance().add(vertice1));
    }
    // TODO other tests for instance methods of Graph
    
    public void testSet() {
    	String s1="v1";
    	String s2="v2";
    	int w1=0;
    	int w2=1;
    	int w3=-1;
    	
    	int r1=emptyInstance().set(s1, s1, w1);
    	int r2=emptyInstance().set(s1, s1, w2);
    	int r3=emptyInstance().set(s1, s1, w3);
    	int r4=emptyInstance().set(s1, s2, w1);
    	int r5=emptyInstance().set(s1, s2, w2);
    	int r6=emptyInstance().set(s1, s2, w3);
    	int r7=emptyInstance().set(s1, s2, w1);
    	
    	assertEquals(r1, 0);
    	assertEquals(r2, 0);
    	assertEquals(r3, 1);
    	assertEquals(r4, -1);
    	assertEquals(r5, 0);
    	assertEquals(r6, 1);
    	assertEquals(r7, -1);
    }
    
    public void testRemove() {
    	String vertice="v";
    	
    	assertFalse(emptyInstance().remove(vertice));
    	emptyInstance().add(vertice);
    	assertTrue(emptyInstance().remove(vertice));
    }
    
    public void testVertices() {
    	String s1="v1";
    	String s2="v2";
    	Set<String> set1=new HashSet<String>();
    	set1.add(s1);
    	assertEquals(Collections.EMPTY_SET, emptyInstance().vertices());
    	emptyInstance().add(s1);    	
    	assertEquals(set1, emptyInstance());
    }
    
    public void testSources() {
    	String s1="v1";
    	String s2="v2";
    	String s3="v3";
    	int w1=0;
    	int w2=1;
    	int w3=-1;
    	
    	emptyInstance().set(s1, s1, w2);
    	emptyInstance().set(s1, s2, w2);
    	emptyInstance().set(s3, s2, w3);
    	
    	Map<String, Integer> m0=new HashMap<>();
    	m0.put(s1, w2);
    	Map<String, Integer> m1=new HashMap<>();
    	m1.put(s1, w2);
    	m1.put(s3, w3);
    	
    	assertEquals(m0, emptyInstance().sources(s1));
    	assertEquals(m1, emptyInstance().sources(s2));
    	assertEquals(Collections.EMPTY_MAP, emptyInstance().sources(s3));
    }
    
    public void assertTargets() {
    	String s1="v1";
    	String s2="v2";
    	String s3="v3";
    	int w1=0;
    	int w2=1;
    	int w3=-1;
    	
    	emptyInstance().set(s1, s1, w2);
    	emptyInstance().set(s2, s1, w2);
    	emptyInstance().set(s2, s3, w3);
    	
    	Map<String, Integer> m0=new HashMap<>();
    	m0.put(s1, w2);
    	Map<String, Integer> m1=new HashMap<>();
    	m1.put(s1, w2);
    	m1.put(s3, w3);
    	
    	assertEquals(m0, emptyInstance().targets(s1));
    	assertEquals(m1, emptyInstance().targets(s2));
    	assertEquals(Collections.EMPTY_MAP, emptyInstance().targets(s3));
    }
}
