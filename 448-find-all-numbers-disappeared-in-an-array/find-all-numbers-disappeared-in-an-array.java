class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Mark indices as negative for seen numbers
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // convert value to index
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // mark as visited
            }
        }
        
        // Step 2: Collect indices that are still positive → missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
