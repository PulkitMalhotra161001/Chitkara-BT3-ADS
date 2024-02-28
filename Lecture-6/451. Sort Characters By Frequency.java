class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char i:s.toCharArray()){
            map.merge(i,1,Integer::sum);
        }
        
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1,o2)->map.get(o2) - map.get(o1) );

        StringBuilder sb = new StringBuilder();
        for(Character c:list){
            int count = map.get(c);
            
            // for(int i=0;i<count;i++){
            //     sb.append(c);
            // }
            sb.append(String.valueOf(c).repeat(count));
            // sb.append( (c+"").repeat(count) );
            
        }
        return sb.toString();

    }
}
