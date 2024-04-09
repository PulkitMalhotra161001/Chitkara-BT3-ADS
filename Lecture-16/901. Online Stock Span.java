class node{
    int f;
    int sec;
    node(int f , int sec){
        this.f=f;
        this.sec=sec;
    }
}
class StockSpanner {
    Stack<node> s=new Stack<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        //System.out.println(s);
        int sp=1;
       
        while(!s.isEmpty() && s.peek().f <= price){
            sp=sp+s.peek().sec;
            s.pop();
        }
        s.push( new node(price , sp));
        return sp;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
