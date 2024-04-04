class Solution {
    public Node connect(Node root) {
        Node level=root;
        while(level!=null && level.left!=null){
            Node temp=level;
            while(true){
                temp.left.next=temp.right;
                if(temp.next==null) break;
                temp.right.next=temp.next.left;
                temp=temp.next;
            }
            level=level.left;
        }
        return root;
    }
}
