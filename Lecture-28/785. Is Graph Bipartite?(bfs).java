class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int n=graph.length;
        Integer color[] = new Integer[n];
        
        
        for(int i=0;i<n;i++){
            //node is unvisited
            if(color[i]==null && !bfs(i,color,graph,q,0)) return false;
        }
        
        return true;
    }
    boolean bfs(int st,Integer color[],int graph[][],Queue<Integer> q,int col){
        
        //add starting node
        q.add(st);
        
        
        while(!q.isEmpty()){
            
            //for current level all node color must be same
            int size=q.size();
            for(int i=0;i<size;i++){
                int pop = q.remove();
                
                //color fill
                color[pop]=col;
                
                //traverse nbr
                for(int nbr:graph[pop]){
                    
                    //unvisited nbr
                    if(color[nbr]==null)    q.add(nbr);
                    
                    //visited nbr and have the same color as it has
                    else if(color[nbr]==col)    return false;
                }
            }
            
            //change color for next level
            col=1-col;
        }
        return true;
    }
}
