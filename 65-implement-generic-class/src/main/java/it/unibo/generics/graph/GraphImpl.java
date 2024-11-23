package it.unibo.generics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl implements Graph<Object>{
    Map<Object, Set<Object>> m;

    public GraphImpl() {
        m = new HashMap<>();
    }

    @Override
    public void addNode(Object node) {
        if(node != null && !m.containsKey(node)) {
            m.put(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(Object source, Object target) {
        if(source != null && target != null) {
            m.get(source).add(target);
            if(m.containsKey(target)) {
                m.get(target).add(source);
            } else {
                m.put(target, new HashSet<>());
                m.get(target).add(source);
            }
        }
    }

    @Override
    public Set<Object> nodeSet() {
        return m.keySet();
    }

    @Override
    public Set<Object> linkedNodes(Object node) {
        return m.get(node);
    }

    @Override
    public List<Object> getPath(Object source, Object target) {
        
    }
    
}
