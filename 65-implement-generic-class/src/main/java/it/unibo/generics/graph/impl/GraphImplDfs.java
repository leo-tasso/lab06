package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImplDfs<N> extends GraphImpl<N> {
    @Override
    public List<N> getPath(N source, N target) {
        final Map<N, N> father = new HashMap<>();
        final Map<N, Integer> color = new HashMap<>();
        for (N node : g.keySet()) {
            father.put(node, null);
            color.put(node, 1); // 1 white, 2 gray, 3 black
        }
        dfsVisit(source, father, color);
        return returnList(target, father);
    }

    private void dfsVisit(N node, Map<N, N> father, Map<N, Integer> color) {
        color.put(node, 2);
        for (N adj : g.get(node)) {
            if (color.get(adj) == 1) {
                father.put(adj, node);
                dfsVisit(adj, father, color);
            }
        }
        color.put(node, 3);
    }
    
}
