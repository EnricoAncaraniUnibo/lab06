package it.unibo.generics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<T> implements Graph<T>{
    private final Map<T, Set<T>> m;
    private final BiFunction<T,T,List<T>> strategy;

    public GraphImpl(final BiFunction<T,T,List<T>> strat) {
        m = new HashMap<>();
        this.strategy = strat;
    }

    @Override
    public void addNode(T node) {
        if(node != null && !m.containsKey(node)) {
            m.put(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(T source, T target) {
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
    public Set<T> nodeSet() {
        return m.keySet();
    }

    @Override
    public Set<T> linkedNodes(T node) {
        return m.get(node);
    }

    @Override
    public List<T> getPath(T source, T target) {
        return this.calculatePath(source, target);
    }

    private List<T> calculatePath(T source, T target) {
        return strategy.apply(source, target);
    }
    
}
