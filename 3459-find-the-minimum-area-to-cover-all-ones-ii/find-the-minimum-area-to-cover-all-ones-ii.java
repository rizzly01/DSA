class Solution {
    int m, n;
    int[][] grid;

    private int minArea(int r1, int r2, int c1, int c2) {
        int minR = Integer.MAX_VALUE, maxR = -1;
        int minC = Integer.MAX_VALUE, maxC = -1;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    if (i < minR) minR = i;
                    if (i > maxR) maxR = i;
                    if (j < minC) minC = j;
                    if (j > maxC) maxC = j;
                }
            }
        }
        if (maxR == -1) return 0; 
        return (maxR - minR + 1) * (maxC - minC + 1);
    }

    public int minimumSum(int[][] g) {
        grid = g;
        m = g.length;
        n = g[0].length;

        int ans = Integer.MAX_VALUE;

     
        ans = Math.min(ans, minArea(0, m - 1, 0, n - 1));

       
        for (int c = 0; c < n - 1; c++) {
            int left  = minArea(0, m - 1, 0, c);
            int right = minArea(0, m - 1, c + 1, n - 1);
            ans = Math.min(ans, left + right);
        }
      
        for (int r = 0; r < m - 1; r++) {
            int top    = minArea(0, r, 0, n - 1);
            int bottom = minArea(r + 1, m - 1, 0, n - 1);
            ans = Math.min(ans, top + bottom);
        }

     
        for (int c1 = 0; c1 < n - 2; c1++) {
            for (int c2 = c1 + 1; c2 < n - 1; c2++) {
                int a = minArea(0, m - 1, 0, c1);
                int b = minArea(0, m - 1, c1 + 1, c2);
                int c = minArea(0, m - 1, c2 + 1, n - 1);
                ans = Math.min(ans, a + b + c);
            }
        }
        for (int r1 = 0; r1 < m - 2; r1++) {
            for (int r2 = r1 + 1; r2 < m - 1; r2++) {
                int a = minArea(0, r1, 0, n - 1);
                int b = minArea(r1 + 1, r2, 0, n - 1);
                int c = minArea(r2 + 1, m - 1, 0, n - 1);
                ans = Math.min(ans, a + b + c);
            }
        }

      
        for (int c = 0; c < n - 1; c++) {
            for (int r = 0; r < m - 1; r++) {
                
                int left  = minArea(0, m - 1, 0, c);
                int rtTop = minArea(0, r, c + 1, n - 1);
                int rtBot = minArea(r + 1, m - 1, c + 1, n - 1);
                ans = Math.min(ans, left + rtTop + rtBot);

                int right = minArea(0, m - 1, c + 1, n - 1);
                int lfTop = minArea(0, r, 0, c);
                int lfBot = minArea(r + 1, m - 1, 0, c);
                ans = Math.min(ans, right + lfTop + lfBot);

                int top    = minArea(0, r, 0, n - 1);
                int btLeft = minArea(r + 1, m - 1, 0, c);
                int btRt   = minArea(r + 1, m - 1, c + 1, n - 1);
                ans = Math.min(ans, top + btLeft + btRt);

                int bottom = minArea(r + 1, m - 1, 0, n - 1);
                int tpLeft = minArea(0, r, 0, c);
                int tpRt   = minArea(0, r, c + 1, n - 1);
                ans = Math.min(ans, bottom + tpLeft + tpRt);
            }
        }

        return ans;
    }
}
