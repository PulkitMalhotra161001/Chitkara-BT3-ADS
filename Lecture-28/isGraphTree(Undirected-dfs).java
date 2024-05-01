// Approach 1. Connected and acyclic
// Approach 2. Connected and V-1 = E

class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());
        
        
        for(ArrayList<Integer> i : edges) {
            list.get(i.get(0)).add(i.get(1));
            list.get(i.get(1)).add(i.get(0));
        }
        
        //cycle means not a tree
        boolean visited[] = new boolean[n];
        if(cycle(list,-1,0,visited))   return false;
        
        //disconnected
        for(int i=0; i<n; i++){
            if(!visited[i]){
                return false;
            }
        }
        
        return true;
    }
    static boolean cycle(ArrayList<ArrayList<Integer>> list,int parent,int curr,boolean visited[]) {
        
        //mark curr node True
        visited[curr] = true;
        
        for(int i: list.get(curr)) {
            
            //since the graph is bidirectional so we have to avoid to visit parent again
            if(i == parent) continue;
            
            //if the current node is already visited that means cycle is present in the graph
            if(visited[i]) return true;
            
            // traverse for rest of the node
            if(cycle(list,curr,i,visited))    return true;
        }
        
        // if cycle is not detected in the graph that means the graph is also a tree
        return false;
    }
}
