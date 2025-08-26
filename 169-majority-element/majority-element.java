class Solution {
    public int majorityElement(int[] nums) {
        int start=nums[0];
        int count=0;
        for(int num:nums)
        {
                if(count==0)
                {
                    start=num;
                }
                count+=(start==num)?1:-1;
        }
        return start;
        
    }
}