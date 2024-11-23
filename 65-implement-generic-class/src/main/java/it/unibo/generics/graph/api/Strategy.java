package it.unibo.generics.graph.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Strategy<T> {
    public List<T> apply(T source, T target, List<T> tmpResult, List<T> visited, Graph<T> graph);
}
