class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i:nums) trie.add(i);
        
        // trie.print();
        
        int ans=0;
        for(int i:nums){
            int val = trie.find(~i);
            // System.out.println(i+" "+val);
            ans = Math.max(ans, i^val);
        }
        
        return ans;
    }
    
    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
        void add(int x){
            Node cur = root;
            
            for(int i=30;i>=0;i--){
                // if( (1<<i) > x) return;
                //bit set : move to right side
                if( (x&(1<<i)) >0 ){
                    if(cur.right==null) cur.right = new Node();
                    
                    cur = cur.right;
                }else{
                    if(cur.left==null)  cur.left = new Node();
                    
                    cur = cur.left;
                }
            }
            
        }
        
        void print(){
            Node cur = root;
            rec(cur,"");
        }
        
        void rec(Node cur,String s){
            if(cur==null)   return;
            if(cur.left==null && cur.right==null){
                System.out.println(s);
                return;
            }
            rec(cur.left,s+"0");
            rec(cur.right,s+"1");
        }
        
        int find(int x){
            Node cur = root;
            int ans=0;
            
            for(int i=30;i>=0;i--){
                
                boolean set = false;
                
                //bit set : move to right side
                if( (x&(1<<i)) >0 ){
                    
                    //but right is not there
                    if(cur.right==null){
                        cur = cur.left;
                    }
                    else{
                        ans|=(1<<i);
                        cur = cur.right;
                        set=true;
                    }
                }else{
                    
                    //but left is not there
                    if(cur.left==null){
                        ans|=(1<<i);
                        cur = cur.right;
                        set=true;
                    }else{
                        cur = cur.left;
                    }
                }
                
            }
            
            return ans;
        }
    }
    class Node{
        Node left,right;
        Node(){
            left=null;
            right=null;
        }
    }
}
