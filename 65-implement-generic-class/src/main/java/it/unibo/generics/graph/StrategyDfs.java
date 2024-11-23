package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.List;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.Strategy;

public class StrategyDfs<T> implements Strategy<T>{

    List<T> ls = new ArrayList<>();

    @Override
    public List<T> apply(T source, T target, List<T> tmpResult, List<T> visited, Graph<T> graph) {
        visited.add(source);
        tmpResult.add(source);
        for (T elem : graph.linkedNodes(source)) {
            if(elem == target) {
                tmpResult.add(elem);
                return tmpResult;
            }
            if(!visited.contains(elem)) {
                ls=apply(elem, target, tmpResult, visited, graph);
                if(ls != null) {
                    return ls;
                }
            }
        }
        return null;
    }
    
}
