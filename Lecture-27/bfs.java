// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int n=6;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        
        list.get(0).add(1);
        
        list.get(1).add(0);
        list.get(1).add(2);

        list.get(2).add(1);
        list.get(2).add(3);
        list.get(2).add(4);
        
        list.get(3).add(2);
        list.get(3).add(4);
        
        list.get(4).add(2);
        list.get(4).add(3);
        list.get(4).add(5);
        
        list.get(5).add(4);
        
        
        
        
        bfs(list,n,0);
    }
    static void bfs(List<List<Integer>> list,int n,int st){
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        vis[st]=true;
        
        while(!q.isEmpty()){
            Integer pop = q.remove();
            System.out.println(pop);
            
            for(Integer nbr:list.get(pop)){
                if(!vis[nbr]){
                    vis[nbr]=true;
                    q.add(nbr);
                }
            }
        }
    }
}
