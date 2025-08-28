class Solution {
    public void moveZeroes(int[] nums) {
        int interpos=0;
        for(int num:nums)
        {
            if(num!=0)
            {
                nums[interpos++]=num;
            }
        }
        while(interpos<nums.length)
        {
            nums[interpos++]=0;
        }
        
    }
}