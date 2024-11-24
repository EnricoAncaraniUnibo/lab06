package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.Strategy;

public class StrategyBfs<T> implements Strategy<T>{
    Queue<T> q = new LinkedList<>(); //ordine di nodi da guardare
    Map<T, List<T>> m = new HashMap<>(); //per ogni nodo salvo i suoi precedenti nel percorso

    @Override
    public List<T> apply(T source, T target, List<T> tmpResult, List<T> visited, Graph<T> graph) {
        tmpResult.add(source);
        if(source == target) {
            return tmpResult;
        }
        visited.add(source);
        m.put(source, tmpResult);
        for (T elem : graph.linkedNodes(source)) {
            m.put(elem, new ArrayList<>(tmpResult));
            m.get(elem).add(elem);
        }
        q.addAll(graph.linkedNodes(source));
        while(!q.isEmpty()) {
            T var = q.poll();
            if(!visited.contains(var)) {
                tmpResult = m.get(var);
                if(var == target) {
                    return tmpResult;
                }
                visited.add(var);
                for (T elem : graph.linkedNodes(var)) {
                    m.put(elem, new ArrayList<>(tmpResult));
                    m.get(elem).add(elem);
                }
                q.addAll(graph.linkedNodes(var));
            }
        }
        return null;
    }
}
