class HelloWorld {
    boolean maze(boolean a[][]){
        int n=a.length, m=a[0].length;
        return solve(0,0,n,m,a);
    }
    //U D L R
    int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    boolean solve(int cur_row,int cur_col,
    int n,int m,boolean a[]){
        
        //check whether given index is valid or not
        //we can check valid index in the base case(before hand) or before making the recursive calls
        // if(!valid(cur_row,cur_col,n,m,a)){
        //     return false;
        // }
        
        
        //we have reached the destination
        if(cur_row==n-1 && cur_col==m-1){
            return true;
        }
        
        //we have to mark false
        //so that we will not move here
        a[cur_row][cur_col]=false;
        
        
        //move to other directions
        for(int i=0;i<dir.length;i++)
            //-1,0 => up
            //1,0 => down
            //0,-1 => left
            //0,1 => right
            int add_row = dir[i][0];
            int add_col = dir[i][1];
            int new_row = cur_row + add_row;
            int new_col = cur_col + add_col;
            
            //we can check valid index in the base case(before hand) or before making the recursive calls
            boolean canMove = valid(new_row,new_col,n,m,a);
            if(canMove){
                boolean ans = solve( new_row,new_col,n,m,a );
                if(ans){
                    return true;
                }
            }
            
        }
        
        return false;
        
    }
    boolean valid(int i,int j,int n,int m,boolean a[][]){
        //upper side outside the boundry 
        if(i<0) return false;
        //left side outside the boundry 
        if(j<0) return false;
        //down side outside the boundry 
        if(i>=n)    return false;
        //right side outside the boundry 
        if(j>=m)    return false;

        //stone
        if(a[i][j]==false) return false;

        return true;
    }
}
