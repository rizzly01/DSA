class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] height = new int[m][n];
        
   
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == 0) height[i][j] = 0;
                else height[i][j] = (i == 0 ? 1 : height[i-1][j] + 1);
            }
        }
        
        int total = 0;
       
        for (int i = 0; i < m; i++) {
            total += countFromRow(height[i]);
        }
        return total;
    }
    
    private int countFromRow(int[] heights) {
        int n = heights.length;
        int[] sum = new int[n];
        int res = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + heights[j] * (j - prev);
            } else {
                sum[j] = heights[j] * (j + 1);
            }
            
            stack.push(j);
            res += sum[j];
        }
        return res;
    }
}
