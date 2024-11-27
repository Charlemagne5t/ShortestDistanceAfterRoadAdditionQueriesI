import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        List<List<Integer>> g = new ArrayList<>();
        int[] fromStart = new int[n];
        for(int i = 0; i < n; i++){
            fromStart[i] = i;
        }
        for(int i = 0; i < n - 1; i++) {
            g.add(new ArrayList<>());
            g.get(i).add(i + 1);
        }
        g.add(new ArrayList<>());
        for(int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            g.get(from).add(to);
            res[i] = bfs(g, fromStart);
        }

        return res;
    }
    int bfs(List<List<Integer>> g, int[] fromStart) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = g.size();
        q.add(0);
        int steps  = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                List<Integer> nei = g.get(cur);
                for(int ne : nei){
                    if(ne == n - 1) {
                        return steps + 1;
                    }
                    if(fromStart[ne] < steps + 1){
                        continue;
                    }
                    fromStart[ne] = steps + 1;
                    q.offer(ne);
                }
            }
            steps++;
        }
        return - 1;
    }
}