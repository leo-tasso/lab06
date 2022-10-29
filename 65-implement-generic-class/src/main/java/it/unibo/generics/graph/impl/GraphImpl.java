package it.unibo.generics.graph.impl;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    /**
     *
     */
    final protected Map<N, Set<N>> g;

    public GraphImpl() {
        g = new HashMap<>();
    }

    @Override
    public void addNode(N node) {
        g.putIfAbsent(node, new HashSet<N>());
    }

    @Override
    public void addEdge(N source, N target) {
        g.get(source).add(target); // not sure if works, seems like it does
    }

    @Override
    public Set<N> nodeSet() {
        return g.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return g.get(node);
    }
    // BFS->

    @Override
    public List<N> getPath(N source, N target) {
        final Map<N, N> father = new HashMap<>();
        final Map<N, Integer> color = new HashMap<>();

        for (N node : g.keySet()) {
            father.put(node, null);
            color.put(node, 1); // 1 white, 2 gray, 3 black
        }

        color.put(source, 2);
        final Deque<N> toExploreQueue = new LinkedList<N>();
        toExploreQueue.addLast(source);

        while (!toExploreQueue.isEmpty()) {
            final N nToExplore = toExploreQueue.pollFirst();
            for (N son : g.get(nToExplore)) {
                if (color.get(son) == 1) {
                    father.put(son, nToExplore);
                    toExploreQueue.addLast(son);
                }
            }
            color.put(nToExplore, 3);
        }
        return returnList(target, father);
    }

    @SuppressWarnings("unchecked")
    protected List<N> returnList(N target, Map<N, N> father) {
        Deque<N> result = new LinkedList<>();
        N cursor = (target);
        while (cursor != null) {
            result.addFirst(cursor);
            cursor = father.get(cursor);

        }
        return (List<N>) result;
    }
}