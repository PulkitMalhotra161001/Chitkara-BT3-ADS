//First Approach
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> fMap = new HashMap<>();
        for( char c : s.toCharArray()){
            fMap.put(c, fMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> fMap.get(b) - fMap.get(a));
        maxHeap.addAll(fMap.keySet());

        StringBuilder sortedString = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int frequency = fMap.get(c);
            for (int i = 0; i < frequency; i++) {
                sortedString.append(c);
            }
        }
        
        return sortedString.toString();

//2ND Approach
char[] str = s.toCharArray();
        int[] freq = new int[128];
        
        for (char c : str) {
            freq[c]++;
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq[b] - freq[a]);
        
        for (int i = 0; i < 128; i++) {
            if (freq[i] != 0) {
                pq.offer((char) i);
            }
        }
        
        StringBuilder sortedString = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < freq[c]; i++) {
                sortedString.append(c);
            }
        }
        
        return sortedString.toString(); 
    }
}
