package it.unibo.generics.graph.api;

import java.util.List;

public interface Strategy<T> {
    public List<T> apply(T source, T target, List<T> tmpResult, List<T> visited, Graph<T> graph);
}
