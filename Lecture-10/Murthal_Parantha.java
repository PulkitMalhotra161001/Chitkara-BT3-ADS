import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int ans = find(p,a,n);
        System.out.println(ans);
    }
    static int find(int p,int a[],int n){
        if(p==0)    return 0;

        int l=0, r=Integer.MAX_VALUE;
        while(l<r){
            int mid = l+(r-l)/2;
            boolean possible = parathaMade(a,mid,p);
            // System.out.println(mid+" => "+possible);
            if(possible){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    static boolean parathaMade(int a[],int time,int p){
        for(int i:a){
            
            long cur=i, total=cur;
            while(total<=time){
                cur=cur+i;
                total+=cur;
                p--;
                if(p==0)    return true;
            }

        }

        return false;
    }
}
