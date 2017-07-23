package class5;

import Util.GraphNode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangshuozang on 7/9/17.
 */
public class Bipartite {
    /**
     * public class GraphNode {
     *   public int key;
     *   public List<GraphNode> neighbors;
     *   public GraphNode(int key) {
     *     this.key = key;
     *     this.neighbors = new ArrayList<GraphNode>();
     *   }
     * }
     *      // 1. start state is node1
     // 2. Generation rule: expand i,j -- > i+1, j  i, j+1
     // 3. termination all nodes expanded or ..
     */
        public boolean isBipartite(List<GraphNode> graph) {
            if (graph == null) return true;
            // write your solution here
            HashSet<GraphNode> set1 = new HashSet<>();
            HashSet<GraphNode> set2 = new HashSet<>();
            for (GraphNode node : graph) {
                if (!BFS(node, set1, set2)) {
                    return false;
                }
            }
            return true;
        }
        private boolean BFS(GraphNode node, HashSet<GraphNode> set1, HashSet<GraphNode> set2) {
            Deque<GraphNode> list = new LinkedList<GraphNode>();
            list.add(node);
            while (!list.isEmpty()) {
                GraphNode cur = list.poll();
                if (!set1.contains(cur)) {
                    set1.add(cur);
                    for (GraphNode neighbor :cur.neighbors) {
                        list.add(neighbor);
                        if (set2.contains(neighbor)) {
                            return false;
                        }
                        set2.add(neighbor);
                    }
                } else if (!set2.contains(cur)) {
                    for (GraphNode neighbor :cur.neighbors) {
                        list.add(neighbor);
                        if (set1.contains(neighbor)) {
                            return false;
                        }
                        set2.add(neighbor);
                    }
                    set2.add(cur);
                } else {
                    return false;
                }
            }
            return true;
        }


}
