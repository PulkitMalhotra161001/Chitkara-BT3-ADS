class Solution {
    
    public boolean placeWordInCrossword(char[][] board, String word) {
        int n=board.length, m=board[0].length, wn=word.length();

        //iterate in the board
        for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
        
                //check if character and space present only then go to inside if
				if(board[i][j]!='#') {
                
                    //before going check if it is a valid start
                    
                    if( validEnd(board,i+1,j,n,m) && canPut(board,word,0,wn,i,j,n,m,'U') )
                        return true;
                    if( validEnd(board,i-1,j,n,m) && canPut(board,word,0,wn,i,j,n,m,'D') ) 
                        return true;
                    if( validEnd(board,i,j+1,n,m) && canPut(board,word,0,wn,i,j,n,m,'L') ) 
                        return true;
                    if( validEnd(board,i,j-1,n,m) && canPut(board,word,0,wn,i,j,n,m,'R') )  
                        return true;
				}
			}
		}
        
        //there is no such place where we can put this word in the grid
        return false;
    }
    
    boolean canPut(char[][] a,String word,int wi,int wn,int i,int j,int n,int m,char dir) {
        //put all char
        if(wi==wn){
            return validEnd(a,i,j,n,m);
        }
        
        if(!valid(a,i,j,n,m,word,wi))   return false;
        
        int ni,nj;
        if(dir=='L'){
            ni=i;
            nj=j-1;
        }else if(dir=='R'){
            ni=i;
            nj=j+1;
        }else if(dir=='U'){
            ni=i-1;
            nj=j;
        }else{
            ni=i+1;
            nj=j;
        }
        
        char temp = a[i][j];
        
        a[i][j]=word.charAt(wi);
        
        if(canPut(a,word,wi+1,wn,ni,nj,n,m,dir))    return true;
        
        a[i][j]=temp;
        
        return false;
    }
    
    boolean valid(char a[][],int i,int j,int n,int m,String str,int si){
        if(i<0 || i>=n) return false;
        if(j<0 || j>=m) return false;
        return a[i][j]==' ' || a[i][j]==str.charAt(si);
    }
    
    boolean validEnd(char a[][],int i,int j,int n,int m){
        if(i<0 || i>=n) return true;
        if(j<0 || j>=m) return true;
        //ending pos
        return a[i][j]=='#';
    }
}
