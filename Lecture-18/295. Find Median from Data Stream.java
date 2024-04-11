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

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
