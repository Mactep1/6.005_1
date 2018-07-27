/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph<L> implements Graph<L> {
    
    private final Set<L> vertices;
    private final List<Edge<L>> edges;
    
    // Abstraction function:
    // represent ConcreteEdgesGraph (vertices,edges)
    
    // Representation invariant:
    //  sources and targets of edges are contained in vertices
    
    // Safety from rep exposure:
    //  all fields are private
    // vertices and edges are mutable types,so defensive copy is made in the constructor
    //to avoid sharing the rep's vertices and edges object with clients.
    
    // constructor
    public ConcreteEdgesGraph(Set<L> vertices,List<Edge<L>> edges) {
    	this.vertices=new HashSet<L>(vertices);
    	this.edges=new ArrayList<Edge<L>>(edges);
    	checkRep();
    }
    
    public ConcreteEdgesGraph() {
    	this.vertices=new HashSet<>();
    	this.edges=new ArrayList<>();
    	checkRep();
    }
    
    // TODO checkRep
    private void checkRep() {
    	for(Edge<L> e:edges) {
    		assert vertices.contains(e.getSource());
    		assert vertices.contains(e.getTarget());
    	}
    }
    @Override public boolean add(L vertex) {
        //throw new RuntimeException("not implemented");
    	if(vertices.contains(vertex)) {
    		return false;
    	}else {
    		vertices.add(vertex);
    		checkRep();
    		return true;
    	}
    }
    
    @Override public int set(L source, L target, int weight) {
        //throw new RuntimeException("not implemented");
    	if(weight!=0) {
    	Edge<L> e1=new Edge<L>(source,target,weight);
    	for(Edge<L> e:edges) {
    		if(e.equals(e1)) {
    			return e.getWeight();
    		}
    	}
    	edges.add(e1);
    	checkRep();
    	return 0;
    	}
    	else {
    		Edge<L> e2=new Edge<L>(source,target,1);
    		for(Edge<L> e:edges) {
    			if(e.equals(e2)) {
    				return e.getWeight();
    			}
    		}
    		return 0;
    	}
    	
    }
    
    @Override public boolean remove(L vertex) {
        //throw new RuntimeException("not implemented");
    	if(!vertices.contains(vertex)) {
    		return false;
    	}
    	else {
    		vertices.remove(vertex);
    		for(Edge<L> e:edges) {
    			if(e.contains(vertex)) {
    				edges.remove(e);
    			}
    		}
    		checkRep();
    		return true;
    	}
    }
    
    @Override public Set<L> vertices() {
        //throw new RuntimeException("not implemented");
    	return new HashSet<>(vertices);
    }
    
    @Override public Map<L, Integer> sources(L target) {
        //throw new RuntimeException("not implemented");
    	HashMap<L, Integer> newmap=new HashMap<>();
    	for(Edge<L> e:edges) {
    		if(e.containsTarget(target)) {
    			newmap.put((L) e.getSource(), (Integer)(e.getWeight()));
    		}
    	}
    	return newmap;
    }
    
    @Override public Map<L, Integer> targets(L source) {
        //throw new RuntimeException("not implemented");
    	HashMap<L,Integer> newmap=new HashMap<>();
    	for(Edge<L> e:edges) {
    		if(e.containsSource(source)) {
    			newmap.put((L) e.getTarget(), e.getWeight());
    		}
    	}
    	return newmap;
    }
    //  toString()
    @Override public String toString() {
    	return vertices.toString()+";"+edges.toString();
    }
    
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
final class Edge<L>{
    
    // TODO fields
    private final L target;
    private final L source;
    private final int weight;
    // Abstraction function:
    //    represent the edge target to source(weight)
    
    // Representation invariant:
    //    target and source are not null and weight is not 0
    
    // Safety from rep exposure:
    //   all fields are private
    //   all fileds are immutable
    
    //  constructor
    public Edge(L source,L target,int weight) {
    this.source=source;
    this.target=target;
    this.weight=weight;
    checkRep();
    }
    
    //  checkRep
    private void checkRep() {
    	assert target != null;
    	assert source !=null;
    	assert weight !=0;
    }
    //  methods
    public L getSource() {
    	return source;
    }
    public L getTarget() {
    	return target;
    }
    public int getWeight() {
    	return weight;
    }
    public boolean contains(L vertice) {
    	if(vertice.equals(source)||vertice.equals(target)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean containsSource(L vertice) {
    	if(vertice.equals(source)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean containsTarget(L vertice) {
    	if(vertice.equals(target)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    @Override
    public boolean equals(Object o) {
    	if(!(o instanceof Edge<?>)) {
    		return false;
    	}
    	else {
    		Edge<?> e=(Edge<?>) o;
    		return e.getSource().equals(source)&& e.getTarget().equals(target)&& e.getWeight()==weight;
    	}
    }
    @Override
    public int hashCode() {
    	return source.hashCode()+target.hashCode()+weight;
    }
    //  toString()
    @Override
    public String toString() {
    	return "source is"+source+";target is"+target+";weight is"+weight;
    }
}
