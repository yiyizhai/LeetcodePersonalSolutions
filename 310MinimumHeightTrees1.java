public class Solution {
    //each node as the tree root, calculate the maxmum depth of the tree
    //put <depth, list of node> pair in hashmap
    //use a variable to record the minimum maxDepth
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 2){
            List<Integer> result = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                result.add(i);
            }
            return result;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int min = Integer.MAX_VALUE;
        
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        buildGraph(n, edges, graph, indegree);
        
        return helper(n, graph, indegree);
    }
    
    private List<Integer> helper(int n, Map<Integer, List<Integer>> graph, Map<Integer, Integer> indegree){
        //List<Integer> result = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        List<Integer> leaves = new LinkedList<Integer>();
        for(int k : indegree.keySet()){
            if(indegree.get(k) == 1){
                leaves.add(k);
            }
        }
        
       while(n > 2){
           n = n - leaves.size();
           List<Integer> newLeaves = new LinkedList<Integer>();
           
           while(!leaves.isEmpty()){
               int leaf = leaves.remove(0);
               visited.add(leaf);
               
               for(int neighbor : graph.get(leaf)){
                   if(visited.contains(neighbor)){
                       continue;
                   }
                   
                   int degree = indegree.get(neighbor);
                   indegree.put(neighbor, degree - 1);
                   if(degree == 2){
                       newLeaves.add(neighbor);
                   }
               }
           }
           leaves = newLeaves;
       }
       return leaves;
    }
    
    private void buildGraph(int n, int[][] edges, Map<Integer, List<Integer>> graph, Map<Integer, Integer> indegrees){
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<Integer>());
            indegrees.put(i, 0);
        }
        
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            
            graph.get(from).add(to);
            graph.get(to).add(from);
            indegrees.put(from, indegrees.get(from) + 1);
            indegrees.put(to, indegrees.get(to) + 1);
        }
    }
}
