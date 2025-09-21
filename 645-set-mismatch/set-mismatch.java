class Solution {
    public int[] findErrorNums(int[] nums) {

        int n=nums.length;
        boolean[] seen=new boolean[n+1];
        int duplicate=-1;
        int mismatch=-1;

        for(int num:nums)
        {
            if(seen[num])
            {
                duplicate=num;
            }
            else
            {
                seen[num]=true;
            }
        }

        for(int i=1;i<=n;i++)
        {
            if(!seen[i])
            {
                mismatch=i;
                break;
            }
        }

        return new int[] {duplicate,mismatch};
        
    }
}