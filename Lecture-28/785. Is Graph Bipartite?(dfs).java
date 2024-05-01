class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        for(int i=0 ; i<n ; i++){
            
            //unvisited
            if( color[i]==0 && !dfs(i,color,graph,1) )   return false;
        }
        return true;
    }
    boolean dfs(int i,int color[],int g[][],int now){
        
        //fill current color
        color[i]=now;
        
        //traverse nbr
        for(int nbr:g[i]){
            
            //is unvisited then visit
            if(color[nbr]==0 && !dfs(nbr,color,g,now==1?2:1))    return false;
            
            //visited and have same color as it has
            else if(color[nbr]==now)    return false; 
        }
        return true;
    }
}
