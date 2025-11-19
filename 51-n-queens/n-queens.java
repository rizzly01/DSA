class Solution {

    public boolean issafe(int row,int col,char[][] board)
    {
        for(int j=0;j<board.length;j++)
        {
            if(board[row][j]=='Q')
            {
                return false;
            }
        }

         for(int i=0;i<board.length;i++)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }

        int r=row;
         for(int c=col;c>=0 && r>=0;c--,r--)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
        }

         r=row;
         for(int c=col;c<board.length && r>=0;c++,r--)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
        }

         r=row;
         for(int c=col;c<board.length && r<board.length;c++,r++)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
        }

         r=row;
         for(int c=col;c>=0 && r<board.length;c--,r++)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
        }
        return true;


    }

    public void saveboard(List<List<String>> allboards,char[][] board)
    {
        String row="";
        List<String> newboard=new ArrayList<>();

        for(int i=0;i<board.length;i++)
        {
            row="";
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='Q')
                {
                    row+='Q';
                }

                else
                {
                    row+='.';
                }
            }

            newboard.add(row);
        }
        allboards.add(newboard);

    }

    public void helper(List<List<String>> allboards,char[][] board,int col)
    {
        if(col==board.length)
        {  
            saveboard(allboards, board);
             return;
        }

        for(int row=0;row<board.length;row++)
        {
            if(issafe(row,col,board))
            {

                 board[row][col]='Q';
            helper(allboards,board,col+1);
            board[row][col]='.';

            }
           

        }

        
    }



    public List<List<String>> solveNQueens(int n) {

        List<List<String>> allboards=new ArrayList<>();
        char[][] board=new char[n][n];
        helper(allboards,board,0);
        return allboards;
        
    }
}