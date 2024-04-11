class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int id = bs(0,list.size()-1,num);
        if(id==list.size()){
            list.add(num);
        }else{
            list.add(id,num);
        }
    }
    
    int bs(int i,int j,int t){
        while(i<=j){
            int mid=(i+j)/2;
            if(list.get(mid)==t){
                return mid;
            }
            else if(t<list.get(mid)){
                return bs(i,mid-1,t);
            }
            else{
                return bs(mid+1,j,t);
            }
        }
        return i;
    }
    
    //O(1)
    public double findMedian() {
        int size = list.size();
        if(size%2==0){
            int first = size/2;
            int second = first-1;
            return (list.get(first) + list.get(second) )/2.0;
        }
        return list.get(size/2);
    }
}

__________________________________________________________________________________________________________________________
// Optimized




class MedianFinder {
    //min_pq represent right hand side
    //max_pq represent left hand side
    
    //from left hand side we want higher value (max_pq)
    //from right hand side we want lower value (min_pq)
    
    PriorityQueue<Integer> min, max;
    public MedianFinder() {
        //default
        min = new PriorityQueue();
        //max_converter using reverse_ordering
        max = new PriorityQueue(Collections.reverseOrder());
    }
    
    //O(1)
    public void addNum(int num) {
        if(min.size()==0 || num>min.peek()){
            min.add(num);
        }else{
            max.add(num);
        }
        
        //size balance out
        if(min.size()-max.size()>1){
            max.add( min.remove() );
        }
        
        if(max.size()-min.size()>1){
            min.add( max.remove() );
        }
        
        
    }
    
    //O(1)
    public double findMedian() {
        
        //total_size if odd and min contains an extra value
        if(min.size()>max.size())   return min.peek();
        
        //total_size if odd and max contains an extra value
        if(max.size()>min.size())   return max.peek();
        
        
        //size is even
        return ( max.peek() + min.peek() )/2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */;
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
