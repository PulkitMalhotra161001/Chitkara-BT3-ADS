// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int n = 5;
        using_adj_list(n);
        // using_adj_matrix(n);
    }
    static void using_adj_matrix(int n){
        int a[][] = new int[n][n];
        
        a[0][2] = 4;
        a[2][0] = 4;
        
        a[1][0] = 5;
        a[0][1] = 5;
        
        a[2][3] = 8;
        a[3][2] = 8;
        
        
        a[2][4] = 73;
        a[4][2] = 73;
        
        a[3][1] = 25;
        a[1][3] = 25;
        
        
        for(int i[]:a){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static class Node{
        int dst;
        int wgt;
        Node(int dst,int wgt){
            this.dst = dst;
            this.wgt = wgt;
        }
    }
    static void using_adj_list(int n){
        // List<List<Integer[]>> list = new ArrayList<>();
        // List<Set<Node>> list = new ArrayList<>();
        // int arr[] = new int[n];
        List<Integer> arr[] = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            arr[i] = new ArrayList<Integer>();
            // list.add(new HashSet<>());
        }
        
        // list.get(0).add(new Integer[]{2,5});
        // list.get(0).add(Arrays.asList(2,5));
        // list.get(0).add(new Node(2,5));
        arr[0].add(2);
        
        arr[1].add(0);
        
        arr[2].add(3);
        arr[2].add(4);
        arr[3].add(1);
        
        
        // for(int i=0;i<list.size();i++){
        //     System.out.println(i+" is connected with");
        //     Set<Node> nbr = list.get(i);
            
        //     // for(int j=0;j<nbr.size();j++){
        //     for(Node node:nbr){
        //         // Node node = nbr.get(j);
        //         System.out.println(node.dst+" with weight "+node.wgt);
        //     }
        //     System.out.println();
        // }
        
        for(List<Integer> list:arr){
            System.out.println(list);
        }
    }
}
