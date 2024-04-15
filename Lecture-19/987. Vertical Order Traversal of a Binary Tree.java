/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //c -> r -> list
    TreeMap<Integer,TreeMap<Integer,List<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        solve(0,0,root);
        
        
        List<List<Integer>> ans = new ArrayList<>();
        
        // System.out.println(map);
        
        for(Integer c:map.keySet()){
            List<Integer> col = new ArrayList<>();
            for(Integer r:map.get(c).keySet()){
                List<Integer> temp = map.get(c).get(r);
                Collections.sort(temp);
                
                //adding current col nodes
                col.addAll(temp);
            }
            
            //add current col in ans
            ans.add(col);
        }
        
        return ans;
    }
    void solve(int r,int c,TreeNode node){
        if(node==null)  return;
        
        if(!map.containsKey(c)){
            map.put(c,new TreeMap<>());
        }
        
        if(!map.get(c).containsKey(r)){
            map.get(c).put(r,new LinkedList<>());
        }
        
        map.get(c).get(r).add(node.val);
        
        solve(r+1,c-1,node.left);
        solve(r+1,c+1,node.right);
    }
}
