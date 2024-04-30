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
        
        
        
        
        boolean vis[] = new boolean[n];
        dfs(list,vis,n,0);
    }
    static void dfs(List<List<Integer>> list,boolean vis[],int n,int cur){
        
        vis[cur] = true;
        System.out.println(cur);
        
        for(Integer nbr:list.get(cur)){
            if(!vis[nbr]){
                dfs(list,vis,n,nbr);
            }
        }
    }
}
