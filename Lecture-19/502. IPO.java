class Solution {
    class Work{
        int price;
        int value;
        Work(int p,int v){
            price = p;
            value = v;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length, i=0;
        Work a[] = new Work[n];
        for(;i<n;i++){
            a[i] = new Work(capital[i],profits[i]);
        }
        Arrays.sort(a,(o1,o2)->o1.price-o2.price);
        PriorityQueue<Work> pq = new PriorityQueue<>((o1,o2)->o2.value-o1.value);
        i=0;
        while(k>0){
            while(i<n && a[i].price<=w){
                pq.add(a[i]);
                i++;
            }
            
            //can't do any work
            if(pq.size()==0)    break;
            
            w+=pq.remove().value;
            k--;
        }
        
        return w;
    }
}
