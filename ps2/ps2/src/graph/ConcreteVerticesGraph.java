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
public class ConcreteVerticesGraph<L> implements Graph<L> {
    
    private final List<Vertex<L>> vertices;
    
    // Abstraction function:
    //   represent concreteverticesgraph
    // Representation invariant:
    //   no repeated elements in vertices
    // Safety from rep exposure:
    //   field is private and final;vertices is a mutable type,so defensive copy is made in the constructor
    
    //  constructor
    public ConcreteVerticesGraph(List<Vertex<L>> vertices) {
		// TODO Auto-generated constructor stub
    	this.vertices=new ArrayList<>(vertices);
    	checkRep();
    }
    
    public ConcreteVerticesGraph(){
    	this.vertices=new ArrayList<>();
    	checkRep();
    }
    //  checkRep
    private void checkRep() {
    	for(int i=0;i<vertices.size();i++) {
    		for(int j=i;j<vertices.size();j++) {
    			assert !vertices.get(i).getVertex().equals(vertices.get(j).getVertex());
    		}
    	}
    }
    @Override public boolean add(L vertex) {
    	//throw new RuntimeException("not implemented");
    	for(Vertex<L> v:vertices) {
    		if(v.getVertex().equals(vertex)) {
    			return false;
    		}
    	}
    	HashMap<L, Integer> newHashmap=new HashMap<>();
    	Vertex<L> newVertex=new Vertex<L>(vertex,newHashmap);
    	vertices.add(newVertex);
    	return true;
    }
    
    @Override public int set(L source, L target, int weight) {
        //throw new RuntimeException("not implemented");
    	int w=0;
    	int flag=0;
    	int flag_target=0;
    	for(Vertex<L> v:vertices) {
    		
    	/*	if (v.getVertex().equals(source)) {
    			/*if(v.getTargets().containsKey(target)) {
    				int w=v.getWeight();
    				v.updateTargets(target,weight);
    				
    			}else {
    				v.updateTargets(target, weight);
    				return 
    			}*/
    		/*	v.updateTargets(target, weight);
    			if(v.getTargets().containsKey(target)) {
    				 w=v.getTargets().get(target);
    			}else {
    				w=0;
    			}
    			
    		}
    		if(v.getVertex().equals(target)) {
    			v.updateSources(source,weight);
    			if(v.getSources().containsKey(source)) {
    				w=v.getSources().get(source);
    			}else {
    				w=0;
    			}
    			
    		}
    	*/
    		
    		if(v.getVertex().equals(source)) {
    			v.updateTargets(target, weight);
    			if(v.getTargets().containsKey(target)) {
    				w=(int) v.getTargets().get(source);
    			}else {
    				w=0;
    			}
    			flag=1;
    		}
    		
    	if(v.getVertex().equals(target)) {
    		flag_target=1;
    	}
    	}
    	if(flag==0) {
    		if(weight!=0) {
    		HashMap<L, Integer> targets=new HashMap<>();
    		targets.put(target, weight);
    		Vertex<L> newSource=new Vertex<L>(source,targets);
    		vertices.add(newSource);
    	    w=0;
    		}else {
    			w=0;
    		}
    	}
    	if(flag_target==0) {
    		HashMap<L, Integer> targets=new HashMap<>();
    		Vertex<L> newTarget=new Vertex<L>(target,targets);
    		vertices.add(newTarget);
    	}
    	return w;
    	
    	
    }
    
    @Override public boolean remove(L vertex) {
        //throw new RuntimeException("not implemented");
    	boolean flag=false;
    	for(Vertex<L> v:vertices) {
    		if(v.getVertex().equals(vertex)) {
    			flag=true;
    			vertices.remove(v);
    			for(Vertex<L> v1:vertices) {
    				if(v1.getTargets().containsKey(vertex)) {
    					v1.getTargets().remove(vertex);
    				}
    			}
    		}
    	}
    	return flag;
    }
    
    @Override public Set<L> vertices() {
        //throw new RuntimeException("not implemented");
    	Set<L> vs=new HashSet<>();
    	for(Vertex<L> v:vertices) {
    		vs.add((L) v.getVertex());
    	}
    	return vs;
    }
    
    @Override public Map<L, Integer> sources(L target) {
        //throw new RuntimeException("not implemented");
    	HashMap<L, Integer> sourcemap=new HashMap<>();
    	for(Vertex<L> v:vertices) {
    		if(v.getTargets().containsKey(target)) {
    			sourcemap.put((L) v.getVertex(), (Integer)v.getTargets().get(target));
    		}
    	}
    	return sourcemap;
    }
    
    @Override public Map<L, Integer> targets(L source) {
        //throw new RuntimeException("not implemented");
    	for(Vertex<L> v:vertices) {
    		if(v.getVertex().equals(source)) {
    			return v.getTargets();
    		}
    	}
    	return new HashMap<>();
    }
    
    //  toString()
    @Override public String toString() {
    	StringBuilder sb=new StringBuilder();
    	for(Vertex<L> v:vertices) {
    		sb.append(v.toString());
    		sb.append("\r\n");
    	}
    	return sb.toString();
    }
}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Vertex<L> {
    
    // TODO fields
    private final L vertex;
    //private final HashMap<String, Integer> sources;
    private final HashMap<L, Integer> targets;
    // Abstraction function:
    //   represent the vertex with associated targets(weight)
    // Representation invariant:
    //   vertex is not null
    //   tar    
    // Safety from rep exposure:
    //   vertex is immutable 
    // sources and targets are mutable types,so defensive copy is made in the costructor;
    //all fields are private and final
    
    //  constructor
    public Vertex(L vertex,HashMap<L,Integer> targets) {
    	this.vertex=vertex;
    	//this.sources=new HashMap<>(sources);
    	this.targets=new HashMap<>(targets);
    	checkRep();
    }
    //  checkRep
    private void checkRep() {
    	assert vertex!=null;

    	for(L key:targets.keySet()) {
    		assert key!=null;
    		assert targets.get(key)!=null;
    	}
    	
    }
    // TODO methods

    public L getVertex() {
    	return vertex;
    }
    
    //public HashMap<String, Integer> getSources(){
    	
    //}
    public HashMap<L, Integer> getTargets(){
    		HashMap<L, Integer> returnTargets= new HashMap<>(targets);
    		return returnTargets;
    }
    

    //public void updateSources(String source,Integer weight) {
    	
    //}
    /*target is not null*/
    public void updateTargets(L target,Integer weight) {
    	if(weight==0) {
    		if(targets.containsKey(target)) {
    			targets.remove(target);
    		}
    	}else {
    		targets.put(target, weight);
    	}
    	checkRep();
    }

    //  toString()
    @Override public String toString() {
    	StringBuilder sb= new StringBuilder();
    	sb.append(vertex);
    	sb.append(",");
    	sb.append(targets);
    	return sb.toString();
    }
    
}
