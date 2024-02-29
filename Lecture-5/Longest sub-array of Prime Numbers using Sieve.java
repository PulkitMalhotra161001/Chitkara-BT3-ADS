import java.util.*;
import java.io.*;

class HelloWorld {
    public static void main(String[] args) {
        // int a[] = { 1, 2, 4, 3, 29, 11, 7, 8, 9 };
        // int a[] = {3, 5, 2, 66, 7, 11, 8} ;
        int a[] = {2,2,2,2,2,2,2} ;
        int n = a.length;
        boolean primesElements[] = findPrime(a);
        boolean primeInA[] = markPrime(a,primesElements);
        // prime(a,primeInA);
        
        int longest_Prime_Sub_Array = kadane(primeInA);
        System.out.println(longest_Prime_Sub_Array);
    }
    static void prime(int a[],boolean primeInA[]){
        int n=a.length;
        for(int i=0;i<n;i++){
            System.out.println(a[i]+" "+primeInA[i]);
        }
    }
    static int kadane(boolean a[]){
        int cur=0, ans=0;
        for(boolean i:a){
            if(i)   cur++;
            else    cur=0;
            ans=Math.max(cur,ans);
        }
        return ans;
    }
    static boolean[] markPrime(int a[],boolean prime[]){
        int n = a.length;
        boolean ans[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(prime[a[i]]){
                ans[i]=true;
            }
        }
        return ans;
    }
    static boolean[] findPrime(int a[]){
        int high=Integer.MIN_VALUE;
        for(int i:a){
            high=Math.max(i,high);
        }
        boolean mark[] = new boolean[high+1];
        Arrays.fill(mark,true);
        mark[0]=false;
        mark[1]=false;
        
        
        for(int i=2;i<=high;i++){
            if(mark[i]){
                for(int j=2*i;j<=high;j+=i){
                    mark[j]=false;
                }
            }
        }
        
        return mark;
    }
}
