class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean [] visited = new boolean[n];
        int component = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                component++;
                dfs(i, visited, adj);
            }
        }      
        return component; 

    }

    private static void dfs(int start, boolean [] visited, List<List<Integer>> adj){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    queue.offer(neigh);
                }
            }
        }
    }
}
