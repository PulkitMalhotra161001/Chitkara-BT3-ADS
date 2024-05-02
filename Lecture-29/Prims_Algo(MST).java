//Prim's Algo
//take a random node (eg.0)
//add it's unvisited <node,weight> into PriorityQueue (pq)
//pq gave us minimum wgt node
//go to that node and repeat the process
//until all nodes becomes visited
//we have to take shortest weighted edge

class Solution
{
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // System.out.print(adj);
        // [[[1, 5], [2, 1]], [[0, 5], [2, 3]], [[1, 3], [0, 1]]]
        //0 connect with 1 with weight 5
        boolean vis[] = new boolean[adj.size()];
        //we have to visit node only one time
        PriorityQueue<List<Integer>> q=new PriorityQueue<>((o1,o2)->o1.get(1)-o2.get(1));
        q.add(Arrays.asList(new Integer[]{0,0}));
        //sort according to weight
        int ans=0;
        while(!q.isEmpty()){
            List<Integer> pop=q.remove();
            //if current node is visited then skip
            if(vis[pop.get(0)]) continue;
            //add weight to the ans and mark node
            ans+=pop.get(1);
            vis[pop.get(0)]=true;
            //travel it's neighbours
            for(ArrayList<Integer> nbr:adj.get(pop.get(0))){
                //take only unvisited neighbours
                //and add in the pq
                if(!vis[nbr.get(0)]){
                    q.add(Arrays.asList(new Integer[]{nbr.get(0),nbr.get(1)}));
                }
            }
        }
        return ans;
    }
}
