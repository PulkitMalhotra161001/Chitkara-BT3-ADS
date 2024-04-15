//HomeWork

class MyHashMap<K,V> {
    List<Node> arr[];
    int size;
    public MyHashMap() {
        design(16);
        size=0;
    }
    
    public void put(K key, V value) {
        int code = hashCode(key);
        int id = findIndex(arr[code],key);
        
        if(id==-1){
            Node node = new Node(key,value);
            arr[code].add(node);
            size++;
        }else{
            arr[code].get(id).value = value;
        }
        
        if( thresholdReached() ){
            reHash();
        }
    }
    
    public int get(K key) {
        int code = hashCode(key);
        int id = findIndex(arr[code],key);
        return id==-1?id:(int)arr[code].get(id).value;
    }
    
    public void remove(K key) {
        int code = hashCode(key);
        int id = findIndex(arr[code],key);
        if(id!=-1){
            arr[code].remove(id);
            size--;
        }
    }
    
    void reHash(){
        size=0;
        List<Node> old[] = arr;
        design(2*arr.length);
        
        for(List<Node> list:old){
            for(Node node:list){
                int code = hashCode(node.key);
                arr[code].add(node);
            }
        }
    }
    
    boolean thresholdReached(){
        return (size*1.0/arr.length)>0.75;
    }
    
    int findIndex(List<Node> list,K k){
        int ans=0;
        for(Node i:list){
            if(i.key.equals(k))    return ans;
            ans++;
        }
        return -1;
    }
    
    int hashCode(K key){
        // return Math.abs( key.hashCode() ) % arr.length;
        return Math.abs( key.hashCode() ) % arr.length ;
    }
    
    void design(int cap){
        arr=new LinkedList[cap];
        for(int i=0;i<cap;i++){
            arr[i]=new LinkedList<>();
        }
    }
    
    class Node{
        K key;
        V value;
        Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
