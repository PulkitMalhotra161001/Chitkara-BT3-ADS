class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> ans= new ArrayList<>();
        sol(board,0,ans);
        return ans;
    }
    public void sol(char board[][],int row,List<List<String>> ans){
        if(row==board.length){
            ans.add(string(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                sol(board,row+1,ans);
                board[row][col]='.';
            }

        }
    }
    public List<String> string(char board[][]){
        List<String> inter=new ArrayList<>();
       
        for(int i=0;i<board.length;i++){
            String row = new String(board[i]);
            inter.add(row);
        }
        return inter;
    }
    public boolean isSafe(char[][] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') 
            {return false;
            }
        }
        int leftmax=Math.min(row,col);
        for(int i=1;i<=leftmax;i++){
            if(board[row-i][col-i]=='Q'){
                return false;
            }
        }
        int rightmax=Math.min(board.length-1-col,row);
        for(int i=1;i<=rightmax;i++){
            if(board[row-i][col+i]=='Q'){
                return false;
            }
        }
        return true;
    }
}
