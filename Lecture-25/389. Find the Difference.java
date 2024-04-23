class Solution {
    public char findTheDifference(String s, String t) {

        int x=0;
        for(char i:t.toCharArray()){
            int temp = (i-'a');
            x=x^temp;
        }
        
        for(char i:s.toCharArray()){
            int temp = (i-'a');
            x=x^temp;
        }
        
        return (char)('a'+x);
    }
}
