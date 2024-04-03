
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)  return ans;
        
        //maintain a queue for traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        
        while(!q.isEmpty()){
            
            //find nodes in the current level
            int size = q.size();
            List<Integer> temp=new ArrayList<>();
            
            //traverse till the current level nodes
            for(int i=0;i<size;i++){
                
                
                TreeNode pop = q.remove();
                temp.add(pop.val);
                
                //if there is a left child the add for next level
                if(pop.left!=null)  q.add(pop.left);
                
                //if there is a right child the add for next level
                if(pop.right!=null)  q.add(pop.right);
            }
            
            //add all nodes from the current level in the final list
            ans.add(temp);
        }
        return ans;
    }
}
