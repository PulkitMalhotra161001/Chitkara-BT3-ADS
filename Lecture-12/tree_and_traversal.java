import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.right = new Node(1);
        
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
    }
    
    static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.print(node.val+" ");
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
    }
    
    //NLR
    static void preOrder(Node node){
        if(node==null)  return;
        
        //node
        System.out.print(node.val+" ");
        
        //left
        preOrder(node.left);
        
        //right
        preOrder(node.right);
    }
    
    //LNR
    static void inOrder(Node node){
        if(node==null)  return;
        
        //left
        inOrder(node.left);
        
        //node
        System.out.print(node.val+" ");
        
        //right
        inOrder(node.right);
    }
    
    //LRN
    static void postOrder(Node node){
        if(node==null)  return;
        
        //left
        postOrder(node.left);
        
        //right
        postOrder(node.right);
        
        //node
        System.out.print(node.val+" ");
    }
    
    static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }
}
