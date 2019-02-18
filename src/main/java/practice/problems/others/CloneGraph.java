package practice.problems.others;

import java.util.*;

/**
 * Created by yashraj on 2/14/19.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            map.put(n, new UndirectedGraphNode(n.label));
            for (UndirectedGraphNode negh:n.neighbors){
                if (!map.containsKey(negh)) {
                    queue.offer(negh);
                }
            }
        }
        queue.add(node);
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode top = queue.poll();
            for (UndirectedGraphNode n:top.neighbors){
                if (!set.contains(n)){
                    queue.offer(n);
                    set.add(n);
                }
                map.get(top).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    class UndirectedGraphNode {
        int label;
          List<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
         }
}
