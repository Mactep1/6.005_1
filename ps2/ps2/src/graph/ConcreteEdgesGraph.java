/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph implements Graph<String> {
    
    private final Set<String> vertices = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    // represent ConcreteEdgesGraph (vertices,edges)
    
    // Representation invariant:
    //   TODO  sources and targets of edges are contained in vertices
    
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    
    // TODO checkRep
    private void checkRep() {
    	for(Edge e:edges) {
    		assert vertices.contains(e.getSource);
    		assert vertices.contains(e.getTarget);
    	}
    }
    @Override public boolean add(String vertex) {
        //throw new RuntimeException("not implemented");
    	if(vertices.contains(vertex)) {
    		return false;
    	}else {
    		vertices.add(vertex);
    		return true;
    	}
    }
    
    @Override public int set(String source, String target, int weight) {
        //throw new RuntimeException("not implemented");
    	if(weight!=0) {
    	Edge e1=new Edge(source,target,weight);
    	for(Edge e:edges) {
    		if(e.equals(e1)) {
    			return e.getWeight();
    		}
    	}
    	edges.add(e1);
    	return 0;
    	}
    	else {
    		Edge e2=new Edge(source,target,1);
    		for(Edge e:edges) {
    			if(e.equals(e2)) {
    				return e.getWeight();
    			}
    		}
    		return 0;
    	}
    }
    
    @Override public boolean remove(String vertex) {
        throw new RuntimeException("not implemented");
    }
    
    @Override public Set<String> vertices() {
        throw new RuntimeException("not implemented");
    }
    
    @Override public Map<String, Integer> sources(String target) {
        throw new RuntimeException("not implemented");
    }
    
    @Override public Map<String, Integer> targets(String source) {
        throw new RuntimeException("not implemented");
    }
    
    // TODO toString()
    
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
final class Edge {
    
    // TODO fields
    private final String target;
    private final String source;
    private final int weight;
    // Abstraction function:
    //   TODO  represent the edge target to source(weight)
    // Representation invariant:
    //   TODO target and source are not null and weight is not 0
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    public Edge(String source,String target,int weight) {
    this.source=source;
    this.target=target;
    this.weight=weight;
    }
    
    // TODO checkRep
    private void checkRep() {
    	assert target != null;
    	assert source !=null;
    	assert weight !=0;
    }
    // TODO methods
    public contains(String target)
    // TODO toString()
    
}
