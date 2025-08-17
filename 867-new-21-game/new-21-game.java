class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0||n>=k+maxPts)
        {
            return 1.0;
        }
        double dp[]=new double[n+1];
        dp[0]=1.0;
        double windosum=1.0;
        double result=0.0;
        for(int i=1;i<=n;i++)
        {
            dp[i]=windosum/maxPts;
        
        if(i<k)
        {
            windosum+=dp[i];
        }
        else
        {
            result+=dp[i];
        }
        if(i-maxPts>=0)
        {
            windosum-=dp[i-maxPts];
        }
    }
    return result;
        
    }
}