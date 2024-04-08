class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        long first=0, second=0;
        char a[] = num.toCharArray();
        if(n<3) return false;
        
        //can't have leading zero but one value can be zero
        if(a[0]=='0'){
            //can't have leading zero but one value can be zero
            if(a[1]=='0'){
                if(checkSeq(first,second,2,n,num))    return true;
            }else{
                for(int j=1;j<=n-2;j++){

                    second = second*10 + (a[j]-'0');

                    // System.out.println(first+" "+second);

                    if( checkSeq(first,second,j+1,n,num) )    return true;

                }
            }
        }else{
        
            for(int i=0;i<=n-3;i++){

                first = first*10 + (a[i]-'0');
                second= 0;

                //can't have leading zero but one value can be zero
                if(a[i+1]=='0'){
                    if(checkSeq(first,second,i+2,n,num))    return true;
                }else{
                    for(int j=i+1;j<=n-2;j++){

                        second = second*10 + (a[j]-'0');

                        // System.out.println(first+" "+second);

                        if( checkSeq(first,second,j+1,n,num) )    return true;

                    }
                }
            }
        }
        
        return false;
    }
    
    boolean checkSeq(long a,long b,int i,int n,String s){
        if(i==n)    return true;
        long sum = a+b;
        String temp = Long.toString(sum);
        
        if(i+temp.length()>n || !temp.equals(s.substring(i,i+temp.length())))   
            return false;
        return checkSeq(b,sum,i+temp.length(),n,s);
    }
}
