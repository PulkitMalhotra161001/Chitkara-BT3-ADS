// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        int a[][] = {
            {6,1,0,0,4,0,7,0,0},
            {0,0,0,0,5,0,9,0,0},
            {2,0,0,0,0,6,5,0,8},
            {4,0,0,9,0,0,0,6,0},
            {0,0,0,0,0,0,0,0,0},
            {0,7,0,0,0,5,0,0,3},
            {1,0,8,7,0,0,0,0,9},
            {0,0,6,0,2,0,0,0,0},
            {0,0,3,0,9,0,0,8,1}
        };
        boolean ans = solve(a);
    }
    static boolean solve(int a[][]){
        return sudokuSolver(0,0,a);
    }
    static void print(int a[][]){
        for(int i[]:a){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static boolean sudokuSolver(int i,int j,int a[][]){
        if(i==9){
            print(a);
            return true;
        }
        
        int ni, nj;
        
        if(j==8){
            ni=i+1;
            nj=0;
        }else{
            ni=i;
            nj=j+1;
        }
        
        //empty
        if(a[i][j]==0){
            for(int val=1;val<=9;val++){
                if(isSafe(i,j,a,val)){
                    a[i][j]=val;
                    if(sudokuSolver(ni,nj,a)){
                        return true;
                    }
                    //backtracking
                    a[i][j]=0;
                }
            }
        }else{
            return sudokuSolver(ni,nj,a);
        }
        
        return false;
    }
    
    static boolean isSafe(int i,int j,int a[][],int val){
        //row wise
        for(int k=0;k<9;k++){
            if(a[i][k]==val)    return false;
        }
        
        //column wise
        for(int k=0;k<9;k++){
            if(a[k][j]==val)    return false;
        }
        
        //grid wise
        int grid_si = (i/3)*3;
        int grid_sj = (j/3)*3;
        
        for(int p=0;p<3;p++){
            for(int q=0;q<3;q++){
                if( a[grid_si+p][grid_sj+q] ==val)   return false;
            }
        }
        
        return true;
    }
}
