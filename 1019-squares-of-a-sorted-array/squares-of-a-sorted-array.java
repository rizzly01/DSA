class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[]=new int[nums.length];
        int left=0;
        int right=nums.length-1;
        for(int i=result.length-1;i>=0;i--)
        {
            int leftmost=nums[left]*nums[left];
            int rightmost=nums[right]*nums[right];
            if(leftmost>rightmost)
            {
                result[i]=leftmost;
                left++;
            }
            else
            {
                result[i]=rightmost;
                right--;
            }
        }
        return result;
        
    }
}